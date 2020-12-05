package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import structure.ABBTree;

class TestABB {
	private ABBTree<Integer,Integer> abb;

	public void setup1() {
		abb = new ABBTree<>();
	}
	public void setup2() {
		abb = new ABBTree<>();
		abb.add(10,	100);
		abb.add(12,	101);
		abb.add(13,	102);
	}
	public void setup3() {
		abb = new ABBTree<>();
		abb.add(15, 100);
		abb.add(16, 101);
		abb.add(17, 102);
		abb.add(18, 103);
	}

	@Test
	void testAdd() {
		setup1();
		abb.add(10,	100);
		assertTrue(abb.getRoot().getKey().equals(10));
		assertTrue(abb.getRoot().getValue().equals(100));
		assertTrue(abb.getSize() == 1);
		abb.add(40,	50);
		assertTrue(abb.getRoot().getRight().getKey().equals(40));
		assertTrue(abb.getRoot().getRight().getValue().equals(50));
		assertTrue(abb.getSize() == 2);
		abb.add(30,	70);
		assertTrue(abb.getRoot().getRight().getLeft().getKey().equals(30));
		assertTrue(abb.getRoot().getRight().getLeft().getValue().equals(70));
		assertTrue(abb.getSize() == 3);
	}

	@Test
	void testRemove() {
		setup2();

		abb.add(11,	100);

		abb.removeNode(11);

		assertTrue(abb.searchNode(11) == null);
		
		System.out.println(abb.getSize());
		//assertTrue(abb.getSize()==1);
		abb.removeNode(12);

		assertTrue(abb.searchNode(12) == null);

		abb.removeNode(13);

		assertTrue(abb.searchNode(13) == null);


	}

	@Test
	void testSearch() {
		setup3();

		assertTrue(abb.searchNode(15).getKey()==15);

		assertTrue(abb.searchNode(16).getKey()==16);

		assertTrue(abb.searchNode(17).getKey()==17);

		assertTrue(abb.searchNode(18).getKey()==18);

		abb.add(69, 119);

		assertTrue(abb.searchNode(69).getKey()==69);
	}



}
