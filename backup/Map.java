package agile.slimeescape;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Map {

	private char[][] map;
	private int level;
	
	public Map(int level) {
		this.level = level;
		this.map = generateMap();
	}
	
	public char[][] generateMap() {
		String[] tmp = new String[16];
		char[][] map = new char[16][50];
		
		try {
			Random randomiser = new Random();
			int num = randomiser.nextInt(2);
			char numNiv = (char) ('a' + num);
			BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/resources//niveau_" + this.level + numNiv)));
			String str;
			int i = 0;
			while ((str = reader.readLine()) != null) {
				tmp[i] = str;
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[i].length(); j++) {
				map[i][j] = tmp[i].charAt(j);
			}
		}
		
		return map;
	}

	public char[][] getMap() {
		return map;
	}

	public void setMap(char[][] map) {
		this.map = map;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public int[] getPlayerPosition() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 'j') {
					return new int[] {j, i};
				}
			}
		}
		return new int[] {-1, -1};
	}
	
	public void setPlayerPosition(int x, int y) {
		this.map[getPlayerPosition()[1]][getPlayerPosition()[0]] = ' ';
		this.map[y][x] = 'j';
	}
	
	public char getSymbol(int x, int y) {
		return this.map[y][x];
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (char[] cs : map) {
			for (char c : cs) {
				builder.append(c);
			}
			builder.append("\n");
		}
		return builder.toString();
	}
	
	public void switchMap() {
		this.level++;
		if (this.level < 5) {
			this.map = generateMap();
		}
	}
	
}