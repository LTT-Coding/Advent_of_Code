package advent_of_code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day6_CustomCustoms {

	public static void main(String[] args) throws IOException {
		List<String> StringList = new ArrayList<String>();
		List<String> StringList2 = new ArrayList<String>();

		FileReader fr = new FileReader("C:/Users/Sascha-Zimmer/Desktop/test.txt");
		BufferedReader br = new BufferedReader(fr);

		String zeile = "";

		while ((zeile = br.readLine()) != null) {
			StringList2.add(zeile);
		}

		StringList2.add("");
		String answer = "";

		for (String string : StringList2) {
			if (string.isEmpty()) {
				answer = answer + "" + string;
				StringList.add(answer);
				answer = "";
			} else {
				answer = answer + "" + string;
			}
		}

		String letters = "";
		int counter = 0;

		for (String string : StringList) {
			for (char char2 : string.toCharArray()) {
				if (!letters.contains(String.valueOf(char2))) {
					counter++;
					letters += String.valueOf(char2);
				}
			}
			letters = "";
		}

		System.out.println(counter);
		br.close();
	}
}
