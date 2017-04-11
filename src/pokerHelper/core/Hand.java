
package pokerHelper.core;

import java.util.*;

public class Hand extends ArrayList {
	
	public Hand(Card initCards[]){
		Card [] cards = sortCards(initCards);
		for (int i=0; i <= cards.length-1; i++){
			super.add(cards[i]);
		}
	}
	
	public Hand(){
		super();
	}
	
	public Card getCard(int i){
		return (Card)super.get(i);
	}

	public String getHandName(){
		Iterator it = this.iterator();
		String returnString = new String("");
		while (it.hasNext()){
			Card c = (Card)it.next();
			returnString = returnString + " " +c.getSuitName() +"."+ c.getRankName();
		}
		return returnString;
	}
	
	public static Card[] sortCards(Card cardsToSort[]){
		Card tmpcard;
		for (int i=cardsToSort.length-1; i>=0; i--){
			for (int j=0; j<=i-1; j++){
				if(cardsToSort[j].getRank() > cardsToSort[j+1].getRank()){
				tmpcard = cardsToSort[j];
				cardsToSort[j] = cardsToSort[j+1];
				cardsToSort[j+1] = tmpcard;
				}
			}
		}
		return cardsToSort;
		
	}
}
