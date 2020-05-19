public class Card 
{
    int cardValue;
    int cardSuit;
    String card = "";
    
    public Card(int value, int suit)
    {
        cardValue = value;
        cardSuit = suit;
    }

    public int getCardValue()
    {
        return cardValue; 
    }
    
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