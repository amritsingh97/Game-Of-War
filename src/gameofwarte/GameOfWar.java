package gameofwarte;

import java.util.ArrayList;

public class GameOfWar {

    private final ArrayList<Card> p1Hand;
    private final ArrayList<Card> p2Hand;
    
    public GameOfWar () {
        p1Hand = new ArrayList();
        p2Hand = new ArrayList();
        
        DeckOfCards myDeck = new DeckOfCards();
        myDeck.shuffle();
        
        dealCards(myDeck);
    } //
    
    private void dealCards(DeckOfCards deck) {
        
        for (int cardNum = 0; cardNum < 52; cardNum++) {
            if (cardNum % 2 == 0) {
                p1Hand.add(deck.dealTopCard());
            } else {
                p2Hand.add(deck.dealTopCard());
            }
        }
    }
    
    public void playTheGame() {
        
        while (!p1Hand.isEmpty() && !p2Hand.isEmpty()) {
            playHand();
        }
        
        if (p1Hand.isEmpty()) {
            System.out.println("Player 2 WINS!");
        } else {
          System.out.println("Player 1 WINS!");  
        }  
    }
    
    private void playHand() {
        
        if (!p1Hand.isEmpty() || !p2Hand.isEmpty())
            return;
            
            
        Card p1Card = p1Hand.remove(0);
        Card p2Card = p2Hand.remove(0);
                
        if (p1Card.getFaceValue() > p2Card.getFaceValue()) {
            p1Hand.add(p1Card);
            p1Hand.add(p2Card);
        } else if (p1Card.getFaceValue() < p2Card.getFaceValue()) {
            p2Hand.add(p1Card);
            p2Hand.add(p2Card);
        } else {
            ArrayList<Card> warPile = new ArrayList();
            warPile.add(p1Card);
            warPile.add(p2Card);
            playWarHand(warPile);
        }
    }
    
    private void playWarHand(ArrayList<Card> warPile) {
        
        if (p1Hand.size() < 3) {
            p2Hand.addAll(p1Hand);
            p1Hand.clear();
            p2Hand.addAll(warPile);
            return;
        } 
        if (p2Hand.size() < 3) {
            p1Hand.addAll(p2Hand);
            p2Hand.clear();
            p1Hand.addAll(warPile);
            return;
        }
        
        warPile.add(p1Hand.remove(0));
        warPile.add(p1Hand.remove(0));
        Card p1Card = p1Hand.remove(0);
        
        warPile.add(p2Hand.remove(0));
        warPile.add(p2Hand.remove(0));
        Card p2Card = p2Hand.remove(0);
        
        if (p1Card.getFaceValue() > p2Card.getFaceValue()) {
            p1Hand.add(p1Card);
            p1Hand.add(p2Card);
            p1Hand.addAll(warPile);
        } else if (p1Card.getFaceValue() < p2Card.getFaceValue()) {
            p2Hand.add(p1Card);
            p2Hand.add(p2Card);
            p2Hand.addAll(warPile);
        } else {
            warPile.add(p1Card);
            warPile.add(p2Card);
            playWarHand(warPile);
        }
    }
    
} //
