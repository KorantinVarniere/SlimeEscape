package slimescape;

import java.util.ArrayList;

public class Slime {
	private int hp;
	private int hpMax;
	static ArrayList Monster;
	Attacks[] tab = new Attacks[3];
	private Types types ;
	

	public Slime(int hp,  Attacks[] tab, Types types) {
		super();
		this.hp = hp;
		hpMax = 100;
		this.tab = tab;
		this.types = types;
	}

	public int getHpMax() {
		return hpMax;
	}

	public void setHpMax(int hpMax) {
		this.hpMax = hpMax;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public boolean isalive() {
		return hp >0;
	}
}


