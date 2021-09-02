package slimescape;

public class HealPotion implements Item {
	@Override
	public void UseItem(Slime s) {
		// TODO Auto-generated method stub
		if(s.getHp()!=s.getHpMax()) {
			int healpercents =  (int) (s.getHpMax()*0.25);
			if (s.getHp() > s.getHpMax()) {
				s.setHp(s.getHpMax());
			}else {
				s.setHp(s.getHp() + healpercents); 
			}
		}
		
	}
}
