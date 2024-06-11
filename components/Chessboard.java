package components;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Chessboard extends JPanel {
    private Game game;
    
    // chessboard is 8 by 8
    public static final int boardWidth = 8;
    public static final int boardHeight = 8;
    
    // each square is 80px by 80px
    public static final int squareWidth = 80;
    public static int squareHeight = 80;
    
    // all possible board sprites with different color themes
    Image boardBLUE = new ImageIcon("assets/BLUE.png").getImage();
    Image boardGRAY = new ImageIcon("assets/GRAY.png").getImage();
    Image boardRED = new ImageIcon("assets/RED.png").getImage();

    public Chessboard() {}

    public void setGame(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return this.game;
    }

    // draw the board
    public void render(Graphics2D graphics) {
        graphics.drawImage(boardGRAY, 0, 0, this);

        if(game != null) {
            game.renderPieces(graphics);
        }
    }
}

/*
[Event "Live Chess"]
[Site "Chess.com"]
[Date "2024.01.18"]
[Round "?"]
[White "permafrost_candycane"]
[Black "ChrisSlipps"]
[Result "1-0"]
[ECO "A21"]
[WhiteElo "1322"]
[BlackElo "739"]
[TimeControl "600"]
[EndTime "18:52:22 PST"]
[Termination "permafrost_candycane won by resignation"]

1. c4 e5 2. Nc3 Bb4 3. Nf3 c6 4. d4 Bxc3+ 5. bxc3 exd4 6. cxd4 Qa5+ 7. Bd2 Qa3
8. g3 Nf6 9. Bg2 Ng4 10. O-O d6 11. e4 O-O 12. e5 Re8 13. exd6 Nd7 14. Qb3 Qxb3
15. axb3 Re2 16. Rfe1 Rxf2 17. h3 Rxg2+ 18. Kxg2 Ngf6 19. Ne5 Nb6 20. Bg5 h6 21.
Bxf6 gxf6 22. c5 Nd5 23. d7 Bxd7 24. Nxd7 Kg7 25. Nb6 axb6 26. Rxa8 f5 27. Re5
Kf6 28. Rxd5 cxd5 29. cxb6 Ke6 30. Rh8 Kd7 31. Rxh6 f6 32. Rxf6 Kc8 33. Rxf5 Kd7
34. Rxd5+ Kc6 35. Re5 Kxb6 36. g4 1-0
*/
