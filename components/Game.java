package components;

import java.awt.Graphics2D;
import java.util.ArrayList;

import helpers.FEN;
import helpers.PGN;
import ui.Container;

public class Game {
    private PGN pgn;
    private FEN fen;
    
    private ArrayList<Piece> pieces = new ArrayList<Piece>();

    public Game() {
        // initial starting position
        fen = new FEN("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");

        pieces = fen.parseFEN();
        Container.surface.repaint();
    }

    public void renderPieces(Graphics2D graphics) {
        for (Piece piece : pieces) {
            piece.render(graphics);
        }
    }

    public void setPGN(PGN pgn) {
        this.pgn = pgn;
    }
}
