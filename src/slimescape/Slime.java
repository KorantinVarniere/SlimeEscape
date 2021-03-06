package slimescape;

import java.util.Random;


public class Slime {
	private String name;
	private int hp;
	private int hpMax;
	private int level;
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
		this.name = this.types + "-Slime";
	}
	
	public Slime(int lvl) {
		this();
		this.level = lvl;
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
	
	public void DenfendingOn (){
		this.isDefended = true;
	}
	
	public void DenfendingOff () {
		this.isDefended = false;
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
	
	public void evolve () {
		if (xpMax == xp) {
			if (level != 10) {
				level = level +1;
				hpMax = hp+100;
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
	
	public int getDamageNormalAttack () {
		return this.nAttacks.damage;
	}

	public int getDamageMagicalAttack () {
		return this.mAttacks.damage;
	}
	
	public String getMagicalAttackName () {
		return this.mAttacks.name;
	}
	
	public String getNormalAttackName () {
		return this.nAttacks.msg;
	}
	
	public Types getMagicalAttackType () {
		return this.mAttacks.aType;
	}
	
	public boolean isDefended() {
		return isDefended;
	}

	public void setDefended(boolean isDefended) {
		this.isDefended = isDefended;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	@Override
	public String toString() {
		return "Slime [name=" + name + ", hp=" + hp + ", hpMax=" + hpMax + ", level=" + level + ", xp=" + xp
				+ ", xpMax=" + xpMax + ", isDefended=" + isDefended + ", nAttacks=" + nAttacks + ", mAttacks="
				+ mAttacks + ", types=" + types + "]";
	}

	public String toStringHP() {
		return "Slime [Health Points=" + hp + "/" + hpMax + "]" ;
	}
	
	public String toStringLvl() {
		return "Slime [ Level =" + level + "]" ;
	}
	
	public String toStringType() {
		return "Slime [ Type =" + types + "]" ;
	}
	
	public String toStringName() {
		return ""+this.name ;
	}
	
	public String toStringNormalAttack() {
		return "Slime [ Attack =" + getNormalAttackName() +" Damage :"+ getDamageNormalAttack() +"]" ;
	}
	
	public String toStringMagicalAttack() {
		return "Slime [ Attack =" + getMagicalAttackName() +" Damage :"+ getDamageMagicalAttack() + "Type : " + getMagicalAttackType() + "]" ;
	}
	

	public static void _main(String[] args) {
		Slime s1 = new Slime();
		System.out.println(s1.toString());
		s1.setXp(1);
		s1.evolve();
		System.out.println(s1.toString());
	}
	
	public static void __main(String[] args) {
		Slime s2 = new Slime();
		System.out.println(s2.toStringLvl());
		XpPotion px = new XpPotion();
		System.out.println("Le Slime 1 prend une potion d'experience");
		px.UseItem(s2);
		System.out.println(s2.toStringLvl());
	}
	
	public static void main(String[] args) {
		Slime s3 = new Slime();
		System.out.println(s3.toStringHP());
		System.out.println("Le Slime 1 prend 50 de d??gats !");
		s3.setHp(50);
		System.out.println(s3.toStringHP());
		HealPotion ph = new HealPotion();
		System.out.println("Le Slime 1 prend une potion de heal");
		ph.UseItem(s3);
		System.out.println(s3.toStringHP());
		System.out.println(" ");
		Slime s4 = new Slime();
		System.out.println(s4.toStringHP());
		System.out.println("Le Slime 2 prend 20 de d??gats !");
		s4.setHp(s4.getHp()-20);
		System.out.println(s3.toStringHP());
		System.out.println("Le Slime 2 prend une potion de heal");
		ph.UseItem(s4);
		System.out.println(s3.toStringHP());
		System.out.println(s3.toStringName());
	}
}


