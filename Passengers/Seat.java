
public class Seat {
	private boolean[][] seats;
	private int capacity;
	public Seat() {
		capacity = 48;
		seats = new boolean[9][16];
		for(int i = 0;i < 9;i++) {
			for(int j = 0;j <= 15;j++) {
				seats[i][j] = true;
			}
		}
	}
	public boolean[][] getInSeats() {
		return seats;
	}
	public void setInSeats(boolean[][] fake) {
		for(int i = 0;i < fake.length;i++) {
			for(int j = 0;j < fake[0].length;j++) {
				seats[i][j] = fake[i][j];
			}
		}
	}
	// TRUE = BOŞ
	// FALSE = DOLU
	public int ticketPrice(int ticketType) {
		int count = 0;
		if(ticketType == 1) {
			for(int i = 0;i < 3;i++) {
				for(int j = 0;j <= 15;j+=5) {
					if(seats[i][j] == false) {
						count++;
					}
				}
			}
			if(count < 3) {
				return 250;
			}
			else if(count < 6) {
				return 275;
			}
			else {
				return 300;
			}
		}
		else if(ticketType == 2) {
			for(int i = 3;i <= 8;i++) {
				for(int j = 0;j <= 15;j+=3) {
					if(seats[i][j] == false) {
						count++;
					}
				}
			}
			if(count < 9) {
				return 150;
			}
			else if(count < 18) {
				return 165;
			}
			else {
				return 180;
			}
		}
		else if(ticketType == 3) {
			for(int i = 3;i <= 8;i++) {
				for(int j = 0;j <= 15;j+=3) {
					if(seats[i][j] == false) {
						count++;
					}
				}
			}
			if(count < 9) {
				return 100;
			}
			else if(count < 18) {
				return 110;
			}
			else {
				return 120;
			}
		}
		else {
			return 0;
		}
		
	}
	private boolean isSeatExist(String str,int ticketType) {
		if(ticketType == 1) {
			if(calculate1(str,ticketType) >= 0 && calculate1(str,ticketType) < 3) {
				if(calculate2(str,ticketType) >= 0 && calculate2(str,ticketType) <= 15) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
		else if(ticketType == 2 || ticketType == 3) {
			if(calculate1(str,ticketType) >= 3 && calculate1(str,ticketType) <= 8) {
				if(calculate2(str,ticketType) >= 0 && calculate2(str,ticketType) <= 15) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	private boolean isSeatEmpty(String str,int ticketType) {
		if(isSeatExist(str,ticketType)) {
			if(seats[calculate1(str,ticketType)][calculate2(str,ticketType)] == true) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	public boolean fillSeat(String str,int ticketType) {
		if(isSeatEmpty(str,ticketType)) {
			seats[calculate1(str,ticketType)][calculate2(str,ticketType)] = false;
			return true;
		}
		else {
			return false;
		}
	}
	public boolean cancelSeat(String str,int ticketType) {
		if(isSeatEmpty(str,ticketType) == false) {
			seats[calculate1(str,ticketType)][calculate2(str,ticketType)] = true;
			return true;
		}
		else {
			return false;
		}
	}
	public void printSeats() {
			System.out.print("  A    B    C    D");
			for(int i = 0;i < 3;i++) {
				for(int j = 0;j <= 15;j += 5) {
					if(j == 0) {
						System.out.println();
						System.out.print((i+1)+" ");
					}
					if(seats[i][j] == true) {
						System.out.print("O    ");
					}
					else if(seats[i][j] == false) {
						System.out.print("X    ");
					}
				}
			}
			System.out.println();
			System.out.print("  A  B  C  D  E  F");
			for(int i = 3;i <= 8;i++) {
				for(int j = 0;j <= 15;j += 3) {
					if(j == 0) {
						System.out.println();
						System.out.print((i+1)+" ");
					}
					if(seats[i][j] == true) {
						System.out.print("O  ");
					}
					else if(seats[i][j] == false) {
						System.out.print("X  ");
					}
				}
			}
		
	}
	public void economyFills() {
		boolean state = false;
		for(int i = 3;i <= 8;i++) {
			for(int j = 0;j <= 15;j += 3) {
				if(seats[i][j] == true) {
					seats[i][j] = false;
					state = true;
					break;
				}
			}
			if(state) {
				break;
			}
		}
	}
	public void fillsRandomly() {
		int count = (int)(Math.random()*36);
		for(int i = 0;i < count;i++) {
			int idx1 = (int)(Math.random()*15);
			int idx2 = (int)(Math.random()*8);
		
		}
	}
	private int calculate1(String str,int ticketType) {
		int number = str.charAt(1)-'0';
		return number-1;
	}
	private int calculate2(String str,int ticketType) {
		int letter = str.charAt(0)-'A';
		if(ticketType == 1) {
			return letter*5;
		}
		else {
			return letter*3;
		}
	}
}

