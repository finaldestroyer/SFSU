/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Card.java
 * @author: Duc Ta
 * @ * Author: Japheth Wun
 * **********************************************
 */

package assignment02PartB;
import java.util.InputMismatchException;
import java.util.ResourceBundle;
import java.util.Scanner;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class Card {

    private static final int MAX_RETRIES = 3;
    private int artSize = 0;     // Please change artSize, if needed, to get an identical output
    private String artFont = ""; // Please change artFont, if needed, to get an identical output
    private Player player = null;
    private Student student = null;
    private Scanner scan = null;
    private final ResourceBundle bundle = null;
    private String[][] cardParams;

    public Card() {
    }
    public Card(Player player, Student student, Scanner scan) {
        //bundle = Messenger.getConfig().getLang().getBundle("Card");
        this.player = player;
        this.student = student;
        this.scan = scan;
    }
    public String[][] getCardParams() {
        return cardParams;
    }
    private int promptCardAmount() throws InputMismatchException {
        for (int i = 0; i <= MAX_RETRIES; i++) {
            try {
                player.sayDialogue(bundle.getString("player.amountPrompt"));
                student.sayPrompt();
                return scan.nextInt();
            } catch (InputMismatchException e) {
                System.err.println(e);
                System.out.printf(bundle.getString("error.invalidInputTypeCardAmount"),
                        MAX_RETRIES - i);
            } finally {
                scan.nextLine();  // reset cursor
            }
        }
        throw new InputMismatchException(String.format("Exceeded %d retries.", MAX_RETRIES));
    }

    private String[][] promptCardParams(int amountOfCards) {
        String[][] params = new String[amountOfCards][3];

        // Instructions
        player.sayDialogue(bundle.getString("player.parameterPrompt"));
        System.out.printf("%4s[1] %s%n", "", bundle.getString("player.parameterPrompt.1"));
        System.out.printf("%4s[2] %s%n", "", bundle.getString("player.parameterPrompt.2"));
        System.out.printf("%4s[3] %s%n", "", bundle.getString("player.parameterPrompt.3"));

        // Prompt for each cards.
        for (int i = 0; i < amountOfCards; i++) {
            player.sayDialogue(String.format(bundle.getString("player.cardNumberPrompt"), i + 1));

            // Prompt for each fields.
            for (int j = 0; j < 3; j++) {
                student.sayPrompt();
                System.out.printf("[%d] ", j + 1);
                params[i][j] = scan.nextLine();
            }
        }
        player.sayDialogue(String.format(
                bundle.getString("player.confirmation"), student.getFirstName()));
        return params;
    }

    private void printCards() {
        SFGiantsCardGenerator generator = new SFGiantsCardGenerator();
        final String firstName = student.getFirstName();
        final String email = student.getEmail();

        for (String[] card : cardParams) {
            final String recipient = card[0];
            final char artSymbol = card[1].charAt(0);
            final String message = card[2];

            try {
                System.out.println();
                generator.generateSFGiantsCard(recipient, message, firstName, email,
                        artSymbol, artSize, artFont);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    public void runCardWizard() {
        int cardAmount = promptCardAmount();
        cardParams = promptCardParams(cardAmount);
        printCards();
    }
}
