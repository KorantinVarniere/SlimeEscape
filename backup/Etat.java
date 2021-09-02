package agile.slimeescape;

public enum Etat {
	COMBAT("Quelle attaque voulez-vous faire?"),OBJECT("Quel objet voulez-vous utilisez?"), CHANGESLIME("Quelle slime voulez-vous?"), MENUCHOIX("Effectuer une action");

	public String msg = "";
	Etat(String msg) {
		this.msg = msg;
	}
	public String getMsg() {
		return msg;
	}	
}
