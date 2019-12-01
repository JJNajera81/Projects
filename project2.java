import java.util.Scanner;
public class project2 {

	// BONUES FIBONACCI //
	// Man made Fibonacci sequance: 
	//  Univeirsty of Wisconsin Library Plaza, Imitaites a Fibonacci sequence
	// Nature: Plants and leafs, going around the 
	// stem, leaf to leaf, counting the leafs until you encounter
	//	the leaf directly above it
	
									
	public static String main(String[] args) {										
																		
			Scanner scn=new Scanner(System.in);						
				System.out.print("Please set your password: ");					// User will set password
				String password=scn.next();										// Program will jump to next line
				
				password=encrypt(password);										//Enrycption and store
				System.out.println("The Password is set..!!\n");				//Replies set password
				
				System.out.print("Please enter password to login: ");			//Program will ask for password
				int Attempts=0;													
				while (Attempts <3)
				{ Attempts++;
				String x = scn.next();
				if(x.equals(password))											// If password is correct, program
				{																//	will jump into succeful log in
					System.out.println("Successfully Logged in..!");
					System.out.println("Enter a number for Fibonacci series:");	// Fibonacci series number
						int n=scn.nextInt();
						int a=0;
						int b=1;
						int c;
						
						for(int j=2;j<=n;j++)
						{
							c=a+b;
							a=b;
							b=c;
						}
							System.out.println("The "+n+"the fibonacci number is: "+b);		//Fibonancci number is printed
							System.exit(0);
							break;
				}
				
				else if(Attempts == 1 || Attempts == 2) {									// Incorrect password three
					System.out.println("Password is Incorrect! Please Try again!");			// times blocks user
				}																			// 1st time
				else if(Attempts == 3) {														
					System.out.println("Password is incorrect! Please Try again!");			// 2nd
				}
					System.out.print("Out of Chances, Please try again later");				// 3rd
				}																			// Incorrect password ends the program
	}
				public static String encrypt(String password) {
				return null;
				}
			
				{
				return "P4$$w0rd_1$_N0w_$4f3"+password+"P4$$w0rd_1$_N0w_$4f3";				//Concatenate
				}
	
	}


