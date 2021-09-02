package agile.slimeescape;

public enum NormalAttacks {
	CRUSH("Crush !",50),CHARGE("charge !",40),THROW("throw !",20);
	
	String msg;
	int damage;
	
	private NormalAttacks(String msg, int damage) {
		this.msg = msg;
		this.damage = damage;
	}
	
}
