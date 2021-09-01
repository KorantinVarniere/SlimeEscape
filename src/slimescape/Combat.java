package slimescape;

public class Combat {

	static public String display(Slime m1, Slime m2, String[] txt) {
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
	 
	
	public static void phaseDeCombat(Slime m1, Slime m2) {
		String[] choixInteraction = {"Attaquer" , "Objet" ,"Changer de Slime "};
		String[] attacks = {"Eclair", "force", "badaboum", "Boum Boum"};
		String[] objects = new String[4];
		
		/*
		for (int i = 0; i < Monstre.attack[i]; i++) {
			attacks[i] = Monstre.attack[i].getName;
		}
		
		for (int i = 0; i < Monstre.objects[i]; i++) {
			objects[i] = Monstre.objects[i].getName;
		}
		*/
		
		
		System.out.println(display(m1, m2, choixInteraction));
		
	}
	
	public static void main(String[] args) {
		Slime m1 = new Slime( 90, null, null);
		Slime m2 = new Slime( 50, null, null);
		
		phaseDeCombat(m1, m2);

		
	}
}
