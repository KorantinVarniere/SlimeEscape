package slimescape;

public enum Types {
	WATER, FIRE, AIR, EARTH;
	
	static int compareTypes (Types type1 , Types type2) {
		if ((type1 == WATER && type2 == FIRE)|| (type2 == WATER && type1 == FIRE)) {
			//water tres efficace 
			//fire pas efficace
		}
		if ((type1 == WATER && type2 == AIR)|| (type2 == WATER && type1 == AIR)) {
			//water pas efficace 
			//air tres efficace
		}
		if ((type1 == WATER && type2 == EARTH)|| (type2 == WATER && type1 == EARTH)) {
			//water resiste 
			//earth résiste
		}
		if ((type1 == FIRE && type2 == AIR)|| (type2 == FIRE && type1 == AIR)) {
			//fire resiste  
			//air resiste
		}
		if ((type1 == FIRE && type2 == EARTH)|| (type2 == FIRE && type1 == EARTH)) {
			//fire tres efficace
			//terre pas efficace 
		}
		if ((type1 == EARTH && type2 == AIR)|| (type2 == EARTH && type1 == AIR)) {
			//earth tres efficace 
			//air pas efficace
		}
		if (type1 == type2) {
			//rien ne change 
		}
		return 0;
	}
}
