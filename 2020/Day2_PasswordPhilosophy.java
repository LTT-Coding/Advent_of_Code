package advent_of_code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day2_PasswordPhilosophy {

	public static void main(String[] args) throws IOException {
		List<String> StringList = new ArrayList<String>();
		FileReader fr = new FileReader("C:/Users/Sascha-Zimmer/Desktop/test.txt");
		BufferedReader br = new BufferedReader(fr);

		String zeile = "";

		while ((zeile = br.readLine()) != null) {
			StringList.add(zeile);
		}
		
		
		int finishNumber = 0;
		int finishNumber1 = 0;

		for (String toSearch : StringList) {
			String search = null;
			String password = "";
			int startPassword = 0;
			for (int i = 0; i < toSearch.length(); i++) {
				if(String.valueOf(toSearch.charAt(i)).equals(":")) {
					i--;
					search = "" + String.valueOf(toSearch.charAt(i));
					i+=3;
					startPassword = i;
					break;
				}
			}
			for (int i = startPassword; i < toSearch.length(); i++) {
				password+=String.valueOf(toSearch.charAt(i));
			}
			String NumberMax = "";
			String NumberMin = "";
			boolean MinBlock = false;
			for (int i = 0; i < toSearch.length(); i++) {
				if(!String.valueOf(toSearch.charAt(i)).equals("-") && !MinBlock) {
					NumberMin = NumberMin + String.valueOf(toSearch.charAt(i));
				} else if(!String.valueOf(toSearch.charAt(i)).equals(" ")) {
					MinBlock = true;
					if(!String.valueOf(toSearch.charAt(i)).equals("-")) {
						NumberMax = NumberMax + String.valueOf(toSearch.charAt(i));
					}
				} else break;
			}
			int min = Integer.parseInt(NumberMin);
			int max = Integer.parseInt(NumberMax);
			int identifiedSearch = -1;
			for (int i = 0; i < toSearch.length(); i++) {
				String chars = String.valueOf(toSearch.charAt(i));
				if(chars.equals(search)) {
					identifiedSearch++;
				}
			}
			if(identifiedSearch >= min && identifiedSearch <= max) {
				finishNumber++;
			}
				
			if(String.valueOf(password.charAt(min-1)).equals(search) || String.valueOf(password.charAt(max-1)).equals(search)) {
				if(!String.valueOf(password.charAt(min-1)).equals(search) || !String.valueOf(password.charAt(max-1)).equals(search)) {
					finishNumber1++;
				}
			}
		}
		System.out.println("Teil1: " + finishNumber);
		System.out.println("Teil2: " + finishNumber1);

		/*int counter = 0;

		for (String string : StringList) {
			int min = 0;
			int max = 0;
			short state = 0;
			char letter = ' ';
			int ISrIGHT = 0;
			String password = "";
			for (char current : string.toCharArray()) {
				switch (state) {
				case 0:
					if (current != '-') {
						min = min * 10 + Integer.parseInt(String.valueOf(current));
					} else
						state++;
					break;
				case 1:
					if (current != ' ') {
						max = max * 10 + Integer.parseInt(String.valueOf(current));
					} else
						state++;
					break;
				case 2:
					if (current != ' ') {
						letter = current;
						state++;
					}
					break;
				case 3:
					if (current != ':' && current != ' ') {
							password+= current;
						
					}
					break;
				}
			}
			
			if(password.length() > min) {
				if(String.valueOf(password.charAt(min-1)).equals(letter)) {
					ISrIGHT++;
				}
			}
			if(password.length() > max) {
				if(String.valueOf(password.charAt(max-1)).equals(letter)) {
					ISrIGHT++;
				}
			}
			if(ISrIGHT == 1) {
				counter++;
			}
			if(password.length() > min)
			if(password.length() > max) {
				if(password.charAt(min) == letter || password.charAt(max) == letter) {
					if(password.charAt(min) != letter || password.charAt(max) != letter) {
						counter++;
					}
				}
			}
		}
		System.out.println(counter);*/
		
		br.close();
	}

}
