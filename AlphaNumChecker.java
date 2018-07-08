package Try;

public class isAlphNumBoth{

	private String var1;
	boolean okN1;
	private String varName1;

	public isAlphNumBoth(String var, String varName){
		var1 = var;
		okN1 = true;
		varName1 = varName;

		char[] chars = var1.toCharArray();
		for (char c : chars) {
			if(!Character.isLetter(c)) {
				System.out.println("Tapez le nom du "+varName+" seulement en characters, s'il vous plait.");
				okN1 = false;

			}
		}		
	}
}