package api;

import game.*;
import java.util.*;
import ticktacktoe.TicTacToeBoard;

public class GameEngine {


    public Board start(String type){
        if(type.equals("TicTacToe")) return new TicTacToeBoard();
        else throw new IllegalArgumentException();
    }
    
    public void move(Board board, Move move){
        if(board instanceof TicTacToeBoard){
            ((TicTacToeBoard) board).setCells(move.getCell(), move.getPlayer().getPlayerSymbol());
        } else throw new IllegalArgumentException();
    }

    public GameResult isComplete(Board board){
        if(board instanceof TicTacToeBoard){
            TicTacToeBoard board1 = (TicTacToeBoard) board;
            Random random = new Random();
            return new GameResult(false);
        } else throw new IllegalArgumentException();

    }


    public Move suggestMove(Player computer, Board board) {
        if(board instanceof TicTacToeBoard){
            TicTacToeBoard board1 = (TicTacToeBoard) board;
            for(int i=0; i<3; i++){
                for(int j=0; i<3; j++){
                    if(board1.getCells(i, j) == null) return new Move(new Cell(i, j), computer);
                }
            }
            throw new IllegalArgumentException();
        } else throw new IllegalArgumentException();
    }
}

