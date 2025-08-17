package org.example;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.start();
    }

    public static class TicTacToe {
        private Player player1;
        private Player player2;
        private Player currentPlayer;
        private Board board;

        public TicTacToe() {
            player1 = new Player('X');
            player2 = new Player('O');
            currentPlayer = player1;
            board = new Board();
        }

        public void start() {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                board.print();
                System.out.println("Current Player: " + currentPlayer.getMarker());

                int x, y;
                do {
                    System.out.print("row (0-2): ");
                    x = scanner.nextInt();
                    System.out.print("column (0-2): ");
                    y = scanner.nextInt();
                } while (!board.isCellEmpty(x, y));

                board.place(x, y, currentPlayer.getMarker());

                if (hasWinner()) {
                    board.print();
                    System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                    break;
                }

                if (board.isFull()) {
                    board.print();
                    System.out.println("It's a draw!");
                    break;
                }

                switchCurrentPlayer();
            }
        }

        public void switchCurrentPlayer() {
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }

        public boolean hasWinner() {
            char[][] c = board.getCells();

            for (int i = 0; i < 3; i++) {
                if (c[i][0] != ' ' && c[i][0] == c[i][1] && c[i][1] == c[i][2]) return true;
                if (c[0][i] != ' ' && c[0][i] == c[1][i] && c[1][i] == c[2][i]) return true;
            }

            if (c[0][0] != ' ' && c[0][0] == c[1][1] && c[1][1] == c[2][2]) return true;
            if (c[0][2] != ' ' && c[0][2] == c[1][1] && c[1][1] == c[2][0]) return true;

            return false;
        }
    }
}
