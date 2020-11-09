package project1.ver08;

import java.util.Random;
import java.util.Scanner;

public class Qu3by3 {

	public Qu3by3() {
		game();
	}
	
	public void game() {
		Scanner scanner = new Scanner(System.in);
		char [][] board = {{'1','2','3'},{'4','5','6'},{'7','8','X'}};
		String move, select;
		showBoard(board);
		for(int i=1; i<=100; i++) {
			suffle(board);
			if(check(board)!=false) i--;
		}
			
		System.out.println();
		showBoard(board);
		while(true) {
			System.out.println("방향키 입력[상(W), 하(S), 좌(A), 우(D)]");
			System.out.print("(X) 입력 시 종료 : ");
			move = scanner.nextLine();
			if(move.equalsIgnoreCase("x")) {
				return;
			}
			else {
				select(board, move);
				showBoard(board);
				if(check(board)==true) {
					System.out.println("정답입니다!");
					System.out.println("재시작 하시겠습니까?(y:재시작)");
					select = scanner.nextLine();
					if(select.equalsIgnoreCase("y")) {
						game();
					}
					else return;
				}
			}
		}
	}

	void showBoard(char[][] board) {
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board.length; j++) {
				if(j!=2)
				System.out.print(" "+ board[i][j] + " |");
				else System.out.print(" " + board[i][j] + " ");
			}
			System.out.println();
			if(i!=2) System.out.println("---|---|---");
		}
	}
	
	void suffle(char[][] board) {
		Random rnd = new Random();
		int x = rnd.nextInt(3);
		int y = rnd.nextInt(3);
		char temp[][] = {{0}};
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board.length; j++) {
				if(board[i][j]=='X') {
					temp[0][0] = board[i][j];
					board[i][j] = board[x][y];
					board[x][y] = temp[0][0];
					return;
				}
			}
		}
	}
	
	void rotateRow(char[][] board) {
		char[] lastRow = board[board.length-1];
		for(int row=board.length-1 ; row>0 ; row--) {
			board[row] = board[row-1];
		}
		board[0] = lastRow;
	}
	
	void rotateCol(char[][] board) {
		char[][] temp = {{0},{0},{0}};
		for(int i=0; i<board.length-1; i++) {
			for(int j=0; j<board.length; j++) {
				temp[j][0] = board[j][i];
				board[j][i] = board[j][i+1];
				board[j][i+1] = temp[j][0];
			}
		}
	}
	
	boolean check(char[][] board) {
		int checkCnt=0;
		char[][] compare = {{'1','2','3'},{'4','5','6'},{'7','8','X'}};
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board.length; j++) {
				if(board[i][j]==compare[i][j]) {
					checkCnt++;
					if(checkCnt==9) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	void select(char[][] board, String move) {
		char[][] temp = {{0, 0}};
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				if(board[i][j]=='X') {
					if(move.equalsIgnoreCase("w")) {
						if(i==board.length-1) {
							System.out.println("위로 이동할 수 없습니다.");
							return;
						}
						else {
							temp[0][0] = board[i][j];
							board[i][j] = board[i+1][j];
							board[i+1][j] = temp[0][0];
							return;
						}
					}
					if(move.equalsIgnoreCase("s")) {
						if(i==0) {
							System.out.println("아래로 이동할 수 없습니다.");
							return;
						}
						else {
							temp[0][0] = board[i][j];
							board[i][j] = board[i-1][j];
							board[i-1][j] = temp[0][0];
							return;
						}
					}
					if(move.equalsIgnoreCase("d")) {
						if(j==0) {
							System.out.println("오른쪽으로 이동할 수 없습니다.");
							return;
						}
						else {
							temp[0][0] = board[i][j];
							board[i][j] = board[i][j-1];
							board[i][j-1] = temp[0][0];
							return;
						}
					}
					if(move.equalsIgnoreCase("a")) {
						if(j==board[i].length-1) {
							System.out.println("왼쪽으로 이동할 수 없습니다.");
							return;
						}
						else {
							temp[0][0] = board[i][j];
							board[i][j] = board[i][j+1];
							board[i][j+1] = temp[0][0];
							return;
						}
					}
				}
			}
		}
	}
}
