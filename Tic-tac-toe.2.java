import java.util.*;
public class Players {
	public static void main(String[] args) {
		Thegame player1 = new Thegame(3,"player1");
		Thegame player2 = new Thegame(3,"player2");
		Scanner key = new Scanner(System.in);
		while(player1.win != 3 || player2.win != 3) {
			player1.board = player2.board;
			
			String str = "X";
			System.out.println("enter the coordinates");
			int x = key.nextInt();
			int y = key.nextInt();
			while(!player1.isEmpty(x, y)) {
				System.out.println("TRY AGAIN");
				x = key.nextInt();
				y = key.nextInt();
			}
			player1.Mark(str,x,y);
			player1.Show();
			System.out.println(Arrays.toString(player1.a));
			System.out.println(Arrays.toString(player1.b));
			System.out.println(Arrays.toString(player1.c));
			player1.Check();
			
			player2.board = player1.board;
			
			String str2 = "O";
			System.out.println("enter the coordinates");
			int x2 = key.nextInt();
			int y2 = key.nextInt();
			while(!player2.isEmpty(x2, y2)) {
				System.out.println("TRY AGAIN");
				x2 = key.nextInt();
				y2 = key.nextInt();
			}
			player2.Mark(str2,x2,y2);
			player2.Show();
			System.out.println(Arrays.toString(player2.a));
			System.out.println(Arrays.toString(player2.b));
			System.out.println(Arrays.toString(player2.c));
			player2.Check();
		}
		System.out.print("GAME OVER");
	}
}

