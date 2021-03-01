package advent_of_code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Day5_BinaryBoarding {
	
	public static void main(String[] args) throws IOException {
		List<String> StringList = new ArrayList<String>();
		FileReader fr = new FileReader("C:/Users/Sascha-Zimmer/Desktop/test.txt");
		BufferedReader br = new BufferedReader(fr);

		String zeile = "";

		while ((zeile = br.readLine()) != null) {
			StringList.add(zeile);
		}


		int highScore = 0;
		
		List<Integer> seats = new ArrayList<Integer>();
		
		for (String string : StringList) {
			int upperEnd = 127;
			int lowerEnd = 0;
			int upperC = 7;
			int lowerC = 0;
			int counter = 0;
			
			for (char char2 : string.toCharArray()) {
				if(counter >= 0 && counter <= 6) {
					if(char2 == 'F') {
						upperEnd = (lowerEnd+upperEnd+1)/2-1;
					} else if(char2 == 'B') {
						lowerEnd = (lowerEnd+upperEnd+1)/2;
					}
					counter++;
				} else {
					if(char2 == 'L') {
						upperC = (lowerC+upperC+1)/2-1;
					} else if(char2 == 'R') {
						lowerC = (lowerC+upperC+1)/2;
					}
					counter++;
				}
			}
			seats.add(upperEnd*8+upperC);
			if(upperEnd*8+upperC > highScore) {
				highScore=upperEnd*8+upperC;
			}
		}
		
		Collections.sort(seats);
		
		for (int i = 1; i < seats.size()-1; i++) {
			if(seats.get(i) != seats.get(i - 1) + 1) {
				System.out.println("Dein Sitz: " + (seats.get(i) - 1));
			}
		}
		
		System.out.println("HighScore: " + highScore);
		br.close();
	}

}
