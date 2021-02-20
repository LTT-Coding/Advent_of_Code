package aoc2015;

import java.util.List;

import utils.Utils;

public class Day1_NotQuiteLisp {

	public static void main(String[] args) {
		Utils utils = new Utils();
		part1(utils);
		part2(utils);
		
	}

	private static void part1(Utils utils) {
		// there is only one line so no for loop is needed
		List<String> lines = utils.readFile("test.txt");
		String line = lines.get(0);
		int floor = 0;
		for (char current : line.toCharArray()) {
			if (current == '(')
				floor++;
			else if (current == ')')
				floor--;
		}
		System.out.println("Floor: " + floor);
	}
	
	private static void part2(Utils utils) {
		List<String> lines = utils.readFile("test.txt");
		String line = lines.get(0);
		int floor = 0;
		char[] chars = line.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '(')
				floor++;
			else if (chars[i] == ')')
				floor--;
			if(floor == -1) {
				System.out.println("Position: " + (i+1));
				break;
			}
		}
	}
}
