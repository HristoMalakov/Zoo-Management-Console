package Try;


import java.io.*;
import java.util.*;

public class FileSearch {

	String SS=null;
	private boolean ok;
	public FileSearch(String fileName) throws FileNotFoundException{

		do{
			try{
				ok=true;
				Scanner in = new Scanner(System.in);
				System.out.println("Qu'est-ce que vous voulez chercher? (Tapez ' ' si vous voulez acceder toute la base de donnees).");
				String searched = in.nextLine().toString();
				SS = searched;

				char[] SSA = SS.toCharArray();

				for (char c: SSA) {
					if( !Character.isLetter(c) && !Character.isDigit(c) && c!=' ') {
						System.out.println("Chercher pour un animal (ecrit seulement en characters), un nombre d'identite (ecrit seulement en nombres entiers) et un pays (ecrit seulement en characters).");
						ok = false;				
					}
				}
			}
			catch(Exception e){
				System.out.println("ERREUR: "+e);
				ok = false;
			}  
		}while(!ok);

		Scanner scan = new Scanner(new File(fileName));
		int c=0;


		String first = (scan.nextLine()+"\n").toString();

		while(scan.hasNext()){

			String line = scan.nextLine().toString();

			if(line.toLowerCase().contains(SS.toLowerCase())){

				System.out.print(first);			
				System.out.println(line);

				first = "";
				c++;
			}

		}
		if(c==0){
			System.out.println("Ce que vous cherchez n'a pas ete trouve a la base de donnees.");
		}
	}

}
