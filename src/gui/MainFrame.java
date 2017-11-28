package gui;

import logic.transform.ControlListener;
import logic.transform.LineDrawable;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public static int startWidth;
    public static int startHeight;

    private static MainFrame instance = null;
    private static final String FRAME_NAME = "Laboratory by graphics";

    private MainPanel mainPanel;
    private ControlAdapter adapter;

    private MainFrame(){
        super(FRAME_NAME);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension displaySize = Toolkit.getDefaultToolkit().getScreenSize();
        int displayWidth = displaySize.width;
        int displayHeight = displaySize.height;
        startWidth = displayWidth/2;
        startHeight = displayHeight/2;
        setBounds(displayWidth/2-startWidth/2, displayHeight/2-startHeight/2, startWidth, startHeight);

        mainPanel = new MainPanel();
        getContentPane().add(mainPanel);

        pack();
        setVisible(true);
    }

    public LineDrawable getLineDrawable(){
        return mainPanel.drawablePanel;
    }

    public void setControlListener(ControlListener listener){
        if (adapter != null){
            removeKeyListener(adapter);
            mainPanel.drawablePanel.removeMouseListener(adapter);
            mainPanel.drawablePanel.removeMouseMotionListener(adapter);
            mainPanel.drawablePanel.removeMouseWheelListener(adapter);
        }

        adapter = new ControlAdapter(listener, mainPanel.drawablePanel);
        addKeyListener(adapter);
        mainPanel.drawablePanel.addMouseListener(adapter);
        mainPanel.drawablePanel.addMouseMotionListener(adapter);
        mainPanel.drawablePanel.addMouseWheelListener(adapter);
    }

    public static MainFrame getInstance(){
        if (instance == null) instance = new MainFrame();
        return instance;
    }

}
