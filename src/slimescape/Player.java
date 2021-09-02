package slimescape;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.ArrayList;

public class Player {


	private List<Slime> playerSlimes;
	private List<Item> itemsHeal;
	private List<Item> itemsXp;
	 
	public Player(){
		playerSlimes=new ArrayList<Slime>();
		itemsHeal=new ArrayList<Item>();
		itemsXp=new ArrayList<Item>();
		playerSlimes.add(new Slime());
		itemsHeal.add(new HealPotion());
		itemsHeal.add(new HealPotion());
		itemsHeal.add(new HealPotion());
		itemsXp.add(new XpPotion());
		itemsXp.add(new XpPotion());
		itemsXp.add(new XpPotion());
	}
	
	public void addHeal(){
		itemsHeal.add(new HealPotion());
	}

	public void removeHeal(){
		itemsHeal.remove(itemsHeal.get(0));
	}
	
	public void addXp(){
		itemsXp.add(new XpPotion());
	}

	public void removeXp(){
		itemsXp.remove(itemsXp.get(0));
	}
	
	public void addSlime(Slime slime){
		playerSlimes.add(slime);
	}

	public void removeSlime(Slime slime){
		playerSlimes.remove(slime);
	}

	public void usePotion (Slime slime){
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Quel type potion voulez vous utiliser ? 1-Heal 2-Xp ");
		int choix;
		
		while(true) {
			try{
				choix=scanner.nextInt();
				break;
			}catch(NoSuchElementException|IllegalStateException e) {
				System.out.println("Invalid input, select 1 for heal potion or 2 for Xp potion");
			}
		}
		
		if(choix==1) {
			if(!itemsHeal.isEmpty()) itemsHeal.get(0).UseItem(slime);
		}else {
			if(!itemsXp.isEmpty()) itemsXp.get(0).UseItem(slime);
		}
		
		scanner.close(); //peut créer des erreurs
	}

	public void damage(Slime slime,int degats){
		slime.setHp(slime.getHp()-degats);
	}
	
	//Pour les test, 1 pour heal et 2 pour xp
	public Item getItem(int item) {
		return item==1 ? new HealPotion() : new XpPotion();
	}

	public void SwapSlime (List<Slime> playerSlimes, int i1 , int i2) {
		Slime tmp1 = playerSlimes.get(i1-1);
		Slime tmp2 = playerSlimes.get(i2-1);
		playerSlimes.remove(i1-1);
		playerSlimes.remove(i2-1);
		playerSlimes.add(i1-1,tmp2);
		playerSlimes.add(i2-1,tmp1);
	}
}



