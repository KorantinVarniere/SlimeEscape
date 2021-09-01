package slimescape;
import java.util.List;
import java.util.ArrayList;

public class Player {


	private List<Slime> playerSlimes;
	/*private List<Objet> items;
	 */
	public Player(List<Slime> slimes){
		playerSlimes=slimes;
		//items=new ArrayList<items>;
	}
	/*
		public void addItem(Objet item){
			items.add(item);
		}

		public void removeItem(Objet item){
			items.remove(item);
		}
	 */
	public void addSlime(Slime slime){
		playerSlimes.add(slime);
	}

	public void removeSlime(Slime slime){
		playerSlimes.remove(slime);
	}

	public void changeSlime(Slime ancienSlime,Slime nouveauSlime){
		removeSlime(ancienSlime);
		addSlime(nouveauSlime);
	}

	/*
		public void heal(Slime slime, Objet potion){
			//Slime getLige et add ce que donne la potion;
		}*/

	public void damage(Slime slime,int degats){
		//slime getLife et -degats
	}

	/*public int[] getPosition(){
		//getPosition avec la classe lecteur fichier
	}*/
}


