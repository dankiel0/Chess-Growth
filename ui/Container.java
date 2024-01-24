package ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import components.Chessboard;

public class Container {
    final private static PaintSurface surface = new PaintSurface();

    public static void main(String[] args) {
        JFrame window = new JFrame();

        // add components
        window.setContentPane(surface);
        window.setJMenuBar(createMenuBar());

        // window settings
        window.pack();
        window.setTitle("Chess Growth");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);
    }

    private static JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");

        JMenuItem openPGNFile = new JMenuItem("Open PGN File");
        openPGNFile.addActionListener((ActionEvent e) -> {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("PGN Files", "pgn");
            fileChooser.setFileFilter(filter);

            int result = fileChooser.showOpenDialog(null); // 'null' centers the dialog
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                // Handle the selected PGN file
            }
        });

        JMenuItem pastePGN = new JMenuItem("Paste PGN Notation");
        pastePGN.addActionListener((ActionEvent e) -> {
            String pgn = JOptionPane.showInputDialog(null, "Enter PGN Notation:", "Paste PGN", JOptionPane.PLAIN_MESSAGE);
            if (pgn != null && !pgn.trim().isEmpty()) {
                surface.setChessboardPGN(pgn);
                surface.repaint();
            }
        });

        JMenu themeMenu = new JMenu("Theme");
        themeMenu.addActionListener((ActionEvent e) -> {

        });
        
        JMenu aboutMenu = new JMenu("About");
        aboutMenu.addActionListener((ActionEvent e) -> {
            
        });

        fileMenu.add(openPGNFile);
        fileMenu.add(pastePGN);
        
        menuBar.add(themeMenu);
        menuBar.add(aboutMenu);
        menuBar.add(fileMenu);
        
        return menuBar;
    }
}

class PaintSurface extends JPanel {
    private static final long serialVersionUID = 1L;
    
    private Chessboard chessboard;

    public PaintSurface() {
        super.setPreferredSize(new Dimension(640, 640));
        
        chessboard = new Chessboard();
    }

    public void setChessboardPGN(String pgnNotation) {
        chessboard.setPGN(pgnNotation);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        super.paintComponent(graphics);

        chessboard.render(graphics);
    }
}
