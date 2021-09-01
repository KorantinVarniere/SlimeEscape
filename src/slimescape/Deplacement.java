package slimescape;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Deplacement{

    int[] playerPosition=new int[] {0,0}; //Lecteur fichier get position Joueur;
    Map map=new Map(0); //0 par défaut, à changer en fonction du niveau
    
    public void move(){

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
            playerPosition[1]+=1;
            break;

        case 's':
        	if(map.getSymbol(x,y+1)=='_' || map.getSymbol(x,y+1)=='|') {
        		return false;
        	}
            playerPosition[1]-=1;
            break;

        case 'q':
        	if(map.getSymbol(x-1,y)=='_' || map.getSymbol(x-1,y-1)=='|') {
        		return false;
        	}
            playerPosition[0]-=1;
            break;

        case 'd':
        	if(map.getSymbol(x+1,y)=='_' || map.getSymbol(x+1,y)=='|') {
        		return false;
        	}
            playerPosition[0]+=1;
            break;
        }
     
    return false;
    }

}