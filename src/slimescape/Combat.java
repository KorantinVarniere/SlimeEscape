package slimescape;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;


// Un enum complexe -> Etat qui serait liï¿½ a un complexe pour afficher le message quelle capacitï¿½/ Choisissez une action / choisissez un objet

public class Combat {

	Player p;
	public Etat etat;
	boolean botTurn = false;

	public Combat(Player p) {
		super();
		this.p = p;
		etat = Etat.MENUCHOIX;
	}


	public String display(Slime m1, Slime m2, String[] txt, String sentence) {
		String res = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";

		res +=  "                " + m2.getHp() + "/" + m2.getHpMax()  + " Slime de " + m2.getTypes().name() +  "\n" + 
				
				  "                  ,```^````, \r\n"
				+ "                 / ○    x  .\\\r\n"
				+ "                '    ^    ...'\r\n"
				+ "                `-,______..,-'"+                                      
				
				"\n\n\n\n" + 
				m1.getHp() + "/" + m1.getHpMax() +  " Slime de " + m1.getTypes().name() +" \n" + 
				"  ,````^```,  \r\n"
				+ " /.  ○    ○ \\ \r\n"
				+ "'...    ˇ    '\r\n"
				+ "'-,..______,-`\n\n";

		res += sentence + "\n\n\n";

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
		String[] choixInteraction = {"Attaquer" ,"Changer de Slime "};
		String[] attacks = {m1.getNormalAttackName(), m1.getMagicalAttackName(), "Se defendre","Retour"};
		//String[] items = new String[p.getItems().size() + 1];
		String sentence = "";

		Slime currentSlime = m1;
		/*
		for (int i = 0; i < p.getItems().size(); i++) {
			items[i] = p.getItems().get(i).toString();

		}

		items[items.length - 1] = "Retour";*/

		String[] slime = new String[p.getPlayerSlimes().size()+1];

		for (int i = 0; i < p.getPlayerSlimes().size(); i++) {
			slime[i] = p.getPlayerSlimes().get(i).toString();
		}

		slime[slime.length - 1] = "Retour";

		String[] msg = choixInteraction;

		System.out.println(display(m1, m2, msg, sentence));


		while(m1.isalive() && m2.isalive()) {
				System.out.println(display(m1, m2, msg, sentence));

			sentence = "\n\n";
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
					if (slime.length > 2) {
						msg = slime;
						etat = etat.CHANGESLIME;						
					}
				}

			}else if(keyboard == (msg.length + '0') ) {

				etat = Etat.MENUCHOIX;
				msg = choixInteraction;
			}else if(this.etat == Etat.COMBAT) {

				if (keyboard == '1') {
					int degat = m1.getDamageNormalAttack() ;

					if (m2.isDefended()) {

						p.damage(m2, degat);
						m2.DenfendingOff();
					}else{
						p.damage(m2, degat);
					}

					sentence = "Le slime de " + m1.getTypes().toString() + " a infligÃ© " + degat +" points de dÃ©gats";
					etat = Etat.MENUCHOIX;
					msg = choixInteraction;


				}else if(keyboard == '2') {
					int degat = m1.getDamageMagicalAttack() * (int)  (Types.compareTypes(m1.getTypes(), m2.getTypes()).getCoeff());

					if (m2.isDefended()) {

						p.damage(m2, (int) (0.3 * degat));
						m2.DenfendingOff();
						sentence = "Le smile adverse se défend\nLe slime de " + m1.getTypes().toString() + " a infligÃ© " + degat +" points de dÃ©gats";

					}else {
						p.damage(m2, degat);

					}
					sentence = "Le slime de " + m1.getTypes().toString() + " a infligÃ© " + degat +" points de dÃ©gats";

				}else if(keyboard == '3') {
					m1.DenfendingOn();
					sentence = "Votre Slime est prÃªt Ã  se dÃ©fendre";
				}

				if (keyboard == '1' || keyboard == '2' || keyboard == '3'  ) {
					botTurn = true;
				}

			}else if(this.etat == etat.CHANGESLIME) {

			}

			sentence += "\n------------------------------------------------------------------------\n";
			
			if(m1.isalive() && m2.isalive() && botTurn){
				
				Random rdm = new Random();
				int nb = rdm.nextInt(3);

				if(nb == 0) {
					
					int degat = m2.getDamageNormalAttack() ;

					if (m1.isDefended()) {

						m1.setHp(  m1.getHp() - (int) (degat * 0.3)  );
						sentence += "Vous vous defendez et le slime ennemie de " + m1.getTypes().toString() + " a infligé " + 0.3 * degat +" points de dÃ©gats avec " + m2.getNormalAttackName();
						m2.DenfendingOff();

					}else {
						
						m1.setHp(  m1.getHp() - degat  );
						sentence += "Le slime de " + m2.getTypes().toString() + " a infligé " + degat +" points de dÃ©gats avec " + m2.getNormalAttackName();

					}

				} if(nb == 1){
					int degat = m2.getDamageMagicalAttack() * (int)  (Types.compareTypes(m2.getTypes(), m1.getTypes()).getCoeff());

					sentence += "Le monstre vous inflige des degats magiques avec " + m2.getDamageMagicalAttack();
				
					if (m1.isDefended()) {

						p.damage(m1, (int) (0.3 * degat));
						m1.DenfendingOff();
						sentence += "Le smile adverse se défend\nLe slime de " + m2.getTypes().toString() + " a infligÃ© " + 0.3 * degat +" points de dÃ©gats";

					}else {
						p.damage(m1, degat);

					}
					sentence += "Le slime de " + m2.getTypes().toString() + " a infligÃ© " + degat +" points de dÃ©gats";
					
				}else if (nb == 2){
				
					sentence += "Le slime ennemie est pret a se defendre";
					m2.DenfendingOn();

				}
			}

			if (!m1.isalive()) {
				System.out.println("Vous etes morts");
			}else if (!m2.isalive()){

				m1.setXp(m1.getXp()+1);
				m1.evolve();

				System.out.println("Vous avez gagnÃ©");
			}
		}
	}


	public static void main(String[] args) {
		Slime m1 = new Slime();
		Slime m2 = new Slime();

		ArrayList<Slime> slimes = new ArrayList<Slime>();
		slimes.add(m1);
		slimes.add(m2);

		Player p = new Player();

		Combat combat = new Combat(p);
		combat.phaseDeCombat(m1, m2);

	}
}