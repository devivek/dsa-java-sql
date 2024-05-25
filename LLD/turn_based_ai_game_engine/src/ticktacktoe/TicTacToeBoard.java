package ticktacktoe;

import game.Board;
import game.Cell;
import game.Move;

public class TicTacToeBoard extends Board {
    private String cells[][] = new String[3][3];

    public String getCells(int row, int col) {
        return cells[row][col];
    }

    public void setCells(Cell cell, String symbol) {
        cells[cell.getRow()][cell.getCol()] = symbol;
    }

    @Override
    public String toString() {
        String res = "";
        for(int i=0; i<3; i++){
            for (int j = 0; j < 3; j++) {
                res += (cells[i][j] + " ");
            }
            res += "\n";
        }
        return res;
    }

    @Override
    public void move(Move move) {

    }
}
