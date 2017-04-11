package pokerHelper.core;


public class CardSuit {
	private int suit = 0;
	static String[] validSuitNames = {"coeur", "pique", "carreau", "trefle"};
	static int numberOfSuits = 4;
	static int[] validSuits = {0,1,2,3}; 
	static Mapper mapper = new Mapper(validSuits, validSuitNames);
	
	/*
	static String COEUR = "coeur";
	static String PIQUE = "pique";
	static String CARREAU = "carreau";
	static String TREFLE = "trefle";
	*/
	
	public CardSuit(String toCardSuit) throws InvalidCardSuitException{
		if (isValidSuit(toCardSuit)){
			suit = mapper.getKey(toCardSuit);			
		}else{
			throw new InvalidCardSuitException("Unknown card suit: "+toCardSuit);
		}
	}
	
	public CardSuit(int toCardSuit){
		suit = toCardSuit;
	}
	
	static private boolean isValidSuit(String suitToCheck){
		if (mapper.containsValue(suitToCheck))return true;
		return false;
	}
	
	public int getSuit(){
		return suit;
		
	}
	
	public String getSuitName(){
		return (String) mapper.get(suit);
	}
}
