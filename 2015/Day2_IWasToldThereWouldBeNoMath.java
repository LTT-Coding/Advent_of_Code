package aoc2015;

import utils.Utils;

public class Day2_IWasToldThereWouldBeNoMath {

	public static void main(String[] args) {
		Utils utils = new Utils();
		part1(utils);
		part2(utils);
	}


	private static void part1(Utils utils) {
		int totalSize = 0;
		for(String string : utils.readFile("test.txt")) {
			int width = 0;
			int height = 0;
			int length = 0;
			int position = 0;
			int number = 0;
			for(char current : string.toCharArray()) {
				if(current != 'x') 
					number = number * 10 + Integer.parseInt(String.valueOf(current)); //builds up the number in the temporary storage "number"
				else {
					number = 0;
					position++;
				}
				switch (position) {
					case 0:
						width = number;
						break;
					case 1:
						height = number;
						break;
					case 2:
						length = number;
						break;
				}
			}
			
			int smallestSide = 0;
			int[] sides = {2*length*width, 2*width*height, 2*height*length};
			for(int side : sides) {
				if(smallestSide != 0) { 
					if(side/2 < smallestSide) {
						smallestSide = side/2;
					}
				}else
					smallestSide = side/2;
			}
			totalSize += sides[0] + sides[1] + sides[2] + smallestSide;
		}
		System.out.println("Wrap needed: " + totalSize);
	}
	
	private static void part2(Utils utils) {
		//this is the same as above because I need the sides again
		int totalSize = 0;
		for(String string : utils.readFile("test.txt")) {
			int width = 0;
			int height = 0;
			int length = 0;
			int position = 0;
			int number = 0;
			for(char current : string.toCharArray()) {
				if(current != 'x') 
					number = number * 10 + Integer.parseInt(String.valueOf(current)); //builds up the number in the temporary storage "number"
				else {
					number = 0;
					position++;
				}
				switch (position) {
					case 0:
						width = number;
						break;
					case 1:
						height = number;
						break;
					case 2:
						length = number;
						break;
				}
			}
			int[] sides = {width, height, length};
			
			int largestIndex = 0;
			for(int i = 0; i < sides.length; i++) {
				if(sides[i] > sides[largestIndex]) {
					largestIndex = i;
				}else {
					
				}
			}
			for(int i = 0; i < sides.length; i++) {
				if(i != largestIndex)
					totalSize += 2*sides[i];
			}
			totalSize += sides[0] * sides[1] * sides[2];
		}
		System.out.println("Ribbon needed: " + totalSize);
	}

}
