package Try;

import java.io.*;
import java.lang.*;
import java.util.*;

public class FileDelete {

	public FileDelete(String fileName){

		Scanner in = new Scanner(System.in);
		File inputFile = new File(fileName);
		File tempFile = new File("TempZoo4.txt");
		boolean ok; String lineToDelete=null;

		try{
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			//BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
			PrintWriter writer = new PrintWriter(new FileWriter(tempFile));

			System.out.println("Vous pouvez supprimer toutes les lignes qui contiennent un animal, un pays ou un NI choisi.");
			System.out.println("Quelle est la ligne que vous voulez supprimer?");

			do{
				lineToDelete = in.nextLine();
				ok=true;

				char[] SSA = lineToDelete.toCharArray();
				int k=0;
				for (char c: SSA) {
					if( !( Character.isLetter(c) || Character.isDigit(c) ) && c!=' ' )
						k++;
				}
				if(k!=0){
					System.out.println("Supprimer un animal (ecrit seulement en characters), un nombre d'identite (ecrit seulement en nombres entiers) ou un pays (ecrit seulement en characters).");
					ok = false;
				}
			}while(!ok);


			String currentLine;

			while( (currentLine = reader.readLine()) != null) {
				// trim newline when comparing with lineToRemove
				String lineToTrim = currentLine.trim();

				if(lineToTrim.toLowerCase().contains(lineToDelete.toLowerCase()))
					continue;
				writer.write(currentLine +"\n");
			}

			writer.close(); 
			reader.close(); 
		}
		catch(Exception e){
			System.out.println("ERROR: "+e);	
		}
		tempFile.renameTo(inputFile);


	}

}
