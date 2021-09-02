package slimescape;

public class slimeScapeMain {
	
	public static void main(String[] args) {
		
		Map map=new Map(1);
		map.generateMap(1);
		Deplacement deplacement=new Deplacement();
		deplacement.move();
		
	}
}
