package slimescape;

public enum NormalAttacks {
	CRUSH("Crush",50),CHARGE("Charge",40),THROW("Throw",20);
	
	String msg;
	int damage;
	
	private NormalAttacks(String msg, int damage) {
		this.msg = msg;
		this.damage = damage;
	}
	
}
