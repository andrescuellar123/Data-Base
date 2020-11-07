package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import model.Person;
import structure.AVLTree;

class TestAVLTree {
	
	private AVLTree<String, Person> t = new AVLTree<String, Person>();
	public void setup1() {
		String name = "pepe";
		String lastName = "Gonzales";
		String nacionality = "Colombia";
		String sex = "boy";
		LocalDate dateBirth = LocalDate.of(2000,12,12);
		Person p = new Person(name, lastName, nacionality, sex, "",dateBirth , 180	, 1);
		t.insert(name, p);
	}
	
	public void setup2() {
		String name = "Zuleima";
		String lastName = "Perez";
		String nacionality = "Colombia";
		String sex = "girl";
		LocalDate dateBirth = LocalDate.of(2000,12,12);
		Person p = new Person(name, lastName, nacionality, sex, "",dateBirth , 180	, 1);
		t.insert(name, p);
	}
	public void setup3() {
		String name = "Paco";
		String lastName = "Hernandez";
		String nacionality = "Colombia";
		String sex = "boy";
		LocalDate dateBirth = LocalDate.of(1990,12,12);
		Person p = new Person(name, lastName, nacionality, sex, "",dateBirth , 180	, 1);
		t.insert(name, p);
	}
	public void setup4() {
		String name = "Pablo";
		String lastName = "Villegas";
		String nacionality = "Colombia";
		String sex = "boy";
		LocalDate dateBirth = LocalDate.of(1960,11,11);
		Person p = new Person(name, lastName, nacionality, sex, "",dateBirth , 180	, 1);
		t.insert(name, p);
	}
	public void setup5() {
		String name = "Viviana";
		String lastName = "Vargas";
		String nacionality = "Colombia";
		String sex = "girl";
		LocalDate dateBirth = LocalDate.of(1968,8,11);
		Person p = new Person(name, lastName, nacionality, sex, "",dateBirth , 180	, 1);
		t.insert(name, p);
	}
	@Test	
	void testGetMin() {
		setup1();

		assertTrue(t.getMin().equals("pepe"));
		LocalDate dateBirth = LocalDate.of(2000,2,2);
		Person p = new Person("andy", "lopez", "Colombia", "boy", "",dateBirth , 160	, 1);
		t.insert("andy", p);
		assertTrue(t.getMin().equals("andy"));
		
	}
	@Test
	void testGetMax() {
		setup2();

		assertTrue(t.getMax().equals("Zuleima"));
		LocalDate dateBirth = LocalDate.of(2000,2,2);
		Person p = new Person("andy", "lopez", "Colombia", "boy", "",dateBirth , 160	, 1);
		t.insert("andy", p);
		assertTrue(t.getMin().equals("Zuleima"));
		
	}
	@Test
	void testGetPredecessor() {
		setup3();

		LocalDate dateBirth = LocalDate.of(2000,2,2);
		Person p = new Person("andy", "lopez", "Colombia", "boy", "",dateBirth , 160	, 1);
		t.insert("andy", p);
		assertTrue(t.getPredecessor("andy").equals("Paco"));
		
	}
	
	@Test
	void testGetSucessor() {
		setup4();
		
		
		LocalDate dateBirth = LocalDate.of(2000,2,2);
		Person p = new Person("andy", "lopez", "Colombia", "boy", "",dateBirth , 160	, 1);
		t.insert("andy", p);
		assertTrue(t.getSuccessor("Pablo").equals("andy"));
		
	}
	@Test
	void testGetWeight() {
		setup5();
		
		assertTrue(t.getWeight() == 1);
		LocalDate dateBirth = LocalDate.of(2000,2,2);
		Person p = new Person("Harry", "Potter", "Colombia", "boy", "",dateBirth , 160	, 1);
		t.insert("Harry", p);
		assertTrue(t.getWeight() == 2);
		
	}
	@Test
	void testSearch() {
		setup5();
		
		assertTrue(t.search("Viviana").getLastName().equals("Vargas"));
		LocalDate dateBirth = LocalDate.of(2000,2,2);
		Person p = new Person("Pepe", "Grillo", "Colombia", "boy", "",dateBirth , 160	, 1);
		t.insert("Pepe", p);
		assertTrue(t.search("Pepe").getLastName().equals("Grillo"));
		
	}
	@Test
	void testInsert() {
		setup5();
		
		assertTrue(t.search("Viviana").getLastName().equals("Vargas"));
		LocalDate dateBirth = LocalDate.of(2000,2,2);
		Person p = new Person("Felipe", "Perez", "Colombia", "boy", "",dateBirth , 160	, 1);
		t.insert("Felipe", p);
		assertTrue(t.search("Felipe").getLastName().equals("Perez"));
		
	}
	void testDelete() {
		setup5();
		System.out.println(t.delete("Viviana") +"wqeqw");
		assertTrue(t.delete("Viviana").getLastName().equals("Vargas"));
		LocalDate dateBirth = LocalDate.of(2000,2,2);
		Person p = new Person("Felipe", "Perez", "Colombia", "boy", "",dateBirth , 160	, 1);
		t.insert("Felipe", p);
		assertTrue(t.delete("Felipe").getLastName().equals("Perez"));
		
	}
}
