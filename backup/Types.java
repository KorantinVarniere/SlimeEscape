package agile.slimeescape;

public enum Types {
	WATER, FIRE, AIR, EARTH;
	
	
	//type1 est le joueur courant (le slime qui attaque)
	static Efficiency compareTypes (Types type1 , Types type2) {
		if (type1 == WATER) {
			if (type2 == FIRE) {
				return Efficiency.VEFFICIENT;
			}else if (type2 == AIR) {
				return Efficiency.NEFFICIENT;
			}else if (type2 == EARTH) {
				return Efficiency.RESISTANT;
			}
		}
		
		if (type1 == FIRE) {
			if (type2 == WATER) {
				return Efficiency.NEFFICIENT;
			}else if (type2 == AIR) {
				return Efficiency.RESISTANT;
			}else if (type2 == EARTH) {
				return Efficiency.VEFFICIENT;
			}
		}
		
		if (type1 == AIR) {
			if (type2 == WATER) {
				return Efficiency.VEFFICIENT;
			}else if (type2 == FIRE) {
				return Efficiency.RESISTANT;
			}else if (type2 == EARTH) {
				return Efficiency.NEFFICIENT;
			}
		}
		
		if (type1 == EARTH) {
			if (type2 == WATER) {
				return Efficiency.RESISTANT;
			}else if (type2 == AIR) {
				return Efficiency.VEFFICIENT;
			}else if (type2 == FIRE) {
				return Efficiency.NEFFICIENT;
			}
		}
		
		if (type1 == type2) {
			return Efficiency.NORMAL;
		}
		return Efficiency.NORMAL;
	}
}
