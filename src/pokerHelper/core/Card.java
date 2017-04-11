package pokerHelper.core;


public class Card {
	private CardSuit suit;
	private CardRank rank;
	
	public Card(CardSuit toCardSuit,CardRank toCardRank){
		suit = toCardSuit;
		rank = toCardRank;
	}
	
	public Card(int toCardSuit,int toCardRank){
		suit = new CardSuit(toCardSuit);
		rank = new CardRank(toCardRank);
	}

	public int getSuit(){
		return suit.getSuit();
	}
	
	public int getRank(){
		return rank.getRank();
	}
	
	public String getSuitName(){
		return suit.getSuitName();
	}
	
	public String getRankName(){
		return rank.getRankName();
	}
	
	
}
