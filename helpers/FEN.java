package helpers;

import java.util.ArrayList;

import components.Chessboard;
import components.Piece;

public class FEN {
    // default start position
    private String fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";

    public FEN(String fen) {
        this.fen = fen;
    }

    public void setFEN(String fen) {
        this.fen = fen;
    }

    public String getFEN() {
        return this.fen;
    }

    public boolean isValidFEN() {
        return true;
    }

    public ArrayList<Piece> parseFEN() {
        ArrayList<Piece> pieces = new ArrayList<Piece>();

        String boardState = fen.split(" ")[0];
        int row = 0;
        int col = 0;

        for (char c : boardState.toCharArray()) {
            if (c == '/') {
                row++;
                col = 0;
            } else if (Character.isDigit(c)) {
                col += Character.getNumericValue(c);
            } else {
                pieces.add(new Piece(c, col * Chessboard.squareWidth, row * Chessboard.squareHeight));
                col++;
            }
        }
        
        return pieces;
    }
}
