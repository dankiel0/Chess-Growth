package components;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Chessboard extends JPanel {
    // starting position
    private String fenNotation = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";

    // pgn notation
    private String pgnNotation;

    // pieces list
    private ArrayList<Piece> pieces = new ArrayList<Piece>();

    // chessboard is 8 by 8
    private final int boardWidth = 8;
    private final int boardHeight = 8;

    // each square is 80px by 80px
    private final int squareWidth = 80;
    private final int squareHeight = 80;
    
    // all possible board sprites with different color themes
    Image boardBLUE = new ImageIcon("assets/BLUE.png").getImage();
    Image boardGRAY = new ImageIcon("assets/GRAY.png").getImage();
    Image boardRED = new ImageIcon("assets/RED.png").getImage();

    public Chessboard() {
        String boardState = fenNotation.split(" ")[0];
        int row = 0;
        int col = 0;

        for (char c : boardState.toCharArray()) {
            if (c == '/') {
                row++;
                col = 0;
            } else if (Character.isDigit(c)) {
                col += Character.getNumericValue(c);
            } else {
                pieces.add(new Piece(c, col * squareWidth, row * squareHeight));
                col++;
            }
        }
    }

    public void setPGN(String pgnNotation) {
        this.pgnNotation = pgnNotation;
    }

    // draw the board
    public void render(Graphics2D graphics) {
        graphics.drawImage(boardGRAY, 0, 0, this);

        for (Piece piece : pieces) {
            piece.render(graphics);
        }
    }
}
