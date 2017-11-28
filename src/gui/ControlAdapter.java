package gui;

import logic.transform.ControlListener;

import java.awt.event.*;

public class ControlAdapter implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {

    public static final Double DELTA_ROTATE = 5.0;
    public static final Double DELTA_SIZE = 0.03;

    private int mouseX = -1, mouseY = -1;

    private ControlListener listener;
    private DrawablePanel dp;

    public ControlAdapter(ControlListener listener, DrawablePanel dp){
        this.listener = listener;
        this.dp = dp;
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()){
            case KeyEvent.VK_OPEN_BRACKET: listener.changeRotation(DELTA_ROTATE, mouseX, mouseY); break;
            case KeyEvent.VK_CLOSE_BRACKET: listener.changeRotation(-DELTA_ROTATE, mouseX, mouseY); break;
            case KeyEvent.VK_X: listener.reflectX(); break;
            case KeyEvent.VK_Y: listener.reflectY(); break;
        }
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        if (mouseX != -1 && mouseY != -1) listener.changePos(mouseEvent.getX()-mouseX, (dp.getHeight()-mouseEvent.getY()-mouseY));

        mouseX = mouseEvent.getX();
        mouseY = dp.getHeight() - mouseEvent.getY();
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent) {
        double delta = DELTA_SIZE*mouseWheelEvent.getWheelRotation()*mouseWheelEvent.getScrollAmount();
        listener.changeSize(1+delta, mouseX, mouseY);
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        mouseX = mouseEvent.getX();
        mouseY = dp.getHeight() - mouseEvent.getY();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {}

    @Override
    public void keyPressed(KeyEvent keyEvent) {}

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {}

    @Override
    public void mousePressed(MouseEvent mouseEvent) {}

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {}

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {}

    @Override
    public void mouseExited(MouseEvent mouseEvent) {}
}
