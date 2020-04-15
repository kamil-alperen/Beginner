public class Customer {
	private String name;
	private String gender;
	private double telephone;
	private String nationality;
	private String PNRcode;
	public String str;
	public Seat arrange;
	public Customer() {
		arrange = new Seat();
	
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setTelephone(double telephone) {
		this.telephone = telephone;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public void setPNRcode(String code) {
		PNRcode = code;
	}
	public void setSeat(String str) {
		this.str = str;
	}
	public void personalInformation() {
		System.out.println();
		System.out.println("The name is : "+name);
		System.out.println("The gender is : "+gender);
		System.out.println("The telephone is : "+(int)telephone);
		System.out.println("The nationality is : "+nationality);
	}
	public String getSurname() {
		String surname = " ";
		int index = name.lastIndexOf(" ");
		surname = name.substring(index+1);
		return surname;
	}
	public String getPNR() {
		return PNRcode;
	}
	public int getPrice(int ticketType) {
		return arrange.ticketPrice(ticketType);
	}
	public String getSeat() {
		return this.str;
	}
	public void fillsRandomly() {
		arrange.fillsRandomly();
		
	}
	public void fillsSeat(int TicketType,String str) {
		if(TicketType == 3) {
			arrange.economyFills();
		}
		else if(TicketType == 1 || TicketType == 2) {
			arrange.fillSeat(str, TicketType);
		}
		else {
			System.out.println("ERROR");
		}
	}
	public void show() {
		arrange.printSeats();
	}
	public boolean[][] getSeats() {
		return arrange.getInSeats();
	}
	public void setSeats(boolean[][] fake) {
		arrange.setInSeats(fake);
	}
	public void cancellation(String str,int ticketType) {
		arrange.cancelSeat(str, ticketType);
	}

}

