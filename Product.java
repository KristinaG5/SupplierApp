package part02;

//Product Class Declaration
public class Product {
	//Object Declatations for Product Class
	private int proCode;
	private String proMake;
	private String proModel;
	private double proPrice;
	private int proQtyAvailable;
	private boolean proDiscontinued;
	
	public Product(int proCode, String proMake, String proModel, double proPrice, int proQtyAvailable, boolean proDiscontinued) {
		//Constructor for initiating the Product objects
		this.proCode = proCode;
		this.proMake = proMake;
		this.proModel = proModel;
		this.proPrice = proPrice;
		this.proQtyAvailable = proQtyAvailable;
		this.proDiscontinued = proDiscontinued;
	}
	
	public String getProductDetails() {
		//Accessor method - to return the full product details
		String returnString = "\nCode: " + this.proCode + "\nMake: " + this.proMake + "\nModel: " 
				+ this.proModel + "\nPrice: " + this.proPrice + "\nQuantity Available: " + this.proQtyAvailable + "\nDiscontinued? " + this.proDiscontinued;
		return returnString;
	}

	public int getProCode() {
		//Getter for product code
		return proCode;
	}

	public void setProCode(int proCode) {
		//Setter for product code
		this.proCode = proCode;
	}

	public String getProMake() {
		//Getter for product make
		return proMake;
	}

	public void setProMake(String proMake) {
		//Setter for product make
		this.proMake = proMake;
	}

	public String getProModel() {
		//Getter for product model
		return proModel;
	}

	public void setProModel(String proModel) {
		//Setter for product model
		this.proModel = proModel;
	}

	public double getProPrice() {
		//Getter for product price
		return proPrice;
	}

	public void setProPrice(double proPrice) {
		//Setter for product price
		this.proPrice = proPrice;
	}

	public int getProQtyAvailable() {
		//Getter for product quantity
		return proQtyAvailable;
	}

	public void setProQtyAvailable(int proQtyAvailable) {
		//Setter for product quantity
		this.proQtyAvailable = proQtyAvailable;
	}

	public boolean isProDiscontinued() {
		//Getter for product discontinued
		return proDiscontinued;
	}

	public void setProDiscontinued(boolean proDiscontinued) {
		//Setter for product discontinued
		this.proDiscontinued = proDiscontinued;
	}

}
