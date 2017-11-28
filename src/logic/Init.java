package logic;

import gui.MainFrame;
import logic.storage.Line;
import logic.storage.Point;
import logic.storage.Storage;
import logic.transform.AffineTransform;

public class Init {

    public static void main(String[] args) {
        MainFrame.getInstance();

        Storage storage = new Storage(MainFrame.getInstance().getLineDrawable());
        AffineTransform transform = new AffineTransform(storage);
        MainFrame.getInstance().setControlListener(transform);

        initStorage(storage, transform);
        storage.draw();
    }

    public static void initStorage(Storage storage, AffineTransform transform){
        Point pL1 = new Point(0, 0);
        Point pL2 = new Point(0, 8);
        Point pL3 = new Point(0, 10);
        Point pL4 = new Point(0, 12);
        Point pL5 = new Point(0, 14);
        Point pL6 = new Point(0, 16);

        Point pR1 = new Point(8, 0);
        Point pR2 = new Point(8, 8);
        Point pR3 = new Point(8, 10);
        Point pR4 = new Point(8, 12);
        Point pR5 = new Point(8, 14);
        Point pR6 = new Point(8, 16);

        Line lL1 = new Line(pL1, pL2);
        Line lL2 = new Line(pL2, pL3);
        Line lL3 = new Line(pL3, pL4);
        Line lL4 = new Line(pL4, pL5);
        Line lL5 = new Line(pL5, pL6);

        Line lR1 = new Line(pR1, pR2);
        Line lR2 = new Line(pR2, pR3);
        Line lR3 = new Line(pR3, pR4);
        Line lR4 = new Line(pR4, pR5);
        Line lR5 = new Line(pR5, pR6);

        Line lM1 = new Line(pL1, pR1);
        Line lM2 = new Line(pL2, pR2);
        Line lM3 = new Line(pL3, pR3);
        Line lM4 = new Line(pL4, pR4);
        Line lM5 = new Line(pL5, pR5);
        Line lM6 = new Line(pL6, pR6);

        storage.points.add(pL1);
        storage.points.add(pL2);
        storage.points.add(pL3);
        storage.points.add(pL4);
        storage.points.add(pL5);
        storage.points.add(pL6);

        storage.points.add(pR1);
        storage.points.add(pR2);
        storage.points.add(pR3);
        storage.points.add(pR4);
        storage.points.add(pR5);
        storage.points.add(pR6);

        storage.lines.add(lL1);
        storage.lines.add(lL2);
        storage.lines.add(lL3);
        storage.lines.add(lL4);
        storage.lines.add(lL5);

        storage.lines.add(lR1);
        storage.lines.add(lR2);
        storage.lines.add(lR3);
        storage.lines.add(lR4);
        storage.lines.add(lR5);

        storage.lines.add(lM1);
        storage.lines.add(lM2);
        storage.lines.add(lM3);
        storage.lines.add(lM4);
        storage.lines.add(lM5);
        storage.lines.add(lM6);

        Point pCDL1 = new Point(0.5, 14.75);
        Point pCDL2 = new Point(0.5, 15.75);
        Point pCDR1 = new Point(7.5, 14.75);
        Point pCDR2 = new Point(7.5, 15.75);

        Line lCDL = new Line(pCDL1, pCDL2);
        Line lCDR = new Line(pCDR1, pCDR2);
        Line lCDD = new Line(pCDL1, pCDR1);
        Line lCDU = new Line(pCDL2, pCDR2);

        storage.points.add(pCDL1);
        storage.points.add(pCDL2);
        storage.points.add(pCDR1);
        storage.points.add(pCDR2);

        storage.lines.add(lCDL);
        storage.lines.add(lCDR);
        storage.lines.add(lCDD);
        storage.lines.add(lCDU);

        Point pButtonL1 = new Point(6.5, 14.20);
        Point pButtonL2 = new Point(6.5, 14.55);
        Point pButtonR1 = new Point(7.5, 14.20);
        Point pButtonR2 = new Point(7.5, 14.55);

        Line lButtonL = new Line(pButtonL1, pButtonL2);
        Line lButtonR = new Line(pButtonR1, pButtonR2);
        Line lButtonD = new Line(pButtonL1, pButtonR1);
        Line lButtonU = new Line(pButtonL2, pButtonR2);

        storage.points.add(pButtonL1);
        storage.points.add(pButtonL2);
        storage.points.add(pButtonR1);
        storage.points.add(pButtonR2);

        storage.lines.add(lButtonL);
        storage.lines.add(lButtonR);
        storage.lines.add(lButtonD);
        storage.lines.add(lButtonU);

        Point pUSB1L1 = new Point(2, 8.75);
        Point pUSB1L2 = new Point(3, 8.75);
        Point pUSB1R1 = new Point(2, 9.25);
        Point pUSB1R2 = new Point(3, 9.25);

        Point pUSB2L1 = new Point(5, 8.75);
        Point pUSB2L2 = new Point(6, 8.75);
        Point pUSB2R1 = new Point(5, 9.25);
        Point pUSB2R2 = new Point(6, 9.25);

        Line lUSB1L = new Line(pUSB1L1, pUSB1L2);
        Line lUSB1R = new Line(pUSB1R1, pUSB1R2);
        Line lUSB1D = new Line(pUSB1L1, pUSB1R1);
        Line lUSB1U = new Line(pUSB1L2, pUSB1R2);

        Line lUSB2L = new Line(pUSB2L1, pUSB2L2);
        Line lUSB2R = new Line(pUSB2R1, pUSB2R2);
        Line lUSB2D = new Line(pUSB2L1, pUSB2R1);
        Line lUSB2U = new Line(pUSB2L2, pUSB2R2);

        storage.points.add(pUSB1L1);
        storage.points.add(pUSB1L2);
        storage.points.add(pUSB1R1);
        storage.points.add(pUSB1R2);

        storage.points.add(pUSB2L1);
        storage.points.add(pUSB2L2);
        storage.points.add(pUSB2R1);
        storage.points.add(pUSB2R2);

        storage.lines.add(lUSB1L);
        storage.lines.add(lUSB1R);
        storage.lines.add(lUSB1D);
        storage.lines.add(lUSB1U);

        storage.lines.add(lUSB2L);
        storage.lines.add(lUSB2R);
        storage.lines.add(lUSB2D);
        storage.lines.add(lUSB2U);

        transform.changeSize(20, 0, 0);
        transform.changePos(200, 200);
    }
}
