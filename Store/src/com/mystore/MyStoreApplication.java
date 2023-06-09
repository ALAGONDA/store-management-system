package com.mystore;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.mystore.CustomerProductsDTO;
import com.mystore.Product;
import com.mystore.Type;

public class MyStoreApplication {

	public static void main(String[] args) 
	{
		/*  Here the user will  add the products that are available
  	 			in the store on that day*/ 
 			Product milk = new Product(1, "milk", 60.00, Type.Liters);
			Product curd = new Product(2, "curd", 50.00, Type.Liters);
			Product tomato = new Product(3, "tomato", 30.00, Type.Kilograms);
			Product potato = new Product(4, "potato", 20.00, Type.Kilograms);
			Product grapes = new Product(5, "grapes", 50.00, Type.Kilograms);
			Product wheat = new Product(6, "wheat", 100.00, Type.Kilograms);
			List<Product> products = new ArrayList<>();
			products.add(milk);
			products.add(curd);
			products.add(tomato);
			products.add(potato);
			products.add(grapes);
			products.add(wheat);
			
			System.out.println("Enter the User Credentials .... \n");		/*the authorized user is only allowed to this        */

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the User Name : \n");
			String email = sc.next();
			System.out.println("Enter the Password : \n");
			String pass = sc.next();

			if (email.equalsIgnoreCase("sagararun323@gmail.com") && pass.equalsIgnoreCase("arun"))
			{
				System.out.println("\t\t---------Welcome to MyStore--------");
				Iterator<Product> itr = products.iterator();	/* Here all the products that are available in the store will be displayed to the customer */
				while (itr.hasNext())
				{
					System.out.println("\t"+itr.next());
				}
			for(int i=1;i<=2;i++) {
				System.out.println("\nEnter the id to add the products in your  cart.. :");		
				 
				List<CustomerProductsDTO> customerList = new ArrayList<>();
				Double totalPrice = 0.0;
				/* The customer will demand the products that he/she wants, 
				    And the customer has to enter the ProductId's that they want and a;so need to mention the quantity of the product they want.
				    after entering the all the required products they want customer has to enter '100' to close the cart and start the billing   */
				while (true) {
					int input = sc.nextInt();
					if (input == 1) {
						System.out.println("Enter the Number of Liters of milk :");
						Double quantity = sc.nextDouble();
						totalPrice += quantity * milk.getPrice();
						customerList.add(new CustomerProductsDTO(1, "milk", quantity  ,Type.Liters,milk.getPrice()*quantity));
					}
					if (input == 2) {
						System.out.println("Enter the Number of Liters of curd :");
						Double quantity = sc.nextDouble();
						totalPrice += quantity * curd.getPrice();
						customerList.add(new CustomerProductsDTO(2, "curd",  quantity,Type.Liters,curd.getPrice()*quantity));
					}
					if (input == 3) {
						System.out.println("Enter the how many kg's of tomato :");
						Double quantity = sc.nextDouble();
						totalPrice += quantity * tomato.getPrice();
						customerList.add(new CustomerProductsDTO(3, "tomato", quantity,Type.Kilograms,tomato.getPrice()*quantity ));
					}
					if (input == 4) {
						System.out.println("Enter the how many kg's of potato :");
						Double quantity = sc.nextDouble();
						totalPrice += quantity * potato.getPrice();
						customerList.add(new CustomerProductsDTO(4, "potato", quantity, Type.Kilograms,potato.getPrice()*quantity));
					}
					if (input == 5) {
						System.out.println("Enter the how many kg's of grapes :");
						Double quantity = sc.nextDouble();
						totalPrice += quantity * grapes.getPrice();
						customerList.add(new CustomerProductsDTO(5, "grapes", quantity, Type.Kilograms,grapes.getPrice()*quantity));
					}
					if (input == 6) {
						System.out.println("Enter the how many kg's of wheat :");
						Double quantity = sc.nextDouble();
						totalPrice += quantity * wheat.getPrice();
						customerList.add(new CustomerProductsDTO(6, "wheat", quantity,Type.Kilograms,wheat.getPrice()*quantity));
					}
				//Helps the store user to easily remove the items as per customer's requirement
					if(input==111)
					{
						System.out.println("Enter the products Id you wants to remove :");
						int remove=sc.nextInt();
						if(remove==1) {
							System.out.println("Number of Liters of milk you choose to remove : ");
							Double quantity = sc.nextDouble();
							totalPrice -= quantity*milk.remove(milk.getPrice());
							System.out.println(totalPrice);
							}
						if(remove==2) {
							System.out.println("Number of Liters of curd you choose to remove : ");
							Double quantity = sc.nextDouble();
							
							totalPrice -= quantity*curd.remove(curd.getPrice());
							System.out.println(totalPrice);
						}
						if(remove==3) {
							System.out.println("Number of Kg's of tomato you choose to remove : ");
							Double quantity = sc.nextDouble();
							
							totalPrice -= quantity*tomato.remove(tomato.getPrice());
							System.out.println(totalPrice);
						}
						if(remove==4) {
							System.out.println("Number of Kg's of potato you choose to remove : ");
							Double quantity = sc.nextDouble();
							
							totalPrice -= quantity*potato.remove(potato.getPrice());
							System.out.println(totalPrice);
						}
						if(remove==5) {
							System.out.println("Number of Kg's of grapes you choose to remove : ");
							Double quantity = sc.nextDouble();
							
							totalPrice -= quantity*grapes.remove(grapes.getPrice());
							System.out.println(totalPrice);
						}
						if(remove==6) {
							System.out.println("Number of Kg's of wheat you choose to remove : ");
							Double quantity = sc.nextDouble();
							
							totalPrice -= quantity*wheat.remove(wheat.getPrice());
							System.out.println(totalPrice);
						}
					}
					if (input == 100) {
						break;
					}
					System.out.println("To continue enter the listed products id to add in the cart..");
					System.out.println("If you are done with selection then enter 100  to exit...");
			    }
			    serialazationcode();
				Thread wait=new Thread();
				try
				{
					System.out.println("Your items are ready for the billing..3..2..1..GO " );
					wait.sleep(1000);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				wait.start();
				/* Using collections all the demanded products are listed down in the console */
				System.out.println("\t\t\t----checkout your cart----- ");
				Iterator<CustomerProductsDTO> customerListItr = customerList.iterator();
				while (customerListItr.hasNext()) {
					System.out.println(customerListItr.next());
				}
				/* All the products are listed and totaled the cost of the products to be paid to the store*/
				System.out.println("TotalPrice of selected items : " + totalPrice);
				deserialazationcode();	
				System.out.println("\t\t\t  VISIT AGAIN\n\t\t\t-----THANK YOU-----" );
			}
			
			}
			/* If an unauthorized person came it won't allow    */	
			else
			 {
				System.out.println("Invalid Credentials..!");			
		   	 }
			
		}
		
		static void serialazationcode() {
			try(FileOutputStream fout=new FileOutputStream("F:\\store.txt"); 
//					FileOutputStream fout2=new FileOutputStream("F:\\Store")
					)
			{
				Scanner s=new Scanner(System.in);
				System.out.println("Enter the customer's Details (Name & MobileNumber) :  ");
				CustomersDTO customer=new CustomersDTO(s.next(),s.nextLong());
				//	CustomersPrductsDTO cutomerList=new CustomersPrductsDTO()
				ObjectOutputStream oob=new ObjectOutputStream(fout);
				oob.writeObject(customer);
				//	oob.writeObject(customerList);
				oob.close();
				System.out.println("Thankyou Customer");
				}catch(Exception e) {
					e.printStackTrace();
				}
		}
		static void deserialazationcode() {
			try(FileInputStream fin=new FileInputStream("F:\\store.txt")){
				//	List<CustomerProductsDTO> cutomerList=
				ObjectInputStream oob=new ObjectInputStream(fin);
				CustomersDTO customer=(CustomersDTO)oob.readObject();
				System.out.println("customer's Name"+customer.getCustomersName()+"\nContact Number "+customer.getCustomersContactNum());
				//oob.writeObject(customerList);
				oob.close();
				System.out.println("Thankyou Customer");
				}catch(Exception e) {
					e.printStackTrace();
				}
		}

}


	


