package aoc2015;

import java.util.ArrayList;
import java.util.List;

import utils.Utils;

public class Day3_PerfectlySphericalHousesinaVacuum {

	public static void main(String[] args) {
		Utils utils = new Utils();
		part1(utils);
		part2(utils);
	}

	private static void part1(Utils utils) {
		String line = utils.readFile("test.txt").get(0);
		List<String> loc = new ArrayList<String>();
		int counter = 0;
		int x = 0;
		int y = 0;

		for (char chars : line.toCharArray()) {
			switch (chars) {
			case '<':
				x--;
				break;
			case '>':
				x++;
				break;
			case '^':
				y++;
				break;
			case 'v':
				y--;
				break;
			}

			if (!loc.contains(x + "|" + y)) {
				loc.add(x + "|" + y);
				counter++;
			}
		}
		if(!loc.contains("0|0"))counter++;
		System.out.println("Houses visited: " + counter);
	}

	private static void part2(Utils utils) {
		String line = utils.readFile("test.txt").get(0);
		List<String> loc = new ArrayList<String>();
		int counter = 0;
		int x[] = {0,0};
		int y[] = {0,0};
		int state = 0;
		
		for (char chars : line.toCharArray()) {
			switch (chars) {
				case '<':
					x[state]--;
					break;
				case '>':
					x[state]++;
					break;
				case '^':
					y[state]++;
					break;
				case 'v':
					y[state]--;
					break;
			}
			if (!loc.contains(x[0] + "|" + y[0])) {
				loc.add(x[0] + "|" + y[0]);
				counter++;
			} 
			if (!loc.contains(x[1] + "|" + y[1])) {
				loc.add(x[1] + "|" + y[1]);
				counter++;
			}
			
			
			if(state == 1)
				state = 0;
			else 
				state = 1;
		}
		if(!loc.contains("0|0"))counter++;
		System.out.println("Houses visited with robot: " + counter);
	}

}
