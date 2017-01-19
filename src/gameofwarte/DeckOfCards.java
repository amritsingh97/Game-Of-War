package gameofwarte;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;

public class DeckOfCards {

    private final ArrayList<Card> deck;

    public DeckOfCards() {
        deck = new ArrayList();

        String[] suits = {"Spades", "Hearts", "Clubs", "Diamonds"};
        String[] faceNames = {"Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};

//        for (int i = 0; i < 52; i++) {
//            Card card = new Card(faceNames[i % 13], suits[i / 13], i % 13 + 2);
//            deck.add(card);
//        }
        for (String suit : suits) {
            for (int i = 0; i < faceNames.length; i++) {
                Card card = new Card(faceNames[i], suit, i + 2);
                deck.add(card);
            }
        }
//        System.out.println(deck);
//        System.out.println(deck.size());

    }//

    @Override
    public String toString() {
        String cards = "";
        for (Card card : deck) {
            cards += card.toString() + "\n";
        }
        return cards;
    }

    /**
     * This method will 'shuffle' the deck of cards, 
     * changing the current order of the cards
     */
    public void shuffle() {
        
        Collections.shuffle(deck);
        
        SecureRandom random = new SecureRandom();
        Card c;
        for (int i = 0; i < deck.size(); i++) {
            int r = random.nextInt(52);
            c = deck.get(r);
            deck.set(r, deck.get(i));
            deck.set(i, c);
        }
    }//

    public Card dealTopCard() {
        
        return deck.remove(0);
        
    }//

}//
