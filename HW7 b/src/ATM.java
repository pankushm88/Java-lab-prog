import java.util.*;

public class ATM extends Exception
{
	//let the pin be 124
	int actualPin = 1234;
	//let the amount in account be 2000
	int balance = 2000;
	//let the amount in atm be 5000
	int ATMBalance = 5000;
	int withdrawAmount;
	
	public static void main(String [] arg)
	{
		//declaring variable for taking user input
		Scanner input = new Scanner(System.in);
		
		
		//declaring a object of atm
		ATM object = new ATM();
		
		boolean loop = true;
		//user cannot proceed until he\she enter the correct password
		while(loop)
		{
			//taking in from user
			System.out.println("Enter the pin : ");
			int pin = input.nextInt();
			
			//checking if the pin is correct or not
			if(pin != object.actualPin)
			{
				System.out.println("ENTERED PIN IS INCORRECT.");
				continue;
			}
			loop = false;
		}
		
		//variable used for loop termination
		loop=true;
		while(loop)
		{
			int choice;
			System.out.println("Enter your choice : \n1) Withdraw \n2) Deposit \n3)Check Balance \n 4) Exit");
			//taking user choice
			choice = input.nextInt();
			
			switch(choice)
			{
			case 1:
			{
				//amount to be withdrawn
				//int withdrawAmount;
				System.out.print("Enter amount to be withdrawn : ");
				object.withdrawAmount = input.nextInt();
				if(object.withdrawAmount%100 != 0)
				{
					System.out.println("ENTERED AMOUNT IS INVALID. PLEASE ENTER AMOUNT MULTIPLE OF 100, 500 AND 2000");
				}
				else if(object.withdrawAmount > object.balance)
				{
					System.out.println("AMOUNT AVAILABLE IN YOUR ACCOUNT IS NOT ENOUGH TO WITHDRAW GIVEN AMOUNT.");
				}
				else if(object.withdrawAmount > object.ATMBalance)
				{
					System.out.println("ATM MACHINE DONOT HAVE ENOUGH AMOUNT.");
				}
				break;
			}
			case 2:
			{
				//amount to be deposit
				int depositAmount;
				System.out.print("Enter amount to be deposited : ");
				depositAmount = input.nextInt();
				if(depositAmount%100 != 0)
				{
					System.out.println("ENTERED AMOUNT IS INVALID. PLEASE ENTER AMOUNT MULTIPLE OF 100, 500 AND 2000");
				}
				else
					object.balance += depositAmount;
				break;
			}
			case 3:
			{
				object.balance=object.balance- object.withdrawAmount;
				System.out.println("The amount in your account is : "+object.balance);
				break;
			}
			/*case 4:
			{
				System.out.println("Collect print of transcation history.");
				break;
			}*/
			case 4:
			{
				loop = false;
				break;
			}
			default :
			{
				System.out.println("ENTERED CHOICE IS INCORRECT. PLEASE ENTER A VALID CHOICE");
			}
			}
		}
		
		input.close();
	}
}


