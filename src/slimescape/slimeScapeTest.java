package slimescape;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class slimeScapeTest {

	Map map=new Map(1);
	int[] position=map.getPlayerPosition();
	
	static List<Slime> slimes;
	static Player player;
	Slime slime1,slime2,slime3,slime4;
	
	@BeforeEach
	void beforeEach() {
		slimes=new ArrayList<Slime>(Arrays.asList(new Slime[] {new Slime(),new Slime(),new Slime(),new Slime()}));
		slimes.get(0).setTypes(Types.AIR);
		slimes.get(1).setTypes(Types.EARTH);
		slimes.get(2).setTypes(Types.FIRE);
		slimes.get(3).setTypes(Types.WATER);
		player=new Player();
		slime1=slimes.get(0);
		slime2=slimes.get(1);
		slime3=slimes.get(2);
		slime4=slimes.get(3);
		player.addSlime(slime1);
		player.addSlime(slime2);
		player.addSlime(slime3);
		player.addSlime(slime4);
	}
	
	@Test
	void testGetPlayerPosition() {
		assertArrayEquals(new int[] {3,3},map.getPlayerPosition());
		map.setPlayerPosition(position[0]+1,position[0]+5);
		assertArrayEquals(new int[] {8,4},map.getPlayerPosition());
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
	void testHeal() {
		assertEquals(100,slime1.getHp());
		player.damage(slime1, 40);
		assertEquals(slime1.getHp(),60);
		player.getItem(1).UseItem(slime1); //1 = heal potion
		assertEquals(60+slime1.getHpMax()*0.25,slime1.getHp());
	}
	
	@Test
	void testIsalive() {
		assertTrue(slime2.isalive());
		player.damage(slime2, 40);
		assertTrue(slime2.isalive());
		player.damage(slime2, 60);
		assertFalse(slime2.isalive());
	}

	@Test
	void evolve() {
		assertEquals(slime1.getHpMax(),100);
		assertEquals(slime1.getXp(),0);
		assertEquals(slime1.getLevel(),1);
		player.getItem(2).UseItem(slime1); //2 = xp potion
		slime1.evolve();
		assertEquals(slime1.getHpMax(),200);
		assertEquals(slime1.getXp(),0);
	}
	
	void correctAttackElement() {
		assertTrue(slime1.getTypes()==slime1.getMagicalAttackType());
		assertTrue(slime1.getTypes()==slime2.getMagicalAttackType());
		assertTrue(slime1.getTypes()==slime3.getMagicalAttackType());
		assertTrue(slime1.getTypes()==slime4.getMagicalAttackType());
	}

}
