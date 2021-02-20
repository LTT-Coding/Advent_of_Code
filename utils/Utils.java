package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Utils {
	
	public Utils() {
		
	}
	
	public List<String> readFile(String path) {
		List<String> StringList = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);

			String zeile = "";

			while ((zeile = br.readLine()) != null) {
				StringList.add(zeile);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StringList;
	}
}
