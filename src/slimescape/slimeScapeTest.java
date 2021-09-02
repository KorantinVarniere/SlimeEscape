package slimescape;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class slimeScapeTest {

	Map map=new Map(1);
	int[] position=map.getPlayerPosition();
	
	List<Slime> slimes=new ArrayList<Slime>();
	Player player;
	
	@BeforeAll
	void beforeAll() {
		slimes.add(new Slime());
		slimes.add(new Slime());
		slimes.add(new Slime());
		slimes.add(new Slime());
		slimes.get(0).setTypes(Types.AIR);
		slimes.get(1).setTypes(Types.EARTH);
		slimes.get(2).setTypes(Types.FIRE);
		slimes.get(3).setTypes(Types.WATER);
		player=new Player(slimes);
	}
	
	@Test
	void testGetPlayerPosition() {
		assertArrayEquals(new int[] {3,3},map.getPlayerPosition());
		map.setPlayerPosition(position[0]+1,position[0]+5);
		assertArrayEquals(new int[] {4,8},map.getPlayerPosition());
		assertNotEquals(new int[] {3,3},map.getPlayerPosition());
	}

	@Test
	void testGetSymbol() {
		assertEquals(map.getSymbol(position[0], position[1]),'j');
		map.setSymbol(position[0], position[1], 'p');
		assertNotEquals(map.getSymbol(position[0],position[1]), 'j');
		assertEquals(position[0],position[1],'p');
	}


	@Test
	void testGetHp() {
		assertEquals(100,slimes.get(0).getHp());
		player.damage(slimes.get(0), 40);
		assertEquals(slimes.get(0), 60);
		//tester les potions
	}

	@Test
	void testIsalive() {
		assertTrue(slimes.get(1).isalive());
		player.damage(slimes.get(1), 40);
		assertTrue(slimes.get(1).isalive());
		player.damage(slimes.get(0), 60);
		assertFalse(slimes.get(0).isalive());
	}

	@Test
	void evolve() {
		assertEquals(slimes.get(0).getHpMax(),100);
		assertEquals(slimes.get(0).getXp(),0);
		assertEquals(slimes.get(0),1);
		slimes.get(0).setXp(1);
		//slimes.get(0).evolve();
		assertEquals(slimes.get(0),110);
		assertEquals(slimes.get(0).getXp(),0);
	}
	
	void correctAttackElement() {
		assertTrue(slimes.get(0).getTypes()==slimes.get)
	}

}
