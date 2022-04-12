/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Club.java
 * @author: Duc Ta
 * @author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

import java.util.ResourceBundle;

public final class Club extends Organization {

    private String officialName;
    private String established;
    private String[] colors;
    private String ballpark;
    private String numberOfWorldSeriesTitles;
    private String numberOfNlPennants;
    private String numberOfDivisionTitles;
    private String numberOfWildCardBerths;
    private String[] owners;
    private President president;
    private GeneralManager generalManager;
    private Manager manager;

    public Club() {
        final ResourceBundle bundle = ResourceBundle
                .getBundle("assignment02PartB.resources.ClubInfo");
        officialName = bundle.getString("officialName");
        established = bundle.getString("established");
        colors = bundle.getString("colors").split(",");
        ballpark = bundle.getString("ballpark");
        numberOfWorldSeriesTitles = bundle.getString("numberOfWorldSeriesTitles");
        numberOfNlPennants = bundle.getString("numberOfNlPennants");
        numberOfDivisionTitles = bundle.getString("numberOfDivisionTitles");
        numberOfWildCardBerths = bundle.getString("numberOfWildCardBerths");
        owners = bundle.getString("owners").split(",");
        president = new President(
                bundle.getString("president.firstName"),
                bundle.getString("president.lastName"),
                this
        );
        generalManager = new GeneralManager(
                bundle.getString("generalManager.firstName"),
                bundle.getString("generalManager.lastName"),
                this
        );
        manager = new Manager(
                bundle.getString("manager.firstName"),
                bundle.getString("manager.lastName"),
                this
        );
    }
    public Club(String defaultClub) {

    }
    public Club(int yearEstablished, String[] owners, String[] colors, String officialName,
                String shortName) {
    }

    public static String getOfficialSong() {
        return null;
    }

    @Override
    public void displayAbout() {
        
    }

    @Override
    public void displayMission() {
    }
    @Override
    public String getOfficialName() {
        return officialName;
    }

    @Override
    public void sayDialogue(String clubWelcomeMessage) {

    }

    @Override
    public void displayInfo() {
        final ResourceBundle bundle = Messenger.getConfig().getLang().getBundle("Club");
        String[] fields = {
                bundle.getString("officialName.label"),
                bundle.getString("shortName.label"),
                bundle.getString("established.label"),
                bundle.getString("colors.label"),
                bundle.getString("ballpark.label"),
                bundle.getString("numberOfWorldSeriesTitles.label"),
                bundle.getString("numberOfNlPennants.label"),
                bundle.getString("numberOfDivisionTitles.label"),
                bundle.getString("numberOfWildCardBerths.label"),
                bundle.getString("owners.label"),
                bundle.getString("president.label"),
                bundle.getString("generalManager.label"),
                bundle.getString("manager.label")
        };
        String[] values = {
                officialName,
                established,
                String.join(", ", colors),
                ballpark,
                numberOfWorldSeriesTitles,
                numberOfNlPennants,
                numberOfDivisionTitles,
                numberOfWildCardBerths,
                String.join(", ", owners),
                president.toString(),
                generalManager.toString(),
                manager.toString()
        };
        ChatSession.printTable(fields, values);
    }

    @Override
    public void sayPrompt(String line) {
        System.out.println(officialName + ": " + line);
    }

    @Override
    public String getName() {
        return officialName;
    }

}