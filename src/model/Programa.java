package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Programa {

	private ArrayList<String> randomNames, randomLastNames;
	
	public Programa() throws IOException {
		randomNames= new ArrayList<>();
		loadNames();
		randomLastNames= new ArrayList<>();
		loadLastNames();
	}
	
	public void loadNames() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\USUARIO\\Documents\\GitHub\\Data-Base\\data\\names\\names_data.csv")));
		String line1;
		
		while((line1 = br.readLine())!= null) {
			String[]line2=line1.split(",");
			randomNames.add(line2[0]);	
		}
		br.close();
	}
	
	public void loadLastNames() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\USUARIO\\Documents\\GitHub\\Data-Base\\data\\names\\LastNames_data.csv")));
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
