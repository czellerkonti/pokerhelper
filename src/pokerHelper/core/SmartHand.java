package pokerHelper.core;

import java.util.*;


public class SmartHand extends Hand {

	public static int NONE = 0;
	public static int ONE_PAIR = 1;
	public static int TWO_PAIR = 2;
	public static int THREE_OF_A_KIND = 3;
	public static int STRAIGHT = 4;
	public static int FLUSH = 5;
	public static int FULL_HOUSE = 6;
	public static int FOUR_OF_A_KIND = 7;
	public static int STRAIGHT_FLUSH = 8;
	public static int ROYAL_FLUSH = 9;
	
	private int highestCardIndex = 0;
	private HashMap suitStat = new HashMap();
	
	
	public SmartHand(Card[] initCards) {
		super(initCards);
	}
	
	
	
	

}
