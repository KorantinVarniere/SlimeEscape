package slimescape;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;


// Un enum complexe -> Etat qui serait li� a un complexe pour afficher le message quelle capacit�/ Choisissez une action / choisissez un objet

public class Combat {

	Player p;
	
	public Etat etat;

	public Combat(Player p) {
		super();
		this.p = p;
		etat = Etat.MENUCHOIX;
	}


	public String display(Slime m1, Slime m2, String[] txt) {
		String res = "";

		res =  "                " + m2.getHp() + "/" + m2.getHpMax()  + "\n" + 
				"                  _ __,~~~/\n" + 
				"            ,~~`( )_( )-\\|\n" + 
				"                |/|  `--.\n" + 
				"                ! !  !    \n" + 
				"                                            \n\n\n\n" + 
				m1.getHp() + "/" + m1.getHpMax() + "\n" + 
				"      _ __,~~~/\n" + 
				",~~`( )_( )-\\|\n" + 
				"    |/|  `--.\n" + 
				"    ! !  !\n\n\n\n";

		res += etat.getMsg() + "\n\n";
		for (int i = 0; i < txt.length; i++) {
			res += (i+1) + "-" + txt[i] + "\n"; 
		}

		/*
				" _____________________    _____________________\n" + 
				"|                     |  |                     |\n" + 
				"|                     |  |                     |\n" + 
				"|_____________________|  |_____________________|\n" + 
				" _____________________    _____________________\n" + 
				"|                     |  |                     |\n" + 
				"| coup de poing       |  |                     |\n" + 
				"|_____________________|  |_____________________|\n" + 
				"\n" + 
				"\n" + */

		return res;
	}


	public void phaseDeCombat(Slime m1, Slime m2) {
		String[] choixInteraction = {"Attaquer" , "Objet" ,"Changer de Slime "};
		String[] attacks = {"Eclair", "force", "Retour"};
		String[] objects = {"Potion Eclair", "Potion de force", "Potion badaboum", "Potion Boum Boum", "Retour"};
		String[] slime = {"Slime de feu", "Retour"};
		String[] msg = choixInteraction;
		

		while(m1.isalive() && m2.isalive()) {
			System.out.println(display(m1, m2, msg));

			Scanner scanner=new Scanner(System.in);
			char keyboard=' ';

			try{
				keyboard=scanner.nextLine().charAt(0);
			}catch(NoSuchElementException e){}


			if (this.etat == Etat.MENUCHOIX) {
				if(keyboard=='1') {
					//
					//msg = attacks;
					
					m2.setHp(m2.getHp()-10);
					//etat = Etat.COMBAT;
				}else if(keyboard=='2') {
					msg = objects;
					etat = Etat.OBJECT;
				}else if(keyboard=='3') {
					if (slime.length > 2) {
						msg = slime;
						etat = etat.CHANGESLIME;						
					}else {
						System.out.println("Vous n'avez qu'un seul smile!");
					}
				}
				
				
			}else if(keyboard == (msg.length + '0') ) {
				
				etat = Etat.MENUCHOIX;
				msg = choixInteraction;
			}

		}	


		if (!m1.isalive()) {
			System.out.println("Vous etes morts");
		}else {
			System.out.println("Vous avez gagné");

		}
		
		/*
		for (int i = 0; i < Monstre.attack[i]; i++) {
			attacks[i] = Monstre.attack[i].getName;
		}

		for (int i = 0; i < Monstre.objects[i]; i++) {
			objects[i] = Monstre.objects[i].getName;
		}
		 */
	}
	public static void main(String[] args) {
		Slime m1 = new Slime( 90, null, null);
		Slime m2 = new Slime( 50, null, null);

		ArrayList<Slime> slimes = new ArrayList<Slime>();
		
		Player p = new Player(slimes);
		
		Combat combat = new Combat(p);
		combat.phaseDeCombat(m1, m2);

	}
}