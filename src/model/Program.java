package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import structure.AVLTree;

public class Program implements Serializable{

	private ArrayList<String> randomNames, randomLastNames;
	private AVLTree<String, Person> avlNames = new AVLTree<String, Person>();
	private AVLTree<String, Person> avlLastNames = new AVLTree<String, Person>();
	private AVLTree<String, Person> avlNamesLastNames = new AVLTree<String, Person>();
	private AVLTree<Integer, Person> avlCode = new AVLTree<Integer, Person>();
	private ArrayList<Person> arrayListPersons= new ArrayList<>();
			
	/**
	 * Constructor Method
	 * @throws IOException
	 */
	public Program() throws IOException {
			loadNames();
			loadLastNames();
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
			String[]line2=line1.split(",");
			randomNames.add(line2[0]);	
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
		avlCode.insert(p.getCode(), p);
		if(arrayListPersons.size()<100) {
			arrayListPersons.add(p);
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
	
}
