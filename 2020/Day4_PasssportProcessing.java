package advent_of_code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day4_PasssportProcessing {

	public static String BirthYear = "byr";
	public static String IssueYear = "iyr";
	public static String ExpirationYear = "eyr";
	public static String Height = "hgt";
	public static String HairColor = "hcl";
	public static String EyeColor = "ecl";
	public static String PassportID = "pid";
	public static String CountryID = "cid";
	public static boolean CountryIDActiv = false;

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
		String Passport = "";

		for (String string : StringList2) {
			if (string.isEmpty()) {
				Passport = Passport + " " + string;
				StringList.add(Passport);
				Passport = "";
			} else {
				Passport = Passport + " " + string;
			}
		}

		int counter = 0;

		for (String string : StringList) {
			if (string.contains(BirthYear) && string.contains(IssueYear) && string.contains(ExpirationYear)
					&& string.contains(Height) && string.contains(HairColor) && string.contains(EyeColor)
					&& string.contains(PassportID)) {
				if (checkData(string)) {
					if (CountryIDActiv) {
						if (string.contains(CountryID)) {
							counter++;
						}
					} else {
						//System.out.println(string);
						counter = counter + 1;

					}
				}


			}
		}
		System.out.println(counter);
		br.close();
	}

	public static boolean checkData(String Passport) {
		List<String> DataSplit = new ArrayList<String>();

		String Split = "";
		for (int i = 0; i < Passport.length(); i++) {
			if (String.valueOf(Passport.charAt(i)).equals(" ")) {
				DataSplit.add(Split);
				Split = "";
			} else {
				Split = Split + String.valueOf(Passport.charAt(i));
			}
		}
		
		
		for (String string : DataSplit) {
			if (string.contains(BirthYear)) {
				if (!checkYear(BirthYear, string, 1920, 2002))
					return false;
			}
			if (string.contains(IssueYear)) {
				if (!checkYear(IssueYear, string, 2010, 2020))
					return false;
			}
			if (string.contains(ExpirationYear)) {
				if (!checkYear(ExpirationYear, string, 2020, 2030))
					return false;
			}
			if (string.contains(Height)) {
				if (!checkGage(Height, string, 150, 193, 59, 76))
					return false;
			}
			if (string.contains(EyeColor)) {
				if (!checkEyeColor(Height, string))
					return false;
			}
			if (string.contains(HairColor)) {
				if (!checkHairColor(HairColor, string))
					return false;
			}
			if (string.contains(PassportID)) {
				if (!checkPassportNumber(PassportID, string))
					return false;
			}
		}

		return true;
	}

	public static boolean checkYear(String SearchData, String string, int minYear, int maxYear) {
		String YearString = "";
		for (int i = (SearchData.length() + 1); i < string.length(); i++) {
			YearString = YearString + String.valueOf(string.charAt(i));
		}
		int Year = Integer.parseInt(YearString);
		if (!(Year >= minYear) || !(Year <= maxYear)) {
			return false;
		}
		return true;
	}

	public static boolean checkEyeColor(String SearchData, String string) {
		String EyeColorString = "";
		for (int i = (SearchData.length() + 1); i < string.length(); i++) {
			EyeColorString = EyeColorString + String.valueOf(string.charAt(i));
		}

		List<String> color = new ArrayList<String>();
		color.add("amb");
		color.add("blu");
		color.add("brn");
		color.add("gry");
		color.add("grn");
		color.add("hzl");
		color.add("oth");

		for (String string2 : color) {
			if (EyeColorString.equals(string2)) {
				return true;
			}
		}

		return false;
	}

	public static boolean checkPassportNumber(String SearchData, String string) {
		String NumberString = "";
		for (int i = (SearchData.length() + 1); i < string.length(); i++) {
			NumberString = NumberString + String.valueOf(string.charAt(i));
		}
		
		if(NumberString.length() != 9) return false; 
		
		try {
			int Number = Integer.parseInt(NumberString);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

	public static boolean checkHairColor(String SearchData, String string) {
		String HairColorString = "";
		for (int i = (SearchData.length() + 1); i < string.length(); i++) {
			HairColorString = HairColorString + String.valueOf(string.charAt(i));
		}
		if (HairColorString.length() != 7) return false;
		if (!HairColorString.startsWith("#")) return false;
		HairColorString = HairColorString.toLowerCase();
		for (Character c : HairColorString.toCharArray()) {
			try {
				int Number = Integer.parseInt(String.valueOf(c));
			} catch (Exception e) {
				if (c != 'a' && c != 'b' && c != 'c'&& c != 'd' && c != 'e' && c != 'f') {
					if(!String.valueOf(c).equals("#")) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public static Boolean checkGage(String SearchData, String string, int minCM, int maxCM, int minIN, int maxIN) {
		String Gage = "";
		String NumberString = "";
		for (int i = (string.length() - 2); i < string.length(); i++) {
			Gage = Gage + String.valueOf(string.charAt(i));
		}

		if(!Gage.contains("cm") && !Gage.contains("in")) return false; 
		for (int i = (SearchData.length() + 1); i < (string.length() - 2); i++) {
			NumberString = NumberString + String.valueOf(string.charAt(i));
		}
		
		int Number = Integer.parseInt(NumberString);

		if (Gage.equals("cm")) {
			if (!(Number >= minCM) || !(Number <= maxCM)) {
				return false;
			}
		} else if (Gage.equals("in")) {
			if (!(Number >= minIN) || !(Number <= maxIN)) {
				return false;
			}
		}

		return true;
	}

}
