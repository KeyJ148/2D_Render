package gui;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel{

    public DrawablePanel drawablePanel;
    public ControlPanel controlPanel;

    public MainPanel(){
        setLayout(new BorderLayout());
        int w = MainFrame.startWidth;
        int h = MainFrame.startHeight;

        drawablePanel = new DrawablePanel();
        drawablePanel.setPreferredSize(new Dimension(w-ControlPanel.WIDTH, h));
        add(drawablePanel, BorderLayout.CENTER);

        controlPanel = new ControlPanel();
        controlPanel.setPreferredSize(new Dimension(ControlPanel.WIDTH, h));
        add(controlPanel, BorderLayout.EAST);
    }
}
