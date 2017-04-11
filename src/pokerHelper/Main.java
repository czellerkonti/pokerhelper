package pokerHelper;

import pokerHelper.core.Deck;
import pokerHelper.core.Card;
import pokerHelper.brain.evalEngine.*;
import java.io.File;
import pokerHelper.core.Hand;
import java.math.*;

public class Main {

	public static void main(String[] args) {
		long cntr = 0;
		File f = new File("/home/konti/carddag");
		PokerEvaluator pe = new PokerEvaluator(f);
		
		System.out.println("DAG built!");
		/*
		Deck ddeck = new Deck();
		Card ccards[] = new Card[7];
		for (int i=0; i <= 6; i++){
			ccards[i] = ddeck.removeRandomCard();
			System.out.print(ccards[i].getSuitName() +"."+ ccards[i].getRankName()+" ");
		}
		System.out.println();
		Hand hhand = new Hand(ccards);
		System.out.println(pe.evaulateHand(hhand));
		*/
		
		long duration = 0;
		while ( cntr != 3000001 ){
			
			Deck deck = new Deck();
			Card cards[] = new Card[7];
			for (int i=0; i <= 6; i++){
				cards[i] = deck.removeRandomCard();
			}
			Hand hand = new Hand(cards);
			long start = System.nanoTime();
			pe.evaulateHand(hand);
			duration = duration + (System.nanoTime() - start);
			cntr++;
			}
		System.out.println(cntr+" hands processed in "+duration/1000000000+" secs");
		
	}
}

