package slimescape;

public class Attacks {
	private String name;
	private int damage;
	private Efficiency efficiency;
	
	public Attacks(String name, int damage) {
		super();
		this.name = name;
		this.damage = damage;
		this.efficiency = Efficiency.NORMAL;
	}

	//NormalAttack   MagicAttack   Defense
	
}
