package logic.transform;

public interface ControlListener {

    void changeSize(double delta, double x, double y);
    void changePos(double deltaX, double deltaY);
    void changeRotation(double delta, double x, double y);
    void reflectX();
    void reflectY();

}
