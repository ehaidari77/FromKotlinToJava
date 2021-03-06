package part1.fourinrow.swing;

import part1.fourinrow.core.Board;
import part1.fourinrow.core.Cell;
import part1.fourinrow.core.Chip;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("WeakerAccess")
public class CellPanel extends JPanel {

    private final Cell cell;

    private final Board board;

    public CellPanel(Cell cell, Board board) {
        this.cell = cell;
        this.board = board;
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(null,
                        "CELL = " + cell,
                        "",
                        JOptionPane.INFORMATION_MESSAGE);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    board.makeTurn(cell.getX());
                    repaint();
                }
            }
        });

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Chip chip = board.get(cell);
        if (chip == null) return;
        switch (chip) {
            case YELLOW:
                g.setColor(Color.YELLOW);
                break;
            case RED:
                g.setColor(Color.RED);
                break;
        }
        int width = getWidth();
        int height = getHeight();
        g.fillOval(width / 4, height / 4, width / 2, height / 2);
    }
}
