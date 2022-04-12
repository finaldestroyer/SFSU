/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: ChatSession.java
 * @author: Duc Ta
 * @ * Author: Japheth Wun
 * **********************************************
 */

package assignment02PartB;
import java.util.ResourceBundle;
import java.util.Scanner;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"


public final class ChatSession {

    private static final int CHAT_DELAY_MS = 0;

    private static final int LINE_SEP_WIDTH = 66;
    private static final String LINE_SEP = "-".repeat(LINE_SEP_WIDTH);
    private static final Scanner scan = new Scanner(System.in);

    private Club club = null;
    private University university = null;
    private ResourceBundle bundle = null;
    private Student student;
    private Player player;
    private Receipt receipt;

    public ChatSession(){
    }
    public ChatSession(Club club, University university) {
        this.club = club;
        this.university = university;
        this.bundle = Messenger.getConfig().getLang().getBundle("ChatSession");
    }
    public ChatSession(Club club, University university, ResourceBundle bundle) {
        this.club = club;
        this.university = university;
        this.bundle = bundle;
    }

    public static void printTable(String[] fields, String[] values) {
        for (int i = 0; i < fields.length; i++) {
            System.out.printf("%-25s %s%n", fields[i] + ":", values[i]);
        }
    }

    public static String getLineSep() {
        return LINE_SEP;
    }

    public static void printLineSep() {
        System.out.println(LINE_SEP);
    }

    private void startChatSession() {
        System.out.println(generateTimestamp(bundle.getString("ts.sessionStart")));
        fakeChatDelay();
        System.out.println();

        club.sayDialogue(String.format(bundle.getString("clubWelcomeMessage"),
                club.getOfficialName().toUpperCase()));
        printLineSep();

        club.displayInfo();
        printLineSep();
        System.out.println();
        student = getStudentInfo();
        ;

        club.sayDialogue(bundle.getString("preChat.connecting"));
        fakeLoading();
    }
    private void chat() {
    }
    private void runQuiz() {
        Quiz quiz = new Quiz(club, student);
        quiz.runQuiz();
        receipt.setQuiz(quiz);
    }
    private void stopChatSession() {
        System.out.println(generateTimestamp(bundle.getString("ts.sessionEnd")));
        receipt.writeReceipt();
    }
    public void runChatSession() {
        this.startChatSession();
        this.connectChatters();
        this.runQuiz();
        this.stopChatSession();
    }
    public static String getAppBanner() {
        return (LINE_SEP + "\n" + "-".repeat(19) + " " + Language.getOfficialAppName() + " " + "-".repeat(26) + "\n" + LINE_SEP);
    }
    public static String readStringIn() {
        return scan.nextLine().strip();
    }
    public static String generateTimestamp(String msg) {
        return String.format("%s - %s", Messenger.getConfig().getTimer().getChatTimestamp(), msg);
    }
    private static void fakeLoading() {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.print(". ");
                Thread.sleep(CHAT_DELAY_MS);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
        System.out.println();
    }

    private static void fakeChatDelay() {
        try {
            Thread.sleep(CHAT_DELAY_MS);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }
    private Student getStudentInfo() {
        club.sayPrompt(bundle.getString("preChat.namePrompt"));
        String[] name = readStringIn().split("\\s", 2);
        club.sayPrompt(bundle.getString("preChat.emailPrompt"));
        String email = readStringIn();
        if (name.length == 1) {
            return new Student(name[0], university, email);
        }
        return new Student(name[0], name[1], university, email);
    }
    private void connectChatters() {
        player = new Player(club);
        receipt = new Receipt(student, player);
        String firstName = student.getFirstName();
        printLineSep();
        player.displayInfo();
        printLineSep();
        fakeLoading();

        player.sayDialogue(String.format(bundle.getString("player.greeting"), firstName));
        fakeChatDelay();
        player.sayDialogue(String.format(
                bundle.getString("player.universityEmphasis"),
                Color.sfsuHighlight(university.getName().toUpperCase())
        ));
        fakeChatDelay();
        student.sayPrompt();
        readStringIn();
        fakeChatDelay();
        player.sayDialogue(String.format(bundle.getString("player.likewiseResponse"), firstName));
        fakeChatDelay();

        Card card = new Card(player, student, scan);
        card.runCardWizard();
        receipt.setCard(card);

        student.sayPrompt();
        readStringIn();
        fakeChatDelay();
        player.sayDialogue(String.format(bundle.getString("player.card.thankYou"), firstName));
        fakeChatDelay();
        System.out.println();
    }
}