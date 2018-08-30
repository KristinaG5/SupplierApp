package part02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Scanner;

public class Main {
	
	//Public scanner 
	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		//Here i set the arraylist up so that it is called each time the program is run
		ArrayList<Supplier> supplierList = new ArrayList<Supplier>();
		//Here i set the arraylist up so that it is called each time the program is run for the hardcoded suppliers
		ArrayList<Product> productList = new ArrayList<Product>();
		
		//                                     ***Hardcoded Suppliers***
		//Hardcoding an address for 3 suppliers
		Address address1 = new Address(1, "Infinite Loop", "Cupertino", "95014", "CA");
		Address address2 = new Address(100, "Hillswood Dr", "Lyne", "KT160PS", "Chertsey");
		Address address3 = new Address(12, "Malone Road", "Belfast", "BT924TJ", "NI");
		//Hardcoding 3 new suppliers
		Supplier sup1 = new Supplier(1, "Apple Manufacturer", address1, SupRegion.OUTSIDE_EU, productList);
		Supplier sup2 = new Supplier(2, "Amazon", address2, SupRegion.UNITED_KINGDOM, productList);
		Supplier sup3 = new Supplier(3, "Ebay", address3, SupRegion.UNITED_KINGDOM, productList);
		//Adds the 3 new suppliers into the array
		supplierList.add(sup1);
		supplierList.add(sup2);
		supplierList.add(sup3);
		//Hardcoding products for specific suppliers
		supplierList.get(0).getSupProducts().add(new Product(100, "Apple", "Iphone 6S", 499.99, 100, false));
		supplierList.get(1).getSupProducts().add(new Product(101, "Sony Ericsson", "Xperia x10 mini", 15.50, 2, true));
		supplierList.get(2).getSupProducts().add(new Product(102, "HP", "HP Pavillion", 599.99, 900, false));
		supplierList.get(2).getSupProducts().add(new Product(102, "Samsung", "Galaxy S5", 199.99, 100, false));
		//This calls the menuChoice method to display when the console is booted up
		menuChoice(supplierList);
	}
			
	public static void menuChoice(ArrayList<Supplier> supplierList) {
		
		//The boolean is set to true
		boolean loop = true;
		//This is a while loop, which will break when a false value is selected
		//I chose to do a while loop so that it will keep looping through the menu and not just display it once
		while (loop) {
			//Calls the printMenu() method
			printMain();
			//Reads in an integer input using a validation method to validate the input
			int numChosen = choiceInput();
			//A switch to validate user input
			switch (numChosen) {
			case 1:
				//Calls method to print all the products within the supplierList array
				printAllProducts(supplierList);
				break;
			case 2:
				//Adds a new supplier to the supplierList array
				supplierList.add(addNewSupplier());
				break;
			case 3:
				//Adds a new product to the supplierList array
				supplierList = addNewProduct(supplierList);
				break;
			case 4: 
				//Calls the modifSupplier() method
				modifySupplier(supplierList); 
				break;
			case 5: 
				//Calls the searchForSuppliers() method
				searchForSuppliers(supplierList);
				break;
			case 6:
				//Calls the checkStock() method
				checkQuantity(supplierList);
				break;
			case 7:
				//Calls the onlineShoppingCart() method
				onlineShoppingCart(supplierList);
				break;
			case 8:
				//Displays an error message
				System.err.println("Application terminated.");
				//Terminates the application
				System.exit(0);
				break;
			default:
				//Number input validation within the menu
				System.err.println("Error - Please choose one of the options.");
			}
		}
		//Closes the scanner
		input.close();
	}
	
	public static int printMain() {
		//Displays the options for menu
		System.out.println("----Menu Option----");
		System.out.println("Choose an option: ");
		System.out.println("Press 1 to Print All Products");
		System.out.println("Press 2 to Add New Supplier");
		System.out.println("Press 3 to Add New Product");
		System.out.println("Press 4 to Modify Supplier");
		System.out.println("Press 5 to Search for a Supplier");	
		System.out.println("Press 6 to Check Quantity Availability");
		System.out.println("Press 7 to go to the Online Shopping Cart");
		System.out.println("Press 8 to Exit Application");
		
		//Menu validation- only numbers between 1 - 7 can be selected
				int userChoice = 4;
				if(userChoice >=1 && userChoice <=7)
				{
					return userChoice;
				}
		return 0; 
	}
	
	public static ArrayList<Supplier> modifySupplier(ArrayList<Supplier> supplierList) {	
		//Method to modify the supplier
		System.out.println("Choose a supplier to modify: ");
		//Calls printAllSuppliers() method for the user to pick a supplier
		printAllSuppliers(supplierList);
		//Reads in an integer input using a validation method to validate the input
		int chosenSupplierInt = choiceInputInt();
			if (chosenSupplierInt > supplierList.size()-1) {
			System.err.println("This supplier does not exist. Please choose another one.");
		} else {
		//Pulls out an individual supplier
		Supplier supplierMod = supplierList.get(chosenSupplierInt);
		
		//Prints out the chosen supplier name between the strings
		System.out.println("----Modify " + supplierMod.getSupName() + " Supplier----");
		System.out.println("1. Change Name");		
		System.out.println("2. Change Code");
		System.out.println("3. Change Address");
		System.out.println("4. Change Region");
		System.out.println("5. Change Product");
		//Reads in an integer input using a validation method to validate the input
		int modifyChoice = choiceInputInt();
		
		switch(modifyChoice) {
		//A switch to validate user input
		case 1: {
			//Updates new name
			System.out.println("Enter new name: ");
			String newSupName = choiceString();				
		    supplierMod.setSupName(newSupName);
		    break;
		}
		case 2:{
			//Updates new code
			System.out.println("Enter new code: ");
			int newSupCode = choiceInputInt();
			supplierMod.setSupCode(newSupCode);
			break;
		}
		case 3:{
			//Updates new address 
			System.out.println("Enter new address: ");
			//Calls the addNewAddress() method
			Address newSupAddress = addNewAddress();
			//Sets new address
			supplierMod.setSupAddress(newSupAddress);
			break;
		}
		case 4:{
			//Updates new region
			System.out.println("Enter new region: ");
			//Prints out the enum choices
			int numOfEnum = EnumSet.allOf(SupRegion.class).size();
			int index = 1;
			printEnum(index, numOfEnum);
			//Reads in the choice and validates it
			int regionChoice = choiceInputInt();
			SupRegion region = SupRegion.values()[regionChoice -1];
			//Sets new region chosen
			supplierMod.setSupRegion(region);
			break;
		}
		case 5:{
			//Validation method to check if there are any products 
			if (supplierList.get(chosenSupplierInt).getSupProducts().isEmpty()) {
				System.err.println("There are no products to modify");
			} else {
				System.out.println("Do you want to delete or modify a product?\nPress 1 to delete\nPress 2 to modify");
				//Reads in the choice and validates it
				int choice = choiceInputInt();
				System.out.println("Choose a product to delete or modify: ");
				//Prints the whole product list
				supplierMod.printProductList();
				//Reads in the choice and validates it
				int chosenProductInt = choiceInputInt();
				switch (choice) {
				case 1:
					//Removes a product from a chosen supplier
					supplierList.get(chosenSupplierInt).getSupProducts().remove(chosenProductInt);
					System.out.println("[Product successfully deleted]");
					break;
				case 2:
					//       ***First attempt at modifying the products***
					//Product productMod = supplierMod.getSupProducts().get(chosenProductInt);
					//Product newSupProducts = modifyProduct(productMod);
					//supplierList.get(chosenSupplierInt).getSupProducts().get(chosenProductInt);
					//supplierMod.setSupProducts(newSupProducts);
				    //supplierList.get(chosenSupplierInt).setSupProducts(newSupProducts);
					
					//    ***But every time i updated one modification it kept multiplying***
					
					//Updates the modified product
					modifyProduct(supplierList.get(chosenSupplierInt).getSupProducts().get(chosenProductInt));
					break;
				}
			}
		}
		default:
			System.err.println("Please pick a valid choice.");
		}
		}
		//Returns to the array
		return supplierList;
	}

	public static Product modifyProduct(Product product) {
		// Prints out the chosen supplier model between the strings
		System.out.println("----Modify " + product.getProModel() + " Product----");
		System.out.println("1. Change Code");
		System.out.println("2. Change Make");
		System.out.println("3. Change Model");
		System.out.println("4. Change Price");
		System.out.println("5. Change Quantity");
		System.out.println("6. Change Status");
		// Reads in an integer input using a validation method to validate the input
		int modifyChoice = choiceInputInt();
		switch (modifyChoice) {
		case 1: {
			// Updates new code
			System.out.println("Enter new code: ");
			int newCode = choiceInputInt();
			product.setProCode(newCode);
			break;

		}
		case 2: {
			// Updates new make
			System.out.println("Enter new make: ");
			String newMake = choiceString();
			product.setProMake(newMake);
			break;
		}
		case 3: {
			// Updates new model
			System.out.println("Enter new model: ");
			String newModel = choiceString();
			product.setProModel(newModel);
			break;
		}
		case 4: {
			// Updates new price
			System.out.println("Enter new price: ");
			double newPrice = choiceInputDouble();
			product.setProPrice(newPrice);
			break;
		}
		case 5: {
			// Updates new quantity
			System.out.println("Enter new quantity: ");
			int newQuantity = choiceInputInt();
			product.setProQtyAvailable(newQuantity);
			break;
		}
		case 6: {
			// Updates new discontinued value
			System.out.println("Enter new status: ");
			boolean newStatus = choiceBoolean();
			product.setProDiscontinued(newStatus);
			break;
		}
		default:
			System.err.println("Please pick a valid choice.");
		}
		//Returns to the product class
		return product;

	}
	
	public static void checkQuantity(ArrayList<Supplier> supplierList) {
		//Method to check stock availability 
		System.out.println("----Check Stock Availability----");
		System.out.println("Enter product quantity");
		// Reads in an integer input using a validation method to validate the input
		int searchChoice = choiceInputInt();
		//For loop to get the size of the products in the array
		for(int i = 0; i < supplierList.size(); i++) {
			//Sets it as an integer
			int supProNum = supplierList.get(i).getSupProducts().size();
			//Nested for loop to get the quantity at a certain position in the array
			for(int k = 0; k < supProNum; k++) {
				//Sets it as a double
				double proQty = supplierList.get(i).getSupProducts().get(k).getProQtyAvailable();
				//If statement to search for the value inputed with an existing value within the array
				if(searchChoice == proQty) {
					//Prints the matched products
					System.out.println(supplierList.get(i).printSupProductDetails(k));
				}
			}
		}
	}
	
	public static void onlineShoppingCart(ArrayList<Supplier> supplierList) {
		//Method for buying a product
		System.out.println("----Online Shopping Cart----");
		System.out.println("Choose a supplier: ");
		//Prints all available suppliers to pick from
		printAllSuppliers(supplierList);
		//Reads in an integer input using a validation method to validate the input
		int chosenSupplierInt = choiceInputInt();
		Supplier supplierCart = supplierList.get(chosenSupplierInt);
		System.out.println("Please pick a product to add to the shopping cart");
		//Prints all the products available within the chosen supplier
		supplierCart.printProductList();
		//Reads in an integer input using a validation method to validate the input
		int chosenProductInt = choiceInputInt();
		//Displays the quantity available within that product
		if (supplierList.get(chosenSupplierInt).getSupProducts().isEmpty()) {
			System.err.println("There are no products to buy");
		} else {
		System.out.println("Quantity Available: "
				+ supplierList.get(chosenSupplierInt).getSupProducts().get(chosenProductInt).getProQtyAvailable());
		System.out.println("You have "
				+ supplierList.get(chosenSupplierInt).getSupProducts().get(chosenProductInt).getProQtyAvailable()
				+ " products left." + " Do you wish to buy any?");
		System.out.println("Press 1 for yes\nPress 2 for no");
		//Reads in an integer input using a validation method to validate the input
		int buyChoice = choiceInputInt();
		//Switch case for the user to choose an option 
		switch (buyChoice) {
		case 1: {
			boolean loop = false;
			//While loop to loop through until the selected option is chosen
			while (!loop) {
				System.out.println("How many do you wish to buy?");
				//Reads in an integer using a validation method to validate the input
				int choiceProduct = choiceInputInt();
				//If statement to check if the amount is available in the quantity
				if (supplierList.get(chosenSupplierInt).getSupProducts().get(chosenProductInt)
						.getProQtyAvailable() < choiceProduct) {
					//If not then an error message is produced
					System.err.println("There is not enough of "
							+ supplierList.get(chosenSupplierInt).getSupProducts().get(chosenProductInt).getProMake()
							+ " to buy this many products!");
				} else {
					//Takes away the quantity from the product
					supplierList.get(chosenSupplierInt).getSupProducts().get(chosenProductInt)
							.setProQtyAvailable(supplierList.get(chosenSupplierInt).getSupProducts()
									.get(chosenProductInt).getProQtyAvailable() - choiceProduct);
					//Prints out a quota of the total cost
					System.out.println("The total cost of this is: "
							+ supplierList.get(chosenSupplierInt).getSupProducts().get(chosenProductInt).getProPrice()
									* choiceProduct);
					//Prints the updated version of the product
					supplierList.get(chosenSupplierInt).printProductList();
					loop = false;
				}

				break;
			}
		}		
		//Then nothing happens
		case 2: {
			break;
		}
		}
		}
	}

	public static void searchForSuppliers(ArrayList<Supplier> supplierList) {
		//Method to search for suppliers
		System.out.println("----Search Supplier----");
		System.out.println("1. Search Supplier Code");
		System.out.println("2. Search Supplier Name");
		
		// Reads in an integer input using a validation method to validate the input
		int searchChoice = choiceInputInt();
		switch (searchChoice) {
		case 1: {
			//Searches using supplier code
			System.out.println("Enter a supplier code: ");
			// Reads in an integer input using a validation method to validate the input
			int supplierCode = choiceInputInt();
			//Matches the input with an existing supplier code and if found then it'll display it
			for (int i = 0; i < supplierList.size(); i++) {
				if (supplierCode == supplierList.get(i).getSupCode()) {
					System.out.println(supplierList.get(i).printSupplierDetails());
				}
			}
			break;
		}
		case 2: {
			//Searches using supplier name
			System.out.println("Enter a supplier name: ");
			// Reads in a string input using a validation method to validate the input
			String supplierName = choiceString();
			//Matches the input with an existing supplier name and if found then it'll display it
			for (int i = 0; i < supplierList.size(); i++) {
				if (supplierName.equals(supplierList.get(i).getSupName())) {
					System.out.println(supplierList.get(i).printSupplierDetails());
				}
			}
			break;
		}
		//Validation for cases
		default: System.out.println("Enter a number between 1 and 2");
		}
	}

	public static void printAllSuppliers(ArrayList<Supplier> supplierList) {
		//Method for printing all suppliers
		System.out.println("----List of Suppliers----");
		
		int printSuppliers = supplierList.size();
		int index = 0;
		//A while loop to get all the suppliers from the array
		while(index < printSuppliers) {
			System.out.println(index + ": " + supplierList.get(index).getSupName());
			index++;
		}
	}
	
	public static void printAllProducts(ArrayList<Supplier> supplierList) {
		//Method for printing all products
		System.out.println("----Print All Products----\n");

		int printSuppliers = supplierList.size();
		int index = 0;
		//A while loop to get all the products from the array
		while(index < printSuppliers) {
			System.out.println(index + ": " + supplierList.get(index).getSupName());
			//Prints the product list
			supplierList.get(index).printProductList();
			//Creates a space
			System.out.println();
			index++;
		}	
	}
	
	public static Supplier addNewSupplier() {
		//Method to add a new supplier
		System.out.println("----Add Supplier----");
		System.out.println("Name: ");
		// Reads in a string input using a validation method to validate the input
		String name = choiceString();
		System.out.println("Code: ");
		// Reads in an integer input using a validation method to validate the input
	    int code = choiceInputInt();
		//Calls the addNewAddress() method
	    Address newAddress = addNewAddress();
		System.out.println("Region: ");
		//Prints the enum list
		int numOfEnum = EnumSet.allOf(SupRegion.class).size();
		int index = 1;
		printEnum(index, numOfEnum);
		// Reads in an integer input using a validation method to validate the input
		int regionChoice = choiceInputInt();
		SupRegion region = SupRegion.values()[regionChoice]; 
		ArrayList<Product> productList = new ArrayList<Product>();
		//New supplier constructor using the variables depending on user input
		Supplier tempSupplier = new Supplier(code, name, newAddress, region, productList);
		//Returns the new supplier
		return tempSupplier;	
	}
	
	public static Address addNewAddress() {
		//Method to add a new address
		System.out.println("----Add Address----");
		System.out.println("Number: "); 
		// Reads in an integer input using a validation method to validate the input
		int num = choiceInputInt();
		System.out.println("Street: ");
		// Reads in a string input using a validation method to validate the input
		String street = choiceString();
		System.out.println("Town: ");
		// Reads in a string input using a validation method to validate the input
		String town = choiceString();
		System.out.println("Post Code (e.g. BT123AB): ");
		//Calls the postCodeValidation() method
		String pcode = postCodeValidation();
		System.out.println("Country: ");
		// Reads in a string input using a validation method to validate the input
		String country = choiceString();
		//New address constructor using the variables depending on user input
		Address tempAddress = new Address(num, street, town, pcode, country); 
		//Returns the new address
		return tempAddress;
	}
	
	public static String postCodeValidation() {
		//Method for validating the post code
		//While this is not true then throw an error message
		//This is a postcode structure which basically means the first two inputs can either be lower or upper case letters
		//and then followed by 3 numbers after and then 2 more inputs which can either be lower or upper case letters
		//The while loop checks if the user has inputed in that exact order and if not then it will throw an error message
        while (!input.hasNext("[A-Za-z]{1,2}[0-9][0-9][0-9][A-Za-z]{2}" )) {
            System.err.println("Invalid postcode, please try again");
        input.next();
    }
        //Stores the new postcode
    String Postcode = choiceString();
    //Returns the postcode
    return Postcode;
    }
	
	public static void printEnum(int index, int numOfEnum) {
		//Method for printing the enum list
		if(index <= numOfEnum) {
			System.out.println(index + ": " + SupRegion.values()[index -1].getEnumAsString());
			index++;
			printEnum(index, numOfEnum);
		}	
	}
	
	public static ArrayList<Supplier> addNewProduct(ArrayList<Supplier> supplierList) { 
		//Method for adding a new product
		System.out.println("----Add Product----");
		System.out.println("Choose a supplier: ");
		//Calls the method printAllSuppliers() for the user to choose a supplier from
		printAllSuppliers(supplierList);
		// Reads in an integer input using a validation method to validate the input
		int chosenSupplier = choiceInputInt();
		System.out.println("Code: ");
		// Reads in an integer input using a validation method to validate the input
		int code = choiceInputInt();
		System.out.println("Make: ");
		// Reads in a string input using a validation method to validate the input
		String make = choiceString();
		input.nextLine();
		System.out.println("Model: ");
		// Reads in a string input using a validation method to validate the input
		String model = choiceString();
		input.nextLine();
		System.out.println("Price: ");
		// Reads in a double input using a validation method to validate the input
		double price = choiceInputDouble();
		System.out.println("Quantity Available: ");
		// Reads in an integer input using a validation method to validate the input
		int qtyAvailable = choiceInputInt();
		System.out.println("Discontinued? ");
		// Reads in a boolean input using a validation method to validate the input
		boolean discontinued = choiceBoolean();
		//New product constructor using the variables depending on user input
		Product tempProduct = new Product(code, make, model, price, qtyAvailable, discontinued);
		//Stores the new product with the supplier chosen
		supplierList.get(chosenSupplier).setSupProducts(tempProduct);
		//Returns data to the array
		return supplierList;
		
	}
	
	public static int choiceInputInt() {
		//Method for validating integers
		while (!input.hasNextInt()) {
		    System.err.println("Invalid character, please try again");
		    input.next();
		}
	    int number = input.nextInt();
	    input.nextLine();
		return number;
	}
	
	public static double choiceInputDouble() {
		//Method for validating integers
		while (!input.hasNextDouble()) {
		    System.err.println("Invalid character, please try again");
		    input.next();
		}
	    double number = input.nextDouble();
	    input.nextLine();
		return number;
	}
	
	public static boolean choiceBoolean() {
		//Method for validating a boolean value
		boolean booleanReturn = false;
		boolean loop = true;
		
		while(loop) {
			String inputValue = input.nextLine();
			//If the user types in "true" then it would set the boolean value to true
			if(inputValue.equals("true")) {
				booleanReturn = true;
				loop = false;
			}else if(inputValue.equals("false")){
				//If the user types in "false" then it would set the boolean value to false
				booleanReturn = false;
				loop = false;
			}else {
				System.err.println("Please enter either true or false");
			}
		}
		return booleanReturn;
		
	}
	
	public static String choiceString() {
		//Method for validating string
		boolean loop = true;
		String inputString = "";
		//Checks if there is no character or a blank space and if there is then it produces an error
		while(loop) {
			inputString = input.nextLine();
			if(inputString.equals("") || inputString.equals(" ")) {
				System.err.println("Invalid character, please try again");
			}else {
				loop = false;
			}	
			
		}
		return inputString;
	}
	
	public static int choiceInput() {
		//Method to validate the menu for letters
		//Sets the boolean to false
		boolean valid = false;
		int userChoice = 0;
		//While loop which loops through until it breaks
		while(!valid) {
			//Inside the try block, there is a possibility of there being an exception 
			try {
				//Checks if the user input is an integer
				userChoice = input.nextInt();
				//Breaks the loop if there was no error
				valid = true;
			}
			catch(Exception e) {
				//If there was an exception inside the try block then the exception is thrown
				//An error message is displayed
				System.err.println("Please enter an integer only.");
				input.next();
			}
		}
		//Returns the choice
		return userChoice;
	}
	
	
}
