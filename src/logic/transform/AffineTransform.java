package logic.transform;

import logic.Matrix;
import logic.storage.Point;
import logic.storage.Storage;

public class AffineTransform implements ControlListener {

    private Storage storage;

    public AffineTransform(Storage storage){
        this.storage = storage;
    }

    private void transformAll(Matrix m){
        for (Point point : storage.points){
            Matrix start = new Matrix(new double[][]{{point.x, point.y, 1}});
            Matrix result = Matrix.multiplication(start, m);
            point.x = result.data[0][0];
            point.y = result.data[0][1];
        }

        storage.draw();
    }

    @Override
    public void changeSize(double delta, double x, double y) {
        Matrix Tma = new Matrix(new double[][]{
                {1, 0, 0},
                {0, 1, 0},
                {-x, -y, 1}
        });

        Matrix D = new Matrix(new double[][]{
                {delta, 0, 0},
                {0, delta, 0},
                {0, 0, 1}
        });

        Matrix Ta = new Matrix(new double[][]{
                {1, 0, 0},
                {0, 1, 0},
                {x, y, 1}
        });

        Matrix m = Matrix.multiplication(Matrix.multiplication(Tma, D), Ta);
        transformAll(m);
    }

    @Override
    public void changePos(double deltaX, double deltaY) {
        Matrix Ta = new Matrix(new double[][]{
                {1, 0, 0},
                {0, 1, 0},
                {deltaX, deltaY, 1}
        });

        transformAll(Ta);
    }

    @Override
    public void changeRotation(double delta, double x, double y) {
        delta = Math.toRadians(delta);

        Matrix Tma = new Matrix(new double[][]{
                {1, 0, 0},
                {0, 1, 0},
                {-x, -y, 1}
        });

        Matrix Ra = new Matrix(new double[][]{
                {Math.cos(delta), Math.sin(delta), 0},
                {-Math.sin(delta), Math.cos(delta), 0},
                {0, 0, 1}
        });

        Matrix Ta = new Matrix(new double[][]{
                {1, 0, 0},
                {0, 1, 0},
                {x, y, 1}
        });

        Matrix m = Matrix.multiplication(Matrix.multiplication(Tma, Ra), Ta);
        transformAll(m);
    }

    @Override
    public void reflectX() {
        Matrix Rx = new Matrix(new double[][]{
                {1, 0, 0},
                {0, -1, 0},
                {0, 0, 1}
        });

        transformAll(Rx);
    }

    @Override
    public void reflectY() {
        Matrix Ry = new Matrix(new double[][]{
                {-1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        });

        transformAll(Ry);
    }
}
