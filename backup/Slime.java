package agile.slimeescape;

import java.util.ArrayList;
import java.util.Random;


public class Slime {
	private int hp;
	private int hpMax;
	private int level;
	static ArrayList Slimes;
	private int xp;
	private int xpMax;
	private boolean isDefended;
	private NormalAttacks nAttacks;
	private MagicalAttacks mAttacks;
	private Types types ;
	

	public Slime() {
		super();
		this.types = giveType();
		this.hp = 100;
		hpMax = hp;
		this.level = 1;
		this.xpMax = level;
		this.xp = 0;
		this.nAttacks = giveNormalAttack(); 
		this.mAttacks = giveMagicalAttack();
	}

	private Types giveType() {
		Random rand1 = new Random();
		int i = rand1.nextInt(4);
		if (i == 1) {
			return Types.FIRE;
		}
		if (i==2) {
			return Types.AIR;
		}
		if (i==3) {
		return Types.EARTH ;
	}else 
		return Types.WATER;
	}
	
	private NormalAttacks giveNormalAttack () {
		Random rand = new Random();
		int i = rand.nextInt(4);
		if (i == 1) {
			return NormalAttacks.CHARGE;
		}
		if (i==2) {
			return NormalAttacks.CRUSH;
		}else
		return NormalAttacks.THROW;
	}
	
	private MagicalAttacks giveMagicalAttack () {
		Random rand = new Random();
		int i = rand.nextInt(4);
		if (this.types == Types.FIRE){
			if (i == 1) {
				return MagicalAttacks.A;
			}
			if (i==2) {
				return MagicalAttacks.B;
			}else
			return MagicalAttacks.C ;
		}
		if (this.types == Types.WATER){
			if (i == 1) {
				return MagicalAttacks.D;
			}
			if (i==2) {
				return MagicalAttacks.E;
			}else
			return MagicalAttacks.F ;
		}
		if (this.types == Types.AIR){
			if (i == 1) {
				return MagicalAttacks.G;
			}
			if (i==2) {
				return MagicalAttacks.H;
			}else
			return MagicalAttacks.I ;
		}
		if (this.types == Types.EARTH){
			if (i == 1) {
				return MagicalAttacks.J;
			}
			if (i==2) {
				return MagicalAttacks.K;
			}else
			return MagicalAttacks.L ;
		}
		return MagicalAttacks.A;
	}
	
	private void evolve () {
		if (xpMax == xp) {
			if (level != 10) {
				level = level +1;
				hpMax = hp+10;
				hp = hpMax;
				xp = 0;
				xpMax = level;
			}
		}
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

	public Types getTypes() {
		return types;
	}

	public void setTypes(Types types) {
		this.types = types;
	}
	
	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	@Override
	public String toString() {
		return "Slime [hp=" + hp + ", hpMax=" + hpMax + ", level=" + level + ", xp=" + xp + ", xpMax=" + xpMax
				+ ", isDefended=" + isDefended + ", nAttacks=" + nAttacks + ", mAttacks=" + mAttacks + ", types="
				+ types + "]";
	}

	public static void main(String[] args) {
		Slime s1 = new Slime();
		System.out.println(s1.toString());
		s1.setXp(1);
		s1.evolve();
		System.out.println(s1.toString());
	}
}


