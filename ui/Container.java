package ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import components.Game;
import helpers.PGN;

public class Container {
    public final static PaintSurface surface = new PaintSurface();
    private final static JTextArea pgnTextArea = new JTextArea(35, 10);

    public static void main(String[] args) {
        JFrame window = new JFrame();

        // set layout
        window.getContentPane().setLayout(new FlowLayout());

        // add components
        window.setJMenuBar(createMenuBar());
        window.getContentPane().add(surface);
        window.getContentPane().add(createSidePanel());

        // window settings
        window.pack();
        window.setTitle("Chess Growth");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);
    }

    private static JPanel createSidePanel() {
        JPanel sidePanel = new JPanel();
        sidePanel.setPreferredSize(new Dimension(160, 640));

        JButton start = new JButton("Start Game");
        start.addActionListener((ActionEvent e) -> {
            
        });

        pgnTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(pgnTextArea);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    
        sidePanel.add(start);
        sidePanel.add(scrollPane);
        return sidePanel;
    }

    private static JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");


        JMenuItem pastePGN = new JMenuItem("Paste PGN Notation");
        pastePGN.addActionListener((ActionEvent e) -> {
            String pgn = JOptionPane.showInputDialog(null, "Enter PGN Notation:", "Paste PGN", JOptionPane.PLAIN_MESSAGE);
            if (pgn != null && !pgn.trim().isEmpty()) {
                Game game = new Game();
                PGN pgn2 = new PGN(pgn);
                game.setPGN(pgn2);

                PaintSurface.chessboard.setGame(game);
                pgnTextArea.setText(pgn2.getFormattedPGN());
        }
        });

        fileMenu.add(pastePGN);
        
        menuBar.add(fileMenu);
        
        return menuBar;
    }
}
