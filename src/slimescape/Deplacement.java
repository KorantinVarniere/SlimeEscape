package slimescape;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Deplacement{

    int[] playerPosition;
    Map map=new Map(0); //0 par défaut, à changer en fonction du niveau
    
    public void move(){
    	
    	playerPosition=map.getPlayerPosition();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Movement :");
        char direction=' ';
        boolean valid=false;
        
        while(!valid){
            try{
                direction=scanner.nextLine().charAt(0);
            }catch(NoSuchElementException e){}

            if(direction=='z' || direction=='s' || direction=='q' || direction=='d') valid=true;
            else System.out.println("Invalid movement");
        }
        

    }
    
    public boolean validMovement(char movement,char direction){
    	
    	int x=playerPosition[0];
    	int y=playerPosition[1];
    	    	
        switch(direction){

        case 'z':
        	if(map.getSymbol(x,y-1)!='_' || map.getSymbol(x,y-1)!='|') {
        		return false;
        	}
            map.setPlayerPosition(x, y-1);
            break;

        case 's':
        	if(map.getSymbol(x,y+1)=='_' || map.getSymbol(x,y+1)=='|') {
        		return false;
        	}
            map.setPlayerPosition(x, y+1);
            break;

        case 'q':
        	if(map.getSymbol(x-1,y)=='_' || map.getSymbol(x-1,y-1)=='|') {
        		return false;
        	}
            map.setPlayerPosition(x-1, y);
            break;

        case 'd':
        	if(map.getSymbol(x+1,y)=='_' || map.getSymbol(x+1,y)=='|') {
        		return false;
        	}
            map.setPlayerPosition(x+1, y);
            break;
        }
     
    return false;
    }

}