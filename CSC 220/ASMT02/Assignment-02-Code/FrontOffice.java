/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: FrontOffice.java
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

// JAVA 15, 2020, added "sealed" and "permits" to Java classes.
// We are learning the new elements of JAVA 15.
// "sealed" and "permits" are used here so that we will have one more example to reference.
// We do not need to understand "sealed" and "permits" in order to start and complete this assignment.
public final class FrontOffice {
    private Club club;

    public FrontOffice() {
    }
    public FrontOffice(String firstName, String lastName, Club club) {
        this.club = club;
    }
    public Club getClub() {
        return this.club;
    }
    public void setClub(Club club) {
        this.club = club;
    }
    public String displayInfo(){
        return null;
    }

}