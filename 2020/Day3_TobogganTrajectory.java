package advent_of_code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day3_TobogganTrajectory {
	
	public static int X = 1;
	public static int Y = 2;
	
	public static void main(String[] args) throws IOException {
		List<String> StringList = new ArrayList<String>();
		List<String> StringList2 = new ArrayList<String>();

		FileReader fr = new FileReader("C:/Users/Sascha-Zimmer/Desktop/test.txt");
		BufferedReader br = new BufferedReader(fr);

		String zeile = "";	
		
		while ((zeile = br.readLine()) != null) {
			StringList2.add(zeile);
		}
		
		int slope = 1;
		int needlocX = X;
		int needlocationX = 0;	
		
		for (int i = 0; i <= StringList2.size(); i++) {
			if((needlocationX + needlocX) >= 32) {
				slope = i;
				break;
			} else {
				needlocationX+=needlocX;	
			}
		}
				
		for (String string : StringList2) {
			String test = "";
			for (int i = 0; i <= ((StringList2.size()/slope) + 1) * X; i++) {
				test = test + string;
			}
			StringList.add(test);
		}
		
		StringList2.remove(0);
		StringList.remove(0);
		
		int counter = 0;
		
		int locX = X;
		int locY = Y;
		int locationX = 0;
		int locationY = 1;
		boolean next = false;
		boolean next2 = false;

		
		for (String string : StringList) {
			if(Y != 1) {
				if(locationY == locY) {
					locationY = 1;
					next = true;
				} else {
					locationY++;
				}
			}
			
			locationX+=locX;

			if(!next) {
				if(next2) {
					if(String.valueOf(string.charAt(locationX)).equals("#")) {
						counter++;
					}
				} else {
					System.out.println("Übersprungen: " + string);
					next2 = false;
				}
			} else {
				if(next) {
					next2 = true;
				} 
			}
			next = false;
		}

		System.out.println(counter);
		br.close();
	}


}
