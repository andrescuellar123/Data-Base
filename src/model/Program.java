package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Program {

	private ArrayList<String> randomNames, randomLastNames;
	
	private Person rootName;
	public Program() throws IOException {
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
	
	

	public void addAll(int inicio, int fin) {
		for (int i = inicio; i < fin; i++) {

			String arr = randomNames.get(i);
			
			for (int j = 0; j < randomLastNames.size(); j++) {

				String lastName = randomLastNames.get(j);
	

				insert(arr, lastName, "colo", "", new Date(), 18);
			
			}
		}
	}
	public int obtainFE(Person x){
		if(x==null){
			return -1;
		}else{
			return x.getFe();
		}
	}


	public Person leftRotation(Person c){
		Person auxiliar=c.getLeft();
		if(auxiliar!=null) {
			c.setLeft(auxiliar.getRight());
			auxiliar.setRight(c);
			c.setFe(Math.max(obtainFE(c.getLeft()), obtainFE(c.getRight()))+1);  //obtiene el maximo
			auxiliar.setFe(Math.max(obtainFE(auxiliar.getLeft()), obtainFE(auxiliar.getRight()))+1);
		}
		return auxiliar;
	}


	public Person rightRotation(Person c){

		Person auxiliar=c.getRight();
		if(auxiliar!=null) {
			c.setRight(auxiliar.getLeft());
			auxiliar.setLeft(c);
			c.setFe(Math.max(obtainFE(c.getLeft()), obtainFE(c.getRight()))+1);  //obtiene el maximo
			auxiliar.setFe(Math.max(obtainFE(auxiliar.getLeft()), obtainFE(auxiliar.getRight()))+1);
		}
		return auxiliar;
	}



	public Person doubleLeftRotation(Person c){
		Person temporal;
		c.setLeft(rightRotation(c.getLeft()));
		temporal=leftRotation(c);
		return temporal;

	}

	public Person doubleRightRotation(Person c){
		Person temporal;
		c.setRight( leftRotation(c.getRight()));
		temporal=rightRotation(c);
		return temporal;
	}


	public Person insertAVL(Person nuevo, Person subAr){
		Person nuevoPadre=subAr;
		if(nuevo.getName().compareTo(subAr.getName())<0){
			if(subAr.getLeft()==null){
				subAr.setLeft(nuevo);
			}else{
				subAr.setLeft(insertAVL(nuevo, subAr.getLeft()));
				if((obtainFE(subAr.getLeft())-obtainFE(subAr.getRight())==2)){
					if(nuevo.getName().compareTo(subAr.getLeft().getName())<0){
						nuevoPadre=leftRotation(subAr);
					}else{
						nuevoPadre=doubleLeftRotation(subAr);
					}
				}
			}
		}else if(nuevo.getName().compareTo(subAr.getName())>0){
			if(subAr.getRight()==null){
				subAr.setRight(nuevo);
			}else{
				subAr.setRight(insertAVL(nuevo, subAr.getRight()));
				if((obtainFE(subAr.getRight())-obtainFE(subAr.getLeft())==2)){
					if(nuevo.getName().compareTo(subAr.getRight().getName())>0){
						nuevoPadre=rightRotation(subAr);
					}else{
						nuevoPadre=doubleRightRotation(subAr);
					}
				}
			}
		}else {//son iguales
			if(nuevo.getLastName().compareTo(subAr.getLastName())<0){
				if(subAr.getLeft()==null){
					subAr.setLeft(nuevo);
				}else{
					subAr.setLeft(insertAVL(nuevo, subAr.getLeft()));
					if((obtainFE(subAr.getLeft())-obtainFE(subAr.getRight())==2)){
						if(nuevo.getLastName().compareTo(subAr.getLeft().getLastName())<0){
							nuevoPadre=leftRotation(subAr);
						}else{
							nuevoPadre=doubleLeftRotation(subAr);
						}
					}
				}
			}else if(nuevo.getLastName().compareTo(subAr.getLastName())>0){
				if(subAr.getRight()==null){
					subAr.setRight(nuevo);
				}else{
					subAr.setRight(insertAVL(nuevo, subAr.getRight()));
					if((obtainFE(subAr.getRight())-obtainFE(subAr.getLeft())==2)){
						if(nuevo.getLastName().compareTo(subAr.getRight().getLastName())>0){
							nuevoPadre=rightRotation(subAr);
						}else{
							nuevoPadre=doubleRightRotation(subAr);
						}
					}
				}
			}
		}

		//actualizar altura
		if((subAr.getLeft()==null)&&(subAr.getRight()!=null)){
			subAr.setFe(subAr.getRight().getFe()+1);
		}else if((subAr.getRight()==null)&&(subAr.getLeft()!=null)){
			subAr.setFe(subAr.getLeft().getFe()+1);
		}else{
			subAr.setFe(Math.max(obtainFE(subAr.getLeft()), obtainFE(subAr.getRight()))+1);
		}
		return nuevoPadre;
	}



	public void insert(String name, String lastName, String nacionality, String sex, Date dateBirth,
			double height){
		Person nuevo= new Person(name, lastName, nacionality, sex, dateBirth, height);
		if(rootName==null){
			rootName=nuevo;
		}else{
			rootName=insertAVL(nuevo, rootName);
		}
	}




	public void preorden(Person r){
		if(r!=null){
			System.out.println(r.getName()+" "+r.getLastName());
			preorden(r.getLeft());
			preorden(r.getRight());
		}
	}

	public Person getRootName() {
		return rootName;
	}

	public void setRootName(Person rootName) {
		this.rootName = rootName;
	}
	public Person searchName(String name ,Person rot) {
		if(rootName == null) {
			return null;
		}
		else if(rot.getName().equals(name)) {
			return rot;
		}
		else if(rot.getName().compareTo(name)<0){
			return searchName(name,rot.getRight());
		}
		else {
			return searchName(name,rot.getLeft());
		}
	}

}
