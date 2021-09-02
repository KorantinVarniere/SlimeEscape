package agile.slimeescape;

import java.util.Scanner;

public class Deplacement{

	public static void move(Map map){
		String cmd;

		Scanner scan = new Scanner(System.in);		
		do {
			System.out.println(map);

			System.out.println("Entrez un déplacement (zqsd) : ");
			cmd = scan.nextLine();
		} while(cmd.length() < 1);
		
		int x = map.getPlayerPosition()[0];
		int y = map.getPlayerPosition()[1];


		if (cmd.charAt(0) == 'z' && validMovement(cmd.charAt(0), x, y, map)) {
			if (map.getMap()[map.getPlayerPosition()[1]-1][map.getPlayerPosition()[0]] == '#') {
				map.switchMap();
			} else {
				map.setPlayerPosition(map.getPlayerPosition()[0], map.getPlayerPosition()[1]-1);
			}
		}else if (cmd.charAt(0) == 'q' && validMovement(cmd.charAt(0), x, y, map)){
			if (map.getMap()[map.getPlayerPosition()[1]][map.getPlayerPosition()[0]-1] == '#') {
				map.switchMap();
			} else {
				map.setPlayerPosition(map.getPlayerPosition()[0]-1, map.getPlayerPosition()[1]);
			}
		}else if (cmd.charAt(0) == 's' && validMovement(cmd.charAt(0), x, y, map)) {
			if (map.getMap()[map.getPlayerPosition()[1]+1][map.getPlayerPosition()[0]] == '#') {
				map.switchMap();
			} else {
				map.setPlayerPosition(map.getPlayerPosition()[0], map.getPlayerPosition()[1]+1);
			}
		}else if (cmd.charAt(0) == 'd' && validMovement(cmd.charAt(0), x, y, map)) {
			if (map.getMap()[map.getPlayerPosition()[1]][map.getPlayerPosition()[0]+1] == '#') {
				map.switchMap();
			} else {
				map.setPlayerPosition(map.getPlayerPosition()[0]+1, map.getPlayerPosition()[1]);
			}
		}
	}


	public static boolean validMovement(char direction, int x, int y, Map map){
		System.out.println(map.getSymbol(x, y-1));
		System.out.println(map.getSymbol(x, y+1));


		switch(direction){
		
		
		case 'z':
			if(map.getSymbol(x,y-1)=='_' || map.getSymbol(x,y-1)=='|') {
				return false;
			}
			
			break;

		case 's':
			if(map.getSymbol(x,y+1)=='_' || map.getSymbol(x,y+1)=='|') {
				return false;
			}
			break;

		case 'q':
			if(map.getSymbol(x-1,y)=='_' || map.getSymbol(x-1,y)=='|') {
				return false;
			}
			break;

		case 'd':
			if(map.getSymbol(x+1,y)=='_' || map.getSymbol(x+1,y)=='|') {
				return false;
			}
			break;
		}

		return true;
	}


}