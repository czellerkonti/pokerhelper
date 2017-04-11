	package pokerHelper.brain.evalEngine;

import pokerHelper.core.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class DAGNode{
	
	int dagIndex;
	int nextIndexes[] = new int[13];
	String handName;
	String flushIndex;
	String fiveCardIndex;
	
	public DAGNode(String line){
		StringTokenizer st = new StringTokenizer(line);
		dagIndex = Integer.parseInt(st.nextToken());
		for (int i=0; i <= 12; i++){
			nextIndexes[i] = Integer.parseInt(st.nextToken());
		}
		flushIndex = st.nextToken();
		fiveCardIndex = st.nextToken();
		handName = st.nextToken();
	}
	
	public int getNextIndex(int childNodeIndex){
		return nextIndexes[childNodeIndex];
	}
	
	
}
