package part02;

import java.util.ArrayList;

//Supplier Class Declaration
public class Supplier {
	//Object Declatations for Supplier Class
	private int supCode;
	private String supName;
	private Address supAddress;
	private SupRegion supRegion;
	private ArrayList<Product> supProducts = new ArrayList<Product>();
	
	public Supplier(int supCode, String supName, Address supAddress, SupRegion supRegion, ArrayList<Product> supProducts) {
		//Constructor for initiating the Supplier objects
		this.supCode = supCode;
		this.supName = supName;
		this.supAddress = supAddress;
		this.supRegion = supRegion;
		this.supProducts = new ArrayList<Product>(supProducts);
	}
	
	public void printProductList() {
		//Method - to print the full product list
		System.out.println("----Product List----");
		int numOfProducts = this.supProducts.size();
		int index = 0;
		while(index < numOfProducts) {
			System.out.println(index + ": " + this.supProducts.get(index).getProductDetails());
			index ++;
		}
		
	}
	
	public String printSupplierDetails() {	
		//Accessor method - to return the full supplier details
		String returnString = "\nSupplier Code: " + this.supCode + "\nSupplier Name: " + this.supName + "\nSupplier Address: "
				+ this.supAddress.getFullAddress() + "\nSupplier Region: " + this.supRegion.getEnumAsString();
		return returnString;
	}
	
	public String printSupProductDetails(int numOfDetails) {
		//Accessor method - to return the full supplier product details
		String returnString = "\n----Supplier Products---- " + this.supProducts.get(numOfDetails).getProductDetails();
		return returnString;
	}

	public int getSupCode() {
		//Getter for code
		return supCode;
	}

	public void setSupCode(int supCode) {
		//Setter for code
		this.supCode = supCode;
	}

	public String getSupName() {
		//Getter for name
		return supName;
	}

	public void setSupName(String supName) {
		//Setter for name
		this.supName = supName;
	}

	public Address getSupAddress() {
		//Getter for address
		return supAddress;
	}

	public void setSupAddress(Address supAddress) {
		//Setter for address
		this.supAddress = supAddress;
	}

	public SupRegion getSupRegion() {
		//Getter for region
		return supRegion;
	}

	public void setSupRegion(SupRegion supRegion) {
		//Setter for region
		this.supRegion = supRegion;
	}

	public ArrayList<Product> getSupProducts() {
		//Getter for products
		return supProducts;
	}

	public void setSupProducts(Product supProducts) {
		//Setter for products
		this.supProducts.add(supProducts);
	}

}
