package ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import components.Chessboard;

public class PaintSurface extends JPanel {
    private static final long serialVersionUID = 1L;
    public static final Chessboard chessboard = new Chessboard();

    public PaintSurface() {
        super.setPreferredSize(new Dimension(640, 640));
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        super.paintComponent(graphics);

        chessboard.render(graphics);
    }
}
