import java.util.*;
public class Thegame {
	public String[][] board;
	int win;
	boolean state;
	String stone;
	char color;
	private String piyon = "PYON";
	private String kale = "KALE";
	private String at = " AT ";
	private String fil = " FIL";
	private String vezir = "VEZR";
	public String şah = " ŞAH";
	private int idx1;
	private int idx2;
	private int idx3;
	private int idx4;
	
	public String[] a;
	public String[] b;
	public String[] c;
	public String[] d;
	public String[] e;
	public String[] f;
	public String[] g;
	public String[] h;
	public String[] i;
	ArrayList<String> inside;
	ArrayList<Integer> index1;
	ArrayList<Integer> index2;
	public Thegame(char color) {
		board = new String[8][8];
		win = 0;
		this.color = color;
		beginning(color);
		
	}
	public void Informatin2() {
		inside = new ArrayList<>();
		index1 = new ArrayList<>();
		index2 = new ArrayList<>();
		for(int i = 0;i < 8;i++) {
			for(int j = 0;j < 8;j++) {
				if(board[i][j].contains("("+color+")")) {
					inside.add(board[i][j]);
					index1.add(i);
					index2.add(j);			
				}
			}
		}
	}
	public void Information() {
		inside = new ArrayList<>();
		index1 = new ArrayList<>();
		index2 = new ArrayList<>();
		for(int i = 0;i < 8;i++) {
			for(int j = 0;j < 8;j++) {
					inside.add(board[i][j]);
					index1.add(i);
					index2.add(j);			
			}
		}
	}
	public void PLAY() {
		Scanner key = new Scanner(System.in);
		System.out.println("PLAY = From where to where ? ");
		String str = key.next();
		String str2 = key.next();
		
		idx1 = 8-(str.charAt(1) - '0'); 
		if(str.charAt(0) == 'A')
			idx2 = 0;
		else if(str.charAt(0) == 'B')
			idx2 = 1;
		else if(str.charAt(0) == 'C')
			idx2 = 2;
		else if(str.charAt(0) == 'D')
			idx2 = 3;
		else if(str.charAt(0) == 'E')
			idx2 = 4;
		else if(str.charAt(0) == 'F')
			idx2 = 5;
		else if(str.charAt(0) == 'G')
			idx2 = 6;
		else if(str.charAt(0) == 'H')
			idx2 = 7;
		
		idx3 = 8-(str2.charAt(1) - '0'); 
		if(str2.charAt(0) == 'A')
			idx4 = 0;
		else if(str2.charAt(0) == 'B')
			idx4 = 1;
		else if(str2.charAt(0) == 'C')
			idx4 = 2;
		else if(str2.charAt(0) == 'D')
			idx4 = 3;
		else if(str2.charAt(0) == 'E')
			idx4 = 4;
		else if(str2.charAt(0) == 'F')
			idx4 = 5;
		else if(str2.charAt(0) == 'G')
			idx4 = 6;
		else if(str2.charAt(0) == 'H')
			idx4 = 7;
		whichStone(); 
		if(moveCheck()) {
			            
			board[idx3][idx4] = stone; 
			board[idx1][idx2] = "   0   ";
			
		}
	}
	private void whichStone() {
		String word = board[idx1][idx2];
		if(word.equals("PYON("+color+")"))
			stone = piyon+"("+color+")";
		else if(word.equals("KALE("+color+")"))
			stone = kale+"("+color+")";
		else if(word.equals(" AT ("+color+")"))
			stone = at+"("+color+")";
		else if(word.equals(" FIL("+color+")"))
			stone = fil+"("+color+")";
		else if(word.equals("VEZR("+color+")"))
			stone = vezir+"("+color+")";
		else if(word.equals(" ŞAH("+color+")"))
			stone = şah+"("+color+")";
	}
	public void changeBoard() {
		String[][] fake = new String[8][8];
		for(int i = 0;i < 8;i++) {
			for(int j = 0;j < 8;j++) {
				fake[i][j] = board[7-i][7-j];
			}
		}	
		board = fake;
	}
	private void beginning(char color) {
		for(int i = 0;i < board.length;i++)
			board[6][i] = piyon+"("+color+")";
		board[7][0] = kale+"("+color+")";
		board[7][7] = kale+"("+color+")";
		board[7][1] = at+"("+color+")";
		board[7][6] = at+"("+color+")";
		board[7][2] = fil+"("+color+")";
		board[7][5] = fil+"("+color+")";
		board[7][3] = vezir+"("+color+")";
		board[7][4] = şah+"("+color+")";
		for(int i = 0;i < 8;i++) {
			for(int j = 0;j < 8;j++) {
				if(board[i][j] == null) {
					board[i][j] = "   0   ";
				}
			}
		}
	}
	public void Show() {
		a = new String[8];
		for(int i = 0;i < 8;i++)
			a[i] = board[0][i];
		b = new String[8];
		for(int i = 0;i < 8;i++)
			b[i] = board[1][i];
		c = new String[8];
		for(int i = 0;i < 8;i++)
			c[i] = board[2][i];
		d = new String[8];
		for(int i = 0;i < 8;i++)
			d[i] = board[3][i];
		e = new String[8];
		for(int i = 0;i < 8;i++) 
			e[i] = board[4][i];
		f = new String[8];
		for(int i = 0;i < 8;i++) 
			f[i] = board[5][i];
		g = new String[8];
		for(int i = 0;i < 8;i++) 
			g[i] = board[6][i];
		h = new String[8];
		for(int i = 0;i < 8;i++)
			h[i] = board[7][i];
	}
	private boolean moveCheck() {
		state = false;
		while(!state) {
		if(stone.contains(piyon+"("+color+")")) {
			state = checkPyon();
		}
		else if(stone.contains(kale+"("+color+")")) {
			state = checkKale();
		}
		else if(stone.contains(at+"("+color+")"))  {
			state = checkAt();
		}
		else if(stone.contains(fil+"("+color+")")) {
			state = checkFil();
		}
		else if(stone.contains(vezir+"("+color+")")) {
			state = checkVezr();	
		}
		else if(stone.contains(şah+"("+color+")")) {
			state = checkŞah();
		}
		if(!state) {
			System.out.println("YOU CANNOT DO THIS");
			System.out.println(" TRY AGAIN ");
		}
		}
		return state;
	
	}
	private boolean checkPyon() {
		state = false;
		if(idx1 - idx3 == 1 ) {
			if(idx2 == idx4) {
				state = true;
			}
			if(idx2 - 1 == idx4 | idx2 + 1 == idx4) {
				if(board[idx3][idx4] != "   0   " & !board[idx3][idx4].contains("("+color+")")) {
					state = true;
				}
			}
		}
		else if(idx1 - idx3 == 2) {
			if(idx2 == idx4 & board[idx1-1][idx2] == "   0   ") {
				state = true;
			}
		}
		return state;
	}
	private boolean checkKale() {
		state = false;
		int m = 0;
		int n = 0;
		if(idx4 > idx2) {
			m = idx4;
			n = idx2;
		}
		else if(idx2 > idx4) {
			m = idx2;
			n = idx4;
		}
		if(idx1 == idx3) {	
			for(int i = n+1;i < m;i++) {
				if(board[idx1][i] == "   0   ") {
					if(!board[idx1][idx4].contains("("+color+")")) {
						state = true;
					}
					else {
						state = false;
					}
				}
				else {
					state = false;
				}
			}
		}
		if(idx1 > idx3) {
			m = idx1;
			n = idx3;
		}
		else if(idx3 > idx1) {
			m = idx1;n = idx3;
		}
		if(idx2 == idx4) {
			for(int i = n+1;i < m;i++) {
				if(board[i][idx2] == "   0   ") {
					if(!board[idx3][idx4].contains("("+color+")")) {
						state = true;
					}
					else {
						state = false;
					}
				}
				else {
					state = false;
				}
			}
		}
		return state;
	}
	private boolean checkAt() {
		state = false;
		if(!board[idx3][idx4].contains("("+color+")")) {
		if(idx1-2 == idx3) {
			if(idx4 == idx2-1) {
				state = true;
			}
			else if(idx4 == idx2+1) {
				state = true;
			}
		}
		else if(idx1-1 == idx3) {
			if(idx4 == idx2-2) {
				state = true;
			}
			else if(idx4 == idx2+2) {
				state = true;
			}
		}
		else if(idx1+1 == idx3) {
			if(idx4 == idx2-2) {
				state = true;
			}
			else if(idx4 == idx2+2) {
				state = true;
			}
		}
		else if(idx1+2 == idx3) {
			if(idx4 == idx2-1) {
				state = true;
			}
			else if(idx4 == idx2+1) {
				state = true;
			}
		}
		}
		return state;
	}
	private boolean checkFil() {
		state = false;
		int record = Math.abs(idx3-idx1);
		if(!board[idx3][idx4].contains(""+color) & Math.abs(idx4-idx2) == record) {
			state = true;
		}
		return state;
	}
	private boolean checkVezr() {
		
		if(checkFil() | checkKale()) {
				state = true;
		}
		return state;
	}
	private boolean checkŞah() {
		state = false;
		if(idx1 == idx3) {
			if(idx2-1 == idx4 || idx4-1 == idx2) {
				state = true;
			}
		}
		else if(idx2 == idx4) {
			if(idx1-1 == idx3 || idx3-1 == idx1) {
				state = true;
			}
		}
		else if(Math.abs(idx1-idx3)==1 & Math.abs(idx2-idx4) == 1) {
			state = true;
		}
		return state;
	}
}

