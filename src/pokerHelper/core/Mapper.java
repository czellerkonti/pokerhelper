package pokerHelper.core;

import java.util.*;

public class Mapper extends HashMap {
	
	public Mapper(int[] key, String[] value){
		for (int i=0; i<=key.length-1; i++){
			super.put(key[i], value[i]);
		}
	}
	
	public int getKey(String value){
		Collection c = super.values();
		Iterator i = c.iterator();
		int cntr = 0;
		while (i.hasNext()){
			if (i.next().equals(value)) return cntr;
			cntr++;
		}
		return -1;
	}
}
