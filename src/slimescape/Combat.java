package slimescape;

import java.util.NoSuchElementException;
import java.util.Scanner;


// Un enum complexe -> Etat qui serait li� a un complexe pour afficher le message quelle capacit�/ Choisissez une action / choisissez un objet

public class Combat {

	public Etat etat;

	public Combat() {
		super();
		etat = Etat.MENUCHOIX;
	}


	public String display(Slime m1, Slime m2, String[] txt) {
		String res = "";

		res =  "                " + m2.getHp() + "/" + m2.getHpMax()  + "\n" + 
				"                  _ __,~~~/\n" + 
				"            ,~~`( )_( )-\\|\n" + 
				"                |/|  `--.\n" + 
				"                ! !  !    \n" + 
				"                                            \n" + 
				m1.getHp() + "/" + m1.getHpMax() + "\n" + 
				"      _ __,~~~/\n" + 
				",~~`( )_( )-\\|\n" + 
				"    |/|  `--.\n" + 
				"    ! !  !\n";

		res += etat.getMsg() + "\n\n";
		for (int i = 0; i < txt.length; i++) {
			res += (i+1) + "-" + txt[i] + "\n"; 
		}

		/*
				" _____________________    _____________________\n" + 
				"|                     |  |                     |\n" + 
				"| coup de poing       |  |                     |\n" + 
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
		String[] attacks = {"Eclair", "force", "badaboum", "Retour"};
		String[] objects = {"Potion Eclair", "Potion de force", "Potion badaboum", "Potion Boum Boum", "Retour"};
		String[] slime = {"Slime de feu", "Retour"};
		String[] msg = new String[2];
		
		System.out.println(display(m1, m2, choixInteraction));

		while(m1.isalive() && m2.isalive()) {

			Scanner scanner=new Scanner(System.in);
			char keyboard=' ';

			try{
				keyboard=scanner.nextLine().charAt(0);
			}catch(NoSuchElementException e){}


			if (this.etat == Etat.MENUCHOIX) {
				if(keyboard=='1') {
					msg = attacks;

					etat = Etat.COMBAT;
				}else if(keyboard=='2') {
					msg = objects;
					etat = Etat.OBJECT;
				}else if(keyboard=='3') {
					msg = slime;
					if (slime.length > 1) {
						etat = etat.CHANGESLIME;						
					}else {
						System.out.println("Vous n'avez qu'un seul smile!");
					}
				}
				
				System.out.println(display(m1, m2, msg));
				
			}else if(keyboard == (msg.length + '0') ) {
				
				etat = Etat.MENUCHOIX;
				msg = choixInteraction;
				System.out.println(display(m1, m2, msg));
			}

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

		Combat combat = new Combat();
		combat.phaseDeCombat(m1, m2);

	}
}