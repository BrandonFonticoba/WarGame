/* 
Brandon Fonticoba--Deacom HW

Simple class to build a Card object
with suit and card value

*/

public class Card 
{

    //Card Number Value
    int cardValue;

    //Card Suit assigned through ints
    int cardSuit;

    //String to build display card
    //Ex: 4 of Hearts
    String card = "";
    

    //Constructor to make a card with a value and suit.
    public Card(int value, int suit)
    {
        cardValue = value;
        cardSuit = suit;
    }

    //Obtain access to the card value.
    public int getCardValue()
    {
        return cardValue; 
    }
    
    //Display the card in string format.
    public String displayCard()
    {
        card = "";
        
        switch(cardValue)
        {
            case 11:
                card+= "J";
                break;
            case 12:
                card+= "Q";
                break;
            case 13:
                card+= "K";
                break;
            case 14:
                card+= "A";
                break;    
            default:
                card+= String.valueOf(cardValue); 
                break;
        }
        
        switch(cardSuit){
            case 0:
                card+= " of Clubs";
                break;
            case 1:
                card+= " of Diamonds";
                break;
            case 2:
                card+= " of Spades";
                break;
            case 3:
                card+= " of Clovers";
                break;
            default:
                break;
        }
    
        return card;
    }   
}