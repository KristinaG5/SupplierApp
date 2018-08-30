package part02;

//Address Class Declaration
public class Address {
	//Object Declatations for Address Class
	private int bldNum;
	private String bldStreet;
	private String bldTown;
	private String bldPcode;
	private String bldCountry;
	
	public Address(int bldNum, String bldStreet, String bldTown, String bldPcode, String bldCountry) {
		//Constructor for initiating the Address objects
		this.bldNum = bldNum;
		this.bldStreet = bldStreet;
		this.bldTown = bldTown;
		this.bldPcode = bldPcode;
		this.bldCountry = bldCountry;
	}
	
	public String getFullAddress() {
		//Accessor method - to return the full address 
		String returnString = "\n----Full Address----\nNumber: " + this.bldNum + "\nStreet: " + this.bldStreet + "\nTown: "
				+ this.bldTown + "\nPost Code: " + this.bldPcode + "\nCountry: " + this.bldCountry;
		
		return returnString;
	}

	public int getBldNum() {
		//Getter for number
		return bldNum;
	}

	public void setBldNum(int bldNum) {
		//Setter for number
		this.bldNum = bldNum;
	}

	public String getBldStreet() {
		//Getter for street
		return bldStreet;
	}

	public void setBldStreet(String bldStreet) {
		//Setter for street
		this.bldStreet = bldStreet;
	}

	public String getBldTown() {
		//Getter for town
		return bldTown;
	}

	public void setBldTown(String bldTown) {
		//Setter for town
		this.bldTown = bldTown;
	}

	public String getBldPcode() {
		//Getter for postcode
		return bldPcode;
	}

	public void setBldPcode(String bldPcode) {
		//Setter for postcode
		this.bldPcode = bldPcode;
	}

	public String getBldCountry() {
		//Getter for country
		return bldCountry;
	}

	public void setBldCountry(String bldCountry) {
		//Setter for country
		this.bldCountry = bldCountry;
	}


}
