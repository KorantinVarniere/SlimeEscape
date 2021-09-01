public enum etat {
	COMBAT("Quelle attaque voulez-vous faire?"),OBJET("Quel objet voulez-vous utilisez?"), CHANGESLIME("Quelle slime voulez-vous?"), MENUCHOIX("Effectuer une action");

	public String msg = "";
	etat(String msg) {
		this.msg = msg;
	}
	public String getMsg() {
		return msg;
	}	
}
