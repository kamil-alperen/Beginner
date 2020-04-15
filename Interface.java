import java.util.*;
public class Interface {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		boolean state = true;
		int objectCount = 0;
		boolean[][] fake = new boolean[9][16];
		for(int i = 0;i < fake.length;i++) {
			for(int j = 0;j < fake[0].length;j++) {
				fake[i][j] = true;
			}
		}
		Customer[] passengers = new Customer[48];
		passengers[objectCount] = new Customer();
		while(state) {
			System.out.println("Do you want to reserve a seat(ENTER 1) or cancel a seat(Enter 2)");
			int answer = key.nextInt();
			if(answer == 1) {
			
				System.out.println("Which class do you want ?");
				System.out.println("1-)Business(ENTER 1) \n2-)Regular(ENTER 2) \n3-)Economy(ENTER 3)");
				int ticketType = key.nextInt();
				System.out.println("Enter your name");
				String name = key.nextLine();
				name = key.nextLine();
				System.out.println("Enter your gender");
				String gender = key.next();
				System.out.println("Enter your telephone numbers without a gap");
				double telephone = key.nextDouble();
				System.out.println("Enter your nationality");
				String nationality = key.next();
				passengers[objectCount].setName(name);
				passengers[objectCount].setGender(gender);
				passengers[objectCount].setTelephone(telephone);
				passengers[objectCount].setNationality(nationality);
				String PNRcode = "F"+(int)(Math.random()*999999999);
				passengers[objectCount].setPNRcode(PNRcode);
			
				if(ticketType == 1) {
					passengers[objectCount].setSeats(fake);
					passengers[objectCount].show();
					System.out.println();
					System.out.println("The price is : "+passengers[objectCount].getPrice(ticketType));
					System.out.println("Which seat do you want");
					String str = key.next();
					passengers[objectCount].setSeat(str);
					passengers[objectCount].fillsSeat(ticketType, str);
					passengers[objectCount].show();
					fake = passengers[objectCount].getSeats();
					passengers[objectCount].personalInformation();
					System.out.println("Your PNR code is "+passengers[objectCount].getPNR());
					objectCount++;
					passengers[objectCount] = new Customer();
		
				}
				else if(ticketType == 2) {
					passengers[objectCount].setSeats(fake);
					passengers[objectCount].show();
					System.out.println();
					System.out.println("The price is : "+passengers[objectCount].getPrice(ticketType));
					System.out.println("Which seat do you want");
					String str = key.next();
					passengers[objectCount].setSeat(str);
					passengers[objectCount].fillsSeat(ticketType, str);
					passengers[objectCount].show();
					fake = passengers[objectCount].getSeats();
					passengers[objectCount].personalInformation();
					System.out.println("Your PNR code is "+passengers[objectCount].getPNR());
					objectCount++;
					passengers[objectCount] = new Customer();

				}
				else if(ticketType == 3) {
					passengers[objectCount].setSeats(fake);
					passengers[objectCount].show();
					System.out.println();
					System.out.println("The price is : "+passengers[objectCount].getPrice(ticketType));
					passengers[objectCount].fillsSeat(ticketType, " ");
					passengers[objectCount].show();
					fake = passengers[objectCount].getSeats();
					passengers[objectCount].personalInformation();
					System.out.println("Your PNR code is "+passengers[objectCount].getPNR());
					objectCount++;
					passengers[objectCount] = new Customer();

				}
				else {
					System.out.println("ERROR = You entered wrong number");
				}
				System.out.println();
				
			
				}
			else if(answer == 2) {
				System.out.println("What was your ticket type");
				System.out.println("1-)Business(ENTER 1) \n2-)Regular(ENTER 2) \n3-)Economy(ENTER 3)");
				int ticketType = key.nextInt();
				if(ticketType == 3) {
					System.out.println("Sorry,you cannot cancel your seat");
				}
				else if(ticketType == 2) {
					System.out.println("We can cancel your seat but we won't you money\n instead we give you PNR code so you can fly another time in this year ");
					System.out.println("Enter your surname");
					String surname = key.next();
					boolean status = false;
					for(int i = 0;i < objectCount;i++) {
						if(surname.equalsIgnoreCase(passengers[i].getSurname())) {
							status = true;
						}
					}
					if(status) {
						System.out.println("Enter your PNR code");
						String PNRcode = key.next();
						status = false;
						String str = "";
						int idx = 0;
						for(int i = 0;i < objectCount;i++) {
							if(PNRcode.equalsIgnoreCase(passengers[i].getPNR())) {
								str = passengers[i].getSeat();
								idx = i;
								status = true;
							}
						}
						if(status) {
							passengers[idx].cancellation(str, ticketType);
							PNRcode = "F"+(int)(Math.random()*999999999);
							System.out.println("Okay,your seat is cancelled and your new voucher(PNR) code is : "+PNRcode);
						}
					}
					else {
						System.out.println("You liar");
					}
					
				}
				else if(ticketType == 1) {
					System.out.println("Enter your surname");
					String surname = key.next();
					boolean status = false;
					for(int i = 0;i < objectCount;i++) {
						if(surname.equals(passengers[i].getSurname())) {
							status = true;
						}
					}
					if(status) {
						System.out.println("Enter your PNR code");
						String PNRcode = key.next();
						status = false;
						String str = "";
						int idx = 0;
						for(int i = 0;i < objectCount;i++) {
							if(PNRcode.equalsIgnoreCase(passengers[i].getPNR())) {
								str = passengers[i].getSeat();
								idx = i;
								status = true;
							}
						}
						if(status) {
							passengers[idx].cancellation(str, ticketType);
							System.out.println("Okay,your seat is cancelled");
						}
				}
				else {
					System.out.println("ERROR");
				}
				
			}
			else {
				System.out.println("ERROR");
			}
		}
			
			System.out.println("Do you want to reserve or cancel another seat(ENTER yes OR no) ? ");
			String str = key.next();
		
			if(str.equalsIgnoreCase("no"))
				state = false;	
	}
	}
}

