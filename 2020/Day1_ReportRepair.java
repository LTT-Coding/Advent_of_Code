package advent_of_code;

import java.awt.SystemColor;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Day1_ReportRepair {

	public static void main(String[] args) throws IOException {
		List<Integer> IntegerList = new ArrayList<Integer>();
		FileReader fr = new FileReader("C:/Users/Sascha-Zimmer/Desktop/test.txt");
		BufferedReader br = new BufferedReader(fr);

		boolean s = 10 >20;
		
		String zeile = "";

		while ((zeile = br.readLine()) != null) {
			IntegerList.add(Integer.parseInt(zeile));
		}

		for (int current : IntegerList) {
			for (int current2 : IntegerList) {
				for (int current3 : IntegerList) {
					if (current != current2 || current != current3 || current2 != current3) {
						if ((current + current2 + current3) == 2020) {
							System.out.println(current + " * " + current2 + " * " + current3 + " = " + (current * current2 * current3));
						}
					}
				}
			}
		}

		
		br.close();
	}
}