package pokerHelper.core;


public class CardRank {
	private int rank = 0;
	static public String[] validRankNames = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"}; 
	static int[] validRanks = {0,1,2,3,4,5,6,7,8,9,10,11,12};
	static int numberOfRanks = validRanks.length;
	static  Mapper mapper = new Mapper(validRanks, validRankNames);
	
	
	public CardRank(String toCardRank) throws InvalidCardRankException {
		if (!isValidRank(toCardRank)){
			throw new InvalidCardRankException("unknown Rank1"+ toCardRank);
		}
		rank = mapper.getKey(toCardRank);
	}
	
	public CardRank(int toCardRank) throws InvalidCardRankException{
		if (toCardRank < validRanks[0] || toCardRank > validRanks[validRanks.length - 1] ){
			throw new InvalidCardRankException("unknown Rank2"+ toCardRank);
		}
		rank = toCardRank;
	}
	
	private boolean isValidRank(String rankToCheck){
		if (mapper.containsValue(rankToCheck))return true;
		return false;
	}
	
	public String getRankName(){
		return (String) mapper.get(rank);
	}
	
	public int getRank(){
		return rank; 
	}
	
	public static int getRank(String r){
		return mapper.getKey(r);
	}
	
}
