package agile.slimeescape;

public enum MagicalAttacks {
	A(Types.FIRE,30,"FlameThrower"),B(Types.FIRE,50,"Ember"),C(Types.FIRE,70,"FireBlast"),D(Types.WATER,30,"WaterGun"),E(Types.WATER,50,"AquaJet"),F(Types.WATER,70,"Surf"),G(Types.AIR,30,"Tornado"),H(Types.AIR,50,"WindBlade"),I(Types.AIR,70,"Bluster"),J(Types.EARTH,30,"MudSplash"),K(Types.EARTH,50,"MudBomb"),L(Types.EARTH,70,"Earthquake");
 
	private Types aType;
	private int damage;
	private String name;
	
	private MagicalAttacks(Types aType, int damage, String name) {
		this.aType = aType;
		this.damage = damage;
		this.name = name;
	}
	
	
}