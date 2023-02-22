package 과제.과제11;

public class ProductDto {

	private int pno;
	private String pname;
	private int pprice;
	private int pinven;
	
	public ProductDto() {}
	
	public ProductDto(int pno, String pname, int pprice, int pinven) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.pprice = pprice;
		this.pinven = pinven;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}

	public int getPinven() {
		return pinven;
	}

	public void setPinven(int pinven) {
		this.pinven = pinven;
	}
	
	
	
	
	
}
