package pokerHelper.brain.evalEngine;

import pokerHelper.core.CardRank;
import java.util.*;
import java.io.*;
import pokerHelper.core.*;

public class PokerEvaluator extends ArrayList{
	
	private int flushSuit;
	
	public PokerEvaluator(File dagfile){
		BufferedReader br;
		try{
			String line;
			int cntr = 0;
			br = new BufferedReader(new FileReader(dagfile));
			while ((line = br.readLine()) != null){
				this.add(cntr++, new DAGNode(line));
				//System.out.println("processing: "+cntr+" "+line);
			}
		}catch (IOException e){
			System.out.println("IO Error:");
			e.printStackTrace();
		}
	}
	
	public String evaulateHand(Hand hand){
		
		if (isFlushPreset(hand)){
			return evaluateFlushHand(hand);
		}
		DAGNode dagnode = null;
		int nextNodeIndex = getDAGNode(hand.getCard(0).getRank()).dagIndex;
		
		for (int i=1; i <= 6; i++){
			int cRank = hand.getCard(i).getRank();
			dagnode = getDAGNode(nextNodeIndex);
			nextNodeIndex = getDAGNode(nextNodeIndex).getNextIndex(cRank);
		}
		dagnode = this.getDAGNode(nextNodeIndex);
		return dagnode.handName;
	}
	
	public DAGNode getDAGNode(int index){
		return (DAGNode)super.get(index);
	}
	
	private String evaluateFlushHand(Hand hand){
		DAGNode dagnode = null;
		int nextNodeIndex = -1;
		int startIndex = 0;
		
		//System.out.println(hand.getHandName());
		
		while ( hand.getCard(startIndex).getSuit() != flushSuit ){
			startIndex++;
		}
		nextNodeIndex = getDAGNode(hand.getCard(startIndex).getRank()).dagIndex;
		
		for (int i=startIndex++; i <= 6; i++){
			int cRank = hand.getCard(i).getRank();
			dagnode = getDAGNode(nextNodeIndex);
			nextNodeIndex = getDAGNode(nextNodeIndex).getNextIndex(cRank);
		}
		dagnode = this.getDAGNode(nextNodeIndex);
		return dagnode.handName;	
	}
	
	private boolean isFlushPreset(Hand hand){
		int suitStat[] = {0,0,0,0};
		for (int i=0; i <= 6; i++){
			if ( suitStat[hand.getCard(i).getSuit()] == 4 ){
				flushSuit =  hand.getCard(i).getSuit();
				return true;
			}
			suitStat[hand.getCard(i).getSuit()]++;
		}
		return false;
	}
}
