import java.util.*;
public class Players {
	static Thegame player1 = new Thegame('B');
	static Thegame player2 = new Thegame('S');
	static void Method() {
		
		System.out.println(Arrays.toString(player1.a));
		System.out.println(Arrays.toString(player1.b));
		System.out.println(Arrays.toString(player1.c));
		System.out.println(Arrays.toString(player1.d));
		System.out.println(Arrays.toString(player1.e));
		System.out.println(Arrays.toString(player1.f));
		System.out.println(Arrays.toString(player1.g));
		System.out.println(Arrays.toString(player1.h));
	}
	static void Method2() {
		System.out.println(Arrays.toString(player2.a));
		System.out.println(Arrays.toString(player2.b));
		System.out.println(Arrays.toString(player2.c));
		System.out.println(Arrays.toString(player2.d));
		System.out.println(Arrays.toString(player2.e));
		System.out.println(Arrays.toString(player2.f));
		System.out.println(Arrays.toString(player2.g));
		System.out.println(Arrays.toString(player2.h));
	}
	static void Method3() {
		int count = 0;
		for(int i = 0;i < 8;i++) {
			int count2 = 0;
			if(player1.index1.get(count) == i) {
				for(int j = 0;j < 8;j++) {
					if(player1.index2.get(count) == j) {
						player2.board[i][j] = player1.inside.get(count);
						count2 = 1;
					}
				}
			}
			count += count2;
			if(player1.index1.size() > count) {
				if(player1.index1.get(count) == i) {
					i--;
				}
			}
			else 
				break;
		}
	}
	public static void main(String[] args) {
		Scanner keyboard  = new Scanner(System.in);
		player1.PLAY();
		player1.Show();
		Method();
		System.out.println("***");
		System.out.println();
		player1.changeBoard();
		player1.Show();
		Method();
		System.out.println("***");
		System.out.println();
		player1.Informatin2();
		Method3();
		while(Arrays.deepToString(player1.board).contains(player1.şah) == true || Arrays.deepToString(player1.board).contains(player1.şah) == true) {
			
			player2.Show();
			Method2(); 
			System.out.println("***");
			System.out.println();
			player2.PLAY();
			player2.Show();
			Method2();
			System.out.println("***");
			System.out.println();
			player2.changeBoard();
			player2.Show();
			Method2();
			System.out.println("***");
			System.out.println();
			player2.Information();
			player1.board = player2.board;
			player1.Show();
			Method();
			System.out.println("***");
			System.out.println();
			player1.PLAY();
			player1.Show();
			Method();
			System.out.println("***");
			System.out.println();
			player1.changeBoard();
			player1.Show();
			Method();
			System.out.println("***");
			System.out.println();
			player1.Information();
			player2.board = player1.board;
			
		}
		
	}
}

