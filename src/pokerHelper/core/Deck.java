package pokerHelper.core;

import java.util.*;

public class Deck extends ArrayList{
	
	public Deck(){
		int cntr = 0;
		for (int i=0; i <= CardSuit.validSuits.length-1; i++){
			for (int j=0; j <= CardRank.validRanks.length-1; j++){
				CardSuit c = new CardSuit(CardSuit.validSuits[i]);
				CardRank v = new CardRank(CardRank.validRanks[j]);
				super.add(cntr, new Card(c, v));
				cntr++;
			}
		}
	}
	
	public Card getCardAt(int index){
		return (Card)this.get(index);
	}
	
	public Card removeRandomCard(){
		Random r = new Random();
		int randomIndex = r.nextInt(this.size());
		return (Card)this.remove(randomIndex); 
	}
}
