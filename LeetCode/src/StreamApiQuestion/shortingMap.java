package StreamApiQuestion;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class shortingMap {
	public static void main(String[] args) {
		HashMap<Integer, Integer> hasmap = new HashMap<>();
			hasmap.put(0, 34);
			hasmap.put(1, 732);
			hasmap.put(2, 687);
			hasmap.put(3, 387);
			hasmap.put(4, 876);
			hasmap.put(5, 875);
			hasmap.put(6, 847);
			hasmap.put(7, 37);
			hasmap.put(8, 7);
		sortingMap(hasmap);
	}
	public static void sortingMap(HashMap<Integer, Integer> hp) {
		LinkedHashMap<Integer, Integer> lhp = hp.entrySet()
				.stream().sorted((o1, o2) ->o1. ).
	}
}
