package self.bank;

public class Address {
	private int zipCode;
	private String region;
	private String city;
	
	public Address() {}
	public Address(int zipCode, String region, String city) {
		super();
		this.zipCode = zipCode;
		this.region = region;
		this.city = city;
	}
	
	public String toString() {
		return "Address [zipCode=" + zipCode + ", region=" + region + ", city=" + city + "]";
	}
	
}
