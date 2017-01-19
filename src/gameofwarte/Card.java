package gameofwarte;

public class Card {

    private String faceName, suit;
    private int faceValue;

    public Card(String faceName, String suit, int faceValue) {
        this.faceName = faceName;
        setSuit(suit);
        setFaceValue(faceValue);
    }//

    private void setSuit(String suit) {
        if (suit.equalsIgnoreCase("spades") || suit.equalsIgnoreCase("diamonds")
                || suit.equalsIgnoreCase("clubs") || suit.equalsIgnoreCase("hearts")) {
            this.suit = suit;
        } else {
            throw new IllegalArgumentException(": suit must be hearts, diamonds, spades or clubs.");
        }
    }//

    private void setFaceValue(int faceValue) {
        if (faceValue <= 14 || faceValue <= 2) {
            this.faceValue = faceValue;
        } else {
            throw new IllegalArgumentException(": face value must be in range 2-14.");
        }
    }//

    @Override
    public String toString() {
        return faceName + " of " + suit;
    }//

    public int getFaceValue() {
        return faceValue;
    }//

    public String getFaceName() {
        return faceName;
    }//

    public String getSuit() {
        return suit;
    }//

    public String color() {
        switch(suit){
            case "Spades":
            case "Clubs":
                return "Black";
            
            default:
                return "Red";
        }
    }//
    
}//
