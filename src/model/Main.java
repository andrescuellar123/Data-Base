package model;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Program p = new Program();

		p.addAll(0, 18);
		//p.preorden(p.getRootName());
		System.out.println(p.searchName("David", p.getRootName()).getLastName());
	}

}
