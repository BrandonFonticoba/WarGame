/* 
Brandon Fonticoba
This program simulates the card game of war.
*/

import java.util.ArrayList;      
import java.util.Collections;      

public class War
{
    public static void main(String[] args) 
    {

        //List for all 52 cards.
        ArrayList<Card> deck = new ArrayList<Card>();

        //Building the Deck with 4 suits, and 2-14 values. 11-14 = J, Q, K, A.
        for(int i = 0; i < 4; i++)
        {
            for(int j = 2; j < 15; j++)
            {
                deck.add(new Card(j, i));
            }
        }

        //Randomize the deck list.
        Collections.shuffle(deck);

        //List for player1 hand and player2 hand.
        ArrayList<Card> playerOne = new ArrayList<Card>();
        ArrayList<Card> playerTwo = new ArrayList<Card>();

        //Each player's deck gets 26 cards.
        playerOne.addAll(deck.subList(0,26));
        playerTwo.addAll(deck.subList(26, 52));

        //Round counter.
        int round = 1;

        //Play until someone wins.
        while(true)
        {
            //Each player takes one card from the top of their deck.
            Card c1 = playerOne.remove(0);
            Card c2 = playerTwo.remove(0);

            System.out.println("****ROUND " + round + "****");
            System.out.println(c1.displayCard() + " (VS) " + c2.displayCard());


            //Check whether player1's card has a higher value.
            if(checkCards(c1, c2) == 1)
            {
                System.out.println("Player 1 Wins");
                playerTwo.add(c2);
                playerTwo.add(c1);
                round++;
            }

            //Check whether player2's card has a higher value.
            else if(checkCards(c1, c2) == 2)
            {
                System.out.println("Player 2 Wins");
                playerOne.add(c1);
                playerOne.add(c2);
                round++;
            }

            //Otherwise they are equal, and war mode starts.
            else
            {

                //Creating a new list for the war cards.
                ArrayList<Card> warListOne = new ArrayList<Card>();
                ArrayList<Card> warListTwo = new ArrayList<Card>();


                //Checking if both players have enough cards for war mode.
                if(playerOne.size() >= 4 && playerTwo.size() >= 4)
                {    
                    //Each player has to draw 3 cards from their deck.
                    for(int i = 0; i < 3; i++)
                    {
                        if(playerOne.size() == 0 || playerTwo.size() == 0)
                            break;
                        warListOne.add(playerOne.remove(0));
                        warListTwo.add(playerTwo.remove(0));
                    }

                    //Keep track of when war mode is over.
                    boolean finishedWar = false;

                    //draw a fourth card to fight against the other player.
                    //if those cards are equal draw another one.
                    do
                    {
                        if(playerOne.size() == 0 || playerTwo.size() == 0)
                            break;
                        Card warC1 = playerOne.remove(0);
                        Card warC2 = playerTwo.remove(0);
                        warListOne.add(warC1);
                        warListTwo.add(warC2);

                        //Check whether player1's card has a higher value.
                        if(checkCards(warC1, warC2) == 1)
                        {
                            System.out.println("Player 1 Wins");
                            playerTwo.add(c1);
                            playerTwo.add(c2);
                            Collections.shuffle(warListOne);
                            Collections.shuffle(warListTwo);
                            playerTwo.addAll(warListOne);
                            playerTwo.addAll(warListTwo);
                            finishedWar = true;
                            round++;
                        }
                        
                        //Check whether player2's card has a higher value.
                        else if(checkCards(warC1, warC2) == 2)
                        {
                            System.out.println("Player 2");
                            playerOne.add(c1);
                            playerOne.add(c2);
                            Collections.shuffle(warListOne);
                            Collections.shuffle(warListTwo);
                            playerOne.addAll(warListOne);
                            playerOne.addAll(warListTwo);
                            finishedWar = true;
                            round++;
                        }
                    }while(finishedWar == false);
                } 
                
                //One player doesn't have enough cards for war
                //giving them the victory for getting rid of their cards first.
                else if(playerOne.size() < playerTwo.size())
                    playerOne.clear();

                else
                    playerTwo.clear();
            }


            //if player1 runs out of cards they win.
            if(playerOne.size() < 1)
            {
                System.out.println("---GAME OVER----\nPlayer 1 Ran Out of Cards First");
                break;
            }

            //if player2 runs out of cards they win.
            else if(playerTwo.size() < 1)
            {
                System.out.println("---GAME OVER----\nPlayer 2 Ran Out of Cards First");
                break;
            }
        }
    }

    public static int checkCards(Card card1, Card card2)
    {
        //if card1 has a higher value than card2 return a 1.
        if(card1.getCardValue() > card2.getCardValue())
            return 1;
        
        //if card2 has a higher value than card1 return a 2.
        else if(card1.getCardValue() < card2.getCardValue())
            return 2;

        else
            return 3;
    }

}
