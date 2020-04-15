public class Thegame {
	String name;
	String[][] board;
	String total;
	static int win = 0;
	int finishScore;
	static boolean state;
	boolean full;
	String[] a = new String[3];
	String[] b = new String[3];
	String[] c = new String[3];
	public Thegame(int score,String name) {
		board = new String[3][3];
		finishScore = score;
		this.name = name;
	}
	public void Mark(String mark,int x,int y) {
		board[x][y] = " "+mark+" ";
	}
	public boolean isEmpty(int x,int y) {
		if(board[x][y] != null) {
			full = false;
		}
		else {
			full = true;
		}
		return full;
	}
	public void Show() {
		for(int i = 0;i < board.length;i++) {
			a[i] = board[0][i];
		}
		for(int i = 0;i < board.length;i++) {
			b[i] = board[1][i];
		}
		for(int i = 0;i < board.length;i++) {
			c[i] = board[2][i];
		}
	}
	public void Check() {
		state = false;
		for(int i = 0;i < 3;i++) {
			for(int j = 0;j < 3;j++) {
				total += board[i][j];
			}
			if(total.equals(" X  X  X ") | total.equals(" O  O  O ")) {
				state = true;
				break;
			}
			total = "";
		}
		total = "";
		if(!state) {
		for(int i = 0;i < 3;i++) {
			for(int j = 0;j < 3;j++) {
				total += board[j][i];
			}
			if(total.equals(" X  X  X ") | total.equals(" O  O  O ")) {
				state = true;
				break;
			}
			total = "";
			}
		}
		total = board[0][0]+board[1][1]+board[2][2];
		if(total.equals(" X  X  X ") | total.equals(" O  O  O ")) {
			state = true;
		}
		total = board[0][2]+board[1][1]+board[2][0];
		if(total.equals(" X  X  X ") | total.equals(" O  O  O ")) {
			state = true;
		}
		increase();
		Clear();
		if(state) {
			System.out.println(" YOU WIN ! ");
		}
		CheckinAll();
	}
	private static void increase() {
		if(state) {
			win++;
		}
	}
	private void Clear() {
		if(state)
			board = new String[3][3];
	}
	private void CheckinAll() {
		if(win == finishScore) {
			System.out.println("IN THE RESULT "+name+" HAS WON !!!");
		}
	}
}

