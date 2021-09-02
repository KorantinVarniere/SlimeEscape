package slimescape;

public enum Efficiency {
	VEFFICIENT ("très efficace !"), NEFFICIENT ("pas efficace !"), RESISTANT ("résiste !");
	
	String message;
	
	private Efficiency(String message) {
		this.message = message;
	}
}
