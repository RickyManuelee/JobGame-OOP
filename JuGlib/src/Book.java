
public class Book {
	
	private String Lname;
	private String ID;
	private String Bname;
	private Integer price;
	private String desc;
	private String country;
	
	public Book(String lname, String iD, String bname, Integer price, String desc, String country) {
		super();
		Lname = lname;
		ID = iD;
		Bname = bname;
		this.price = price;
		this.desc = desc;
		this.country = country;
	}
	
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getBname() {
		return Bname;
	}
	public void setBname(String bname) {
		Bname = bname;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
