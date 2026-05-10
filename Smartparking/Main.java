package Smartparking;
import java.util.*;
public class Main{
	public static void main(String args[]){




		Scanner sc=new Scanner(System.in);
		DB db=new DB();
		int choice;
		while(true){
			System.out.println("\n===== SMART PARKING SYSTEM =====");
            System.out.println("1. Park a Car");
            System.out.println("2. Park a Bike");
            System.out.println("3. Show OVERALL record");
            System.out.println("4. Total revenue ");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); 

            if (choice == 5) {
                System.out.println("Thank you for using Smart Parking System. Goodbye!");
                break; 
            }
            if(choice==4){
            	db.revenue();
            	continue;
            }
            if(choice==3){
            	db.showData();
            	continue;
            }

            if (choice != 1 && choice != 2 ) {
                System.out.println("Invalid choice! Please enter 1, 2, 3 or 4.");
                continue; 
            }
            System.out.println("Enter  number: ");
			String no=sc.nextLine();
			System.out.println("enter hours: ");	
			double h=sc.nextDouble();

			Parkable p;
			String type;

		if(choice==1){
			p=new CarParking(20,40,150);
			type="Car";
			
				
		}else{
			p=new BikeParking(10,40,100);
			type="Bike"; 	

		}
		double fee = p.feeForHours(h);
		System.out.println(p.buildReceipt(no,h));
		
			db.insertData(type,no,h,fee);
				
		}




		}
	
		
	}
