package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import model.Person;
import structure.Trie;

class TestTrie {

	private Trie t ;
	
	public void setup1() {
		t= new Trie();
	}
	public void setup2() {
		t= new Trie();
		String[] words = {"Jose","Lalo","Pipe","Rocky"};
		t.add(words[0]);
		t.add(words[1]);
		t.add(words[2]);
		t.add(words[3]);
	}
	
	public void setup3() {
		t= new Trie();
		String[] words = {"Jhonatan","Alberto","Gloria","Antonio"};
		t.add(words[0]);
		t.add(words[1]);
		t.add(words[2]);
		t.add(words[3]);
	}
	
	@Test
	void testAdd() {
		setup1();

		String[] words = {"Ana","Felipe","Pepe","Rocky"};
		t.add(words[0]);
		t.add(words[1]);
		t.add(words[2]);
		t.add(words[3]);
		
		assertTrue(t.completeSentence("Ana").toString().equals("["+words[0]+"]"));
		assertTrue(t.completeSentence("Felipe").toString().equals("["+words[1]+"]"));
		assertTrue(t.completeSentence("Pepe").toString().equals("["+words[2]+"]"));
		assertTrue(t.completeSentence("Rocky").toString().equals("["+words[3]+"]"));
	}
	
	@Test
	void testSearch() {
		setup2();
		assertTrue(t.search("Pipe") == true);
		assertTrue(t.search("Jhonatan") == false);
		assertTrue(t.search("Lalo") == true);
		assertTrue(t.search("Alberto") == false);
		assertTrue(t.search("Jose") == true);
		assertTrue(t.search("Gloria") == false);
		assertTrue(t.search("Rocky") == true);
	}
	
	@Test
	void testCompleteSentences() {
		setup3();
		assertTrue(t.completeSentence("J").toString().equals("["+"Jhonatan"+"]"));
		assertTrue(t.completeSentence("h").toString().equals("["+"]"));
		assertTrue(t.completeSentence("G").toString().equals("["+"Gloria"+"]"));
		assertTrue(t.completeSentence("A").toString().equals("["+"Alberto, Antonio"+"]"));
		t.add("Armando");
		assertTrue(t.completeSentence("A").toString().equals("["+"Alberto, Antonio, Armando"+"]"));
		assertTrue(t.completeSentence("Albe").toString().equals("["+"Alberto"+"]"));
		assertTrue(t.completeSentence("Arma").toString().equals("["+"Armando"+"]"));
		assertTrue(t.completeSentence("An").toString().equals("["+"Antonio"+"]"));
	}
}
