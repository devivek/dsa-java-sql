import api.GameEngine;
import game.Board;
import game.Cell;
import game.Move;
import game.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        GameEngine gameEngine = new GameEngine();
        Board board = gameEngine.start("TicTacToe");
        int row, col;
        Scanner scanner = new Scanner(System.in);
        while(!gameEngine.isComplete(board).getIsOver()){
            System.out.println("Make your Move !!!");
            System.out.println(board);
            Player computer = new Player("O"), human = new Player("X");
            row = scanner.nextInt();
            col = scanner.nextInt();
            Move oppMove = new Move(new Cell(row, col), human);
            System.out.println(board);
            gameEngine.move(board, oppMove);
            if(!gameEngine.isComplete(board).getIsOver()){
                Move compMove = gameEngine.suggestMove(computer, board);
                gameEngine.move(board, compMove);
            }
        }
        System.out.println("GameResult " + gameEngine.isComplete(board));
        System.out.println(board);

    }
}
