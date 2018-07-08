package Try;
import java.io.*;
import java.util.*;

public class Zoo {
	public static String fileName = "zoo3.txt";

	public static void main(String[] args) throws FileNotFoundException{

		Scanner in = new Scanner(System.in);
		boolean k=false;

		do{

			System.out.println("Qu'est-ce que vous voulez faire?");
			System.out.println("Pressez 1 pour importer un animal.");
			System.out.println("Pressez 2 pour chercher un animal.");
			System.out.println("Pressez 3 pour supprimer un animal.");
			System.out.println("Pressez 4 pour terminer le programme.");
			try{
				int ch=0;
				ch = Integer.parseInt(in.nextLine());

				switch(ch){
				case 1:
					FileFilling fileFilling = new FileFilling();
					k=true;break;
				case 2: 
					FileSearch fileSearch = new FileSearch(fileName);
					k=true;break;
				case 3:
					FileDelete fileDelete = new FileDelete(fileName);
					k=true;break;
				case 4:
					System.out.println("Bonne journee.");
					k=false;break;
				}
			}
			catch(Exception e){
				System.out.println("ERREUR: "+e);
				System.out.println("Entrez un nombre entre 1 et 4, s'il vous plait.");
				k=true;
			}

		}while(k);

	}

}
