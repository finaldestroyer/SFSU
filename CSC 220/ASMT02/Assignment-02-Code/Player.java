/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Player.java
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

import java.util.ResourceBundle;

public final class Player extends Person {

    private String firstName = null;
    private String email = null;
    private Club club = null;
    private String position = null;
    private String number = null;
    private String batSide = null;
    private String throwSide = null;
    private String mlbDebut = null;

    public Player() {
    }
    public Player(Club club) {
        super();
        final ResourceBundle bundle = ResourceBundle.getBundle("assignment02PartB.resources.PlayerInfo");
        this.setFirstName(bundle.getString("firstName"));
        this.setLastName(bundle.getString("lastName"));
        this.club = club;
        position = bundle.getString("position");
        number = bundle.getString("number");
        batSide = bundle.getString("batSide");
        throwSide = bundle.getString("throwSide");
        mlbDebut = bundle.getString("mlbDebut");
    }

    @Override
    public String getFirstName() {
        return firstName;
    }
    @Override
    public String getEmail() {
        return email;
    }
    public Club getClub() {
        return club;
    }
    @Override
    public void sayDialogue(String phrase) {
        System.out.printf("%s: %s%n", toString(), phrase);
    }

    @Override
    protected void setFirstName(String firstName) {
        final ResourceBundle bundle = ResourceBundle.getBundle("assignment02PartB.resources.PlayerInfo");
        this.setFirstName(bundle.getString("firstName"));
    }

    @Override
    protected void setLastName(String lastName) {
        final ResourceBundle bundle = ResourceBundle.getBundle("assignment02PartB.resources.PlayerInfo");
        this.setLastName(bundle.getString("lastName"));
    }

    @Override
    public void sayPrompt() {
        System.out.println(toString());
    }

    @Override
    public void sayGreeting(String string) {

    }

    public void displayInfo() {
        final ResourceBundle bundle = Messenger.getConfig().getLang().getBundle("Player");
        String[] fields = {
                bundle.getString("player.label"),
                bundle.getString("club.label"),
                bundle.getString("position.label"),
                bundle.getString("number.label"),
                bundle.getString("batSide.label"),
                bundle.getString("throwSide.label"),
                bundle.getString("mlbDebut.label")
        };
        String[] values = {
                super.toString(),
                club.getOfficialName(),
                position,
                number,
                batSide,
                throwSide,
                mlbDebut
        };
        ChatSession.printTable(fields, values);
    }

}
