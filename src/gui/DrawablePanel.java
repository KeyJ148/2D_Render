package gui;

import logic.storage.Line;
import logic.transform.LineDrawable;

import javax.swing.*;
import java.awt.*;

public class DrawablePanel extends JPanel implements LineDrawable {

    private Line[] lines;

    @Override
    public void draw(Line[] lines){
        this.lines = lines;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawRect(0, 0, getWidth()-1, getHeight()-1);

        if (lines != null){
            for (Line line : lines){
                g.drawLine((int) line.getP1().x, getHeight()-1-((int) line.getP1().y),
                           (int) line.getP2().x, getHeight()-1-((int) line.getP2().y));
            }
        }
    }
}
