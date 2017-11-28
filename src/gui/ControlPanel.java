package gui;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {

    public static final int WIDTH = 200;
    public static final String TEXT = "Перемещение: ЛКМ\n" +
                                      "Масштабирование: \nколёсик мыши\n" +
                                      "Вращение: '[' и ']'\n" +
                                      "Отражение: 'x' и 'y'\n";

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;
        g.drawRect(0, 0, getWidth()-1, getHeight()-1);

        String[] lines = TEXT.split("\n");
        for (int i = 0; i < lines.length; i++) {
            g2D.drawString(lines[i], 10, 20+15*i);
        }
    }

}
