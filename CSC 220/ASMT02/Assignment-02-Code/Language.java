/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Language.java
 * @author: Duc Ta
 * @aAuthor: Japheth Wun
 *************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

// java.util.ResourceBundle
// - ResourceBundle is a valid approach to internationalization.
// - ResourceBundle is not required.
// - Other approaches to internationalization are available. Some of these approaches are
// more straightforward and more relevant to new CSC 220 students then ResourceBundle is.
// - Yet, curiosity for intelligence is always highly encouraged:
// https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/ResourceBundle.html

public final class Language {
    private String spokenLanguage = "ENGLISH";
    private static final String defaultLanguage = "ENGLISH";
    private static final String defaultAlienSound = "~ ąļīæń ~ "; // Default
    private static String AppName;
    private static String default_AppName = null;

    public Language() {
    }
    public Language(String language) {

        switch (language.toLowerCase()) {
            case "alien" -> this.populateAlienPhrases();            // Supported
            case "chinese" -> this.populateChinesePhrases();        // Future implementation
            case "french" -> this.populateFrenchPhrases();          // Future implementation
            case "spanish" -> this.populateSpanishPhrases();        // Future implementation
            case "future" -> this.populateYourLanguagePhrases();    // Future implementation
            default -> this.populateEnglishPhrases();               // Supported
        }
    }

    public static Language setLanguagePreference() {
        Language temp = null;
        temp.spokenLanguage = "ENGLISH";
        return temp;
    }
    public static void displayAppHeader() {
    }
    private void populateAlienPhrases() {

    }
    private void populateChinesePhrases() {
    }
    private void populateFrenchPhrases() {
    }
    private void populateSpanishPhrases() {
    }
    private void populateYourLanguagePhrases() {
    }
    private void populateEnglishPhrases() {
    }

    public String getGreetingPhrase(int i) {
        return null;
    }
    public Object getLanguage() {
        return spokenLanguage;
    }
    public Object getUniversityPhrase(int i) {
        return null;
    }
    public Object getClubPhrase(int i) {
        return null;
    }
    public String getConfigPhrase(int i) {
        return null;
    }
    public static String getOfficialAppName() {
        return AppName;
    }
}