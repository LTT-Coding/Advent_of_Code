package advent_of_code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Day7_HandyHaversacks {

	public static void main(String[] args) throws IOException {
		List<String> StringList = new ArrayList<String>();
		HashMap<String, List<String>> bags = new HashMap<String, List<String>>();
		HashMap<String, Integer> bagCounter = new HashMap<String, Integer>(); 
		FileReader fr = new FileReader("C:/Users/Sascha-Zimmer/Desktop/test.txt");
		BufferedReader br = new BufferedReader(fr);

		String zeile = "";

		while ((zeile = br.readLine()) != null) {
			StringList.add(zeile);
		}

		for (String string : StringList) {
			List<String> words = new ArrayList<String>();
			String word = "";
			for (char current : string.toCharArray()) {
				if (current != ' ' && current != ',') {
					word += current;
				} else if (!word.isEmpty()) {
					words.add(word);
					word = "";
				}
			}
			String bag = words.get(0) + words.get(1);
			List<String> bagContent = new ArrayList<String>();
			for (int i = 0; i < words.size(); i++) {
				if (isInt(words.get(i))) {
					bagContent.add(words.get(i) + words.get(i + 1) + words.get(i + 2));
				}
			}
			bags.put(bag, bagContent);
		}
		
		List<String> keys = new ArrayList<String>();
		/*for (String key : bags.keySet()) {
			for (String value : bags.get(key)) {
				if(value.contains("shinygold")) { 
					keys.add(key);
				}
			}
		}
		boolean firstStart = false;
		for(int i = 0; i < keys.size() || firstStart == false; i++) {
			firstStart = true;
			String target = keys.get(i);
			for (String key1 : bags.keySet()) {
				for (String value1 : bags.get(key1)) {
					if(value1.contains(target)) {
						if(!keys.contains(key1)) {
							keys.add(key1);
						}
					}
				}
			}
		}
		
		System.out.println("Teil 1: " + keys.size());
		keys.clear();*/
		// Teil 2

		for (String string : bags.get("shinygold")) {
			keys.add(string);
		}
		
		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i).replaceFirst(String.valueOf(keys.get(i).charAt(0)), "");
			int zahl = 0;
			for (String string : bags.get(key)) {
				keys.add(string);
				int zahl2 = Integer.parseInt(String.valueOf(string.charAt(0)));
				zahl+=zahl2;
			}
			bagCounter.put(key, zahl);
		}
		
		//Berechnung GEHT NOCH NICHT WEIL -> mehrere Verzweigungen nicht so wie in Beispiel
		int zahl2 = Integer.parseInt(String.valueOf(keys.get((keys.size() - 1)).charAt(0)));
		int counter = zahl2;
		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i).replaceFirst(String.valueOf(keys.get(i).charAt(0)), "");
			int zahl23 = Integer.parseInt(String.valueOf(keys.get(i).charAt(0)));
			counter = counter + zahl23 + (bagCounter.get(key)* zahl23);
		}
		
		/*for (String string : keys) {
			String key = string.replaceFirst(String.valueOf(string.charAt(0)), "");
			int zahl = Integer.parseInt(String.valueOf(string.charAt(0)));
			counter = counter + zahl + (zahl*bagCounter.get(key));
		}*/
		
		System.out.println(bagCounter);
		System.out.println(keys);
		System.out.println("Teil 2:" + counter);
		
	}

	public static boolean isInt(String string) {
		try {
			Integer.parseInt(string);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}

/*		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i).replaceFirst(String.valueOf(keys.get(i).charAt(0)), "");
			int zahl = 0;
			for (String value : bags.get(key)) {
				keys.add(value);
				zahl+= Integer.parseInt(String.valueOf(value.charAt(0)));
			}
			bagCounter.put(key, zahl);
		}
		
		for (String string : keys) {
			String key = string.replaceFirst(String.valueOf(string.charAt(0)), "");
			int zahl = Integer.parseInt(String.valueOf(string.charAt(0)));
			for (String value : bags.get(key)) {
				int zahl2 = Integer.parseInt(String.valueOf(value.charAt(0)));
				String key2 = string.replaceFirst(String.valueOf(value.charAt(0)), "");
				System.out.println(key + " " + value + " " + zahl2);
				if(bagCounter.get(key2) != null) {
					zahl = zahl + (zahl2 * bagCounter.get(key2));
				} else zahl+= zahl2;
			}
			counter+= zahl;
			
		}*/




/*
 * String bag = ""; // art des rucksacks(Die farbe) String bagContent = ""; //
 * rucksäcke die in gegebenem rucksack enthalten sind String search = ""; //
 * aktueller string boolean contains = false; // teilt mit ob es bereits um den
 * content des rucksacks geht for (char currentChar : string.toCharArray()) {
 * if(!contains) { if(currentChar != ' ') { search += currentChar; } if() } else
 * {
 * 
 * } } Bags.put(bag, bagContent);
 */

/*
 * if(contains) { if(search.contains("bag") || search.contains("bags")) { search
 * = ""; } else { bagContent = bagContent + search; search = ""; } } else
 * if(!contains) { if(char2 != ' ') { search = search + char2; } else {
 * if(search.contains("contain")) { contains = true; search = ""; } else { bag =
 * bag + search; search = ""; } } }
 */