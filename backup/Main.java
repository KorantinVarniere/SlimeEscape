package agile.slimeescape;

public class Main {

	public static void main(String[] args) {

		Map map = new Map(5);

		/*
		Slime m1 = new Slime( 90, null, null);
		Slime m2 = new Slime( 50, null, null);

		Combat combat = new Combat();
		combat.phaseDeCombat(m1, m2);*/

		
		boolean running = true;

		while (map.getLevel() < 6) {
			Deplacement.move(map);
		}
		
		System.out.println("GAME OVER !");

	}

}
