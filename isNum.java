package Try;

public class isNum {

	 boolean okI1 = true;

	public isNum(String ID)  
	{  
		try  
		{  
			int d = Integer.parseInt(ID);  
		}  
		catch(NumberFormatException e)  
		{  
			System.out.println("Please type the ID of the animal with whole numbers only.");
			okI1 = false;  
		}  

	}

}
