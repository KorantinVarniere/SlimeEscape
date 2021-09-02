package slimescape;

public enum Efficiency {
	VEFFICIENT ("très efficace !",2), NEFFICIENT ("pas efficace !",0.5), RESISTANT ("résiste !",0) , NORMAL ("réussite", 1);
	
	String message;
	double coeff;
	
	private Efficiency(String message, double coeff) {
		this.message = message;
		this.coeff = coeff;
	}

	public String getMessage() {
		return message;
	}

	public double getCoeff() {
		return coeff;
	}
	
}
