package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import structure.Trie;
import structure.AVLTree;

public class Program implements Serializable{

	private ArrayList<String> randomNames, randomLastNames,randomCountry;
	private ArrayList<String> autocomplete = new ArrayList<>();
	private AVLTree<String, Person> avlNames = new AVLTree<String, Person>();
	private AVLTree<String, Person> avlLastNames = new AVLTree<String, Person>();
	private AVLTree<String, Person> avlNamesLastNames = new AVLTree<String, Person>();
	private AVLTree<Integer, Person> avlCode = new AVLTree<Integer, Person>();
	private ArrayList<Person> arrayListPersons= new ArrayList<>();
	private Trie t = new Trie();
	

	/**
	 * Constructor Method
	 * @throws IOException
	 */
	public Program() throws IOException {
		loadNames();
		loadLastNames();
		loadCountries();
	}


	/**
	 * This method reads the names from a .CSV file, and add them to an arrayList.
	 * @throws IOException
	 */
	public void loadNames() throws IOException {
		randomNames= new ArrayList<>();

		BufferedReader br = new BufferedReader(new FileReader(new File("data/files/names_data.csv")));
		String line1;

		while((line1 = br.readLine())!= null) {

			randomNames.add(line1);	
		}
		br.close();
	}


	/**
	 * This method reads the lastnames from a .CSV file, and add them to an arrayList.
	 * @throws IOException
	 */
	public void loadLastNames() throws IOException {
		randomLastNames= new ArrayList<>();

		BufferedReader br = new BufferedReader(new FileReader(new File("data/files/lastNames_data.csv")));
		String line1;
		br.readLine();
		while((line1 = br.readLine())!= null) {
			String[]line2=line1.split(",");
			if(!line2[0].equals("ALL OTHER NAMES")) {
				randomLastNames.add(line2[0]);	
			}
		}
		br.close();
	}


	/**
	 * This method is in charge of adding a person to the 4 different balanced trees.
	 * @param p
	 */
	public void addPersonTrees(Person p) {

		avlNames.insert(p.getName(), p);
		avlLastNames.insert(p.getLastName(), p);
		String nameLastName= p.getName()+" "+p.getLastName();
		avlNamesLastNames.insert(nameLastName, p);

		autocomplete.add(p.getName());
		autocomplete.add(p.getLastName());
		t.add(p.getName());
		t.add(p.getLastName());
		t.add(p.getName()+" "+p.getLastName());
		avlCode.insert(p.getCode(), p);
		if(arrayListPersons.size()<100) {
			arrayListPersons.add(p);
		}

	}
	
	public void loadCountries() throws IOException {
		randomCountry= new ArrayList<>();

		BufferedReader br = new BufferedReader(new FileReader(new File("data/files/population_by_country_2020.csv")));
		String line1;
		br.readLine();
		while((line1 = br.readLine())!= null) {
			String[]line2=line1.split(",");
			randomCountry.add(line2[0]);	
			
		}
		br.close();
	}
	public void addPersonWithArchives(int cantidad) {



		for(int i=0;i<cantidad;i++) {
			int indexName=(int) (Math.random() * (randomNames.size()-1) + 1);
			int indexLastname=(int) (Math.random() * (randomLastNames.size()-1) + 1);
			int indexCountry=(int) (Math.random() * (randomCountry.size()-1) + 1);

			String arr[]= randomNames.get(indexName).split(",");
			String name =arr[0];
			String lastName= randomLastNames.get(indexLastname);
			String sex =arr[1];
			String country= randomCountry.get(indexCountry);

			LocalDate n ;
			Random aleatorio=new Random();
			if(i< cantidad*0.12) {//1

				n = LocalDate.of(aleatorio.nextInt(9)+1956, aleatorio.nextInt(12)+1, aleatorio.nextInt(27)+1);
			}//446200
			else if(i< cantidad*0.25 && i>cantidad*0.12) {//2

				n = LocalDate.of(aleatorio.nextInt(9)+1996, aleatorio.nextInt(12)+1, aleatorio.nextInt(27)+1);
			}//731760
			else if(i < cantidad*0.41 && i >cantidad*0.25) {//3

				n = LocalDate.of(-aleatorio.nextInt(10)+1955, aleatorio.nextInt(12)+1, aleatorio.nextInt(27)+1);
			}//1053024
			else if(i < cantidad*0.59 && i>cantidad*0.41) {//4

				n = LocalDate.of(aleatorio.nextInt(14)+2006, aleatorio.nextInt(12)+1, aleatorio.nextInt(27)+1);
			}
			else {//5
				n = LocalDate.of(aleatorio.nextInt(29)+1966, aleatorio.nextInt(12)+1, aleatorio.nextInt(27)+1);
			}
			Person p = new Person(name, lastName, country, sex,"", n, aleatorio.nextInt(20)+155, (autocomplete.size()/2)+1);
			addPersonTrees(p);


		}

	}

	public void deleteInArrayByCode(int code) {

		for(int i=0;i<arrayListPersons.size();i++) {
			if(arrayListPersons.get(i).getCode()==code) {
				arrayListPersons.remove(i);
			}
		}

	}

	public int searchInArrayByCode(int code) {

		int index=0;
		for(int i=0;i<arrayListPersons.size();i++) {
			if(arrayListPersons.get(i).getCode()==code) {
				index=i;
			}
		}
		return index;
	}


	public ArrayList<Person> getArrayListPersons() {
		return arrayListPersons;
	}


	public void setArrayListPersons(ArrayList<Person> arrayListPersons) {
		this.arrayListPersons = arrayListPersons;
	}




	public AVLTree<String, Person> getAvlNames() {
		return avlNames;
	}


	public void setAvlNames(AVLTree<String, Person> avlNames) {
		this.avlNames = avlNames;
	}


	public AVLTree<String, Person> getAvlLastNames() {
		return avlLastNames;
	}


	public void setAvlLastNames(AVLTree<String, Person> avlLastNames) {
		this.avlLastNames = avlLastNames;
	}


	public AVLTree<String, Person> getAvlNamesLastNames() {
		return avlNamesLastNames;
	}


	public void setAvlNamesLastNames(AVLTree<String, Person> avlNamesLastNames) {
		this.avlNamesLastNames = avlNamesLastNames;
	}


	public AVLTree<Integer, Person> getAvlCode() {
		return avlCode;
	}


	public void setAvlCode(AVLTree<Integer, Person> avlCode) {
		this.avlCode = avlCode;
	}


	public void a () {
		for (int i = 0; i < randomNames.size(); i++) {
			System.out.println(randomNames.get(i)+" "+i);
		} 
	}
	public void b () {
		for (int i = 0; i < randomLastNames.size(); i++) {
			System.out.println(randomLastNames.get(i)+" "+i);
		} 
	}
	public void c () {
		for (int i = 0; i < randomCountry.size(); i++) {
			System.out.println(randomCountry.get(i)+" "+i);
		} 
	}

	public ArrayList<String> getRandomNames() {
		return randomNames;
	}

	public ArrayList<String> getRandomLastNames() {
		return randomLastNames;
	}

	public void setRandomNames(ArrayList<String> randomNames) {
		this.randomNames = randomNames;
	}

	public void setRandomLastNames(ArrayList<String> randomLastNames) {
		this.randomLastNames = randomLastNames;
	}


	public ArrayList<String> getAutocomplete() {
		return autocomplete;
	}


	public void setAutocomplete(ArrayList<String> autocomplete) {
		this.autocomplete = autocomplete;
	}
	public ArrayList<String> getAutocomplete2(String s){
		autocomplete = (ArrayList<String>) autoCompleteName(s);
		return autocomplete;
	}
	
	public List<String> autoCompleteName(String TheSearchingWord) {
		return t.completeSentence(TheSearchingWord);

	}
	

}
