package components;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Piece extends JPanel {
    private BufferedImage pieceSprite;
    private int x;
    private int y;

    public Piece(char pieceType, int col, int row) {
        BufferedImage allPieces = null;
        try {
            allPieces = ImageIO.read(new File("assets/PIECES.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (pieceType) {
            case 'K':
                pieceSprite = allPieces.getSubimage(0, 0, 80, 80);
                break;
            case 'Q':
                pieceSprite = allPieces.getSubimage(80, 0, 80, 80);
                break;
            case 'B':
                pieceSprite = allPieces.getSubimage(160, 0, 80, 80);
                break;
            case 'N':
                pieceSprite = allPieces.getSubimage(240, 0, 80, 80);
                break;
            case 'R':
                pieceSprite = allPieces.getSubimage(320, 0, 80, 80);
                break;
            case 'P':
                pieceSprite = allPieces.getSubimage(400, 0, 80, 80);
                break;
            case 'k':
                pieceSprite = allPieces.getSubimage(0, 80, 80, 80);
                break;
            case 'q':
                pieceSprite = allPieces.getSubimage(80, 80, 80, 80);
                break;
            case 'b':
                pieceSprite = allPieces.getSubimage(160, 80, 80, 80);
                break;
            case 'n':
                pieceSprite = allPieces.getSubimage(240, 80, 80, 80);
                break;
            case 'r':
                pieceSprite = allPieces.getSubimage(320, 80, 80, 80);
                break;
            case 'p':
                pieceSprite = allPieces.getSubimage(400, 80, 80, 80);
                break;
            default:
                break;
        }
        
        this.x = col;
        this.y = row;
    }

    public void render(Graphics2D graphics) {
        graphics.drawImage(pieceSprite, x, y, this);
    }
}
