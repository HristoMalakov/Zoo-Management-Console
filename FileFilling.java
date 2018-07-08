package Try;

import java.io.*;
import java.lang.*;
import java.util.*;

public class FileFilling {

	public FileFilling(){


		File zooFile = new File("zoo3.txt");
		String strA="Animal";
		String strN="NI";
		String strC="Importe de";


		Scanner in = new Scanner(System.in);

		boolean ok=false;

		do{

			try{

				PrintWriter output = new PrintWriter(new FileWriter(zooFile, true));

				BufferedReader br = new BufferedReader(new FileReader(zooFile));     
				if (br.readLine() == null) {

					output.printf("%-20s|%-6s|%-20s\n",strA,strN,strC);
				} 

				String sA=null; int IN=0; String sC=null; String sN=null;
				boolean okN=true; boolean okI = true; boolean okC = true;

				do{

					System.out.println("Quel animal importez-vous?");

					sA = in.nextLine();
					isAlphNumBoth NA = new isAlphNumBoth(sA,"animal");
					okN = NA.okN1;

				}while(!okN);

				do{

					try  
					{  
						System.out.println("Quel est son nombre d'identite?(NI)"); 
						IN = Integer.parseInt(in.nextLine());
						okI=true;
					}  
					catch(NumberFormatException e)  
					{  
						System.out.println("Entrez le nom du animal en nombres entiers, s'il vous plait.");
						okI = false;  
					}

				}while(!okI);

				do{

					System.out.println("Quel est le pays d'origine de l'animal?");

					sC = in.nextLine();	
					isAlphNumBoth NA = new isAlphNumBoth(sC,"pays");
					okC = NA.okN1;

				}while(!okC);

				output.printf("%-20s|%-6d|%-20s\n",sA,IN,sC);

				boolean ImportAnimalCheck;
				String answer;

				do{
					ImportAnimalCheck=true;
					System.out.println("Voulez-vous importer un autre animal? (oui/non)\n");
					answer = in.nextLine().toLowerCase().toString();

					if(!answer.equals("oui") && !answer.equals("non")){
						System.out.println("Tapez 'oui' si vous voulez importer un autre animal et 'non' si vous ne le voulez pas.");
						ImportAnimalCheck=false;
					}

				}while(!ImportAnimalCheck);

				if(answer.equals("oui"))
					ok=false;
				else
					ok=true;

				output.close();

			}

			catch(Exception e){

				System.out.printf("ERREUR: %s", e);
			}

		}while(!ok);

	}

}

