package logic;

public class Matrix {

    public static class MathMatrixException extends RuntimeException{
        public enum Type {SUM, SUBTRACTION, MULTIPLICATION};

        protected MathMatrixException(Matrix matrix1, Matrix matrix2, Type type){
            super("Exception in operation " + type.toString() + " from matrix:\n" + matrix1.toString() + "\n" + matrix2.toString());

        }
    }

    public double[][] data;
    public int h, w;

    public Matrix(int h, int w){
        this.data = new double[h][w];
        this.h = h;
        this.w = w;
    }

    public Matrix(double[][] data){
        this.data = Matrix.copyArray(data);
        this.h = data.length;
        this.w = data[0].length;
    }

    public Matrix(Matrix matrix){
        this(matrix.data);
    }

    public static Matrix sum(Matrix m1, Matrix m2) {
        if (m1.h != m2.h || m1.w != m2.w) throw new MathMatrixException(m1, m2, MathMatrixException.Type.SUM);

        Matrix result = new Matrix(m1.h, m1.w);
        for (int i=0; i<result.h; i++){
            for (int j = 0; j < result.w; j++) {
                result.data[i][j] = m1.data[i][j] + m2.data[i][j];
            }
        }

        return result;
    }

    public static Matrix subtraction(Matrix m1, Matrix m2){
        if (m1.h != m2.h || m1.w != m2.w) throw new MathMatrixException(m1, m2, MathMatrixException.Type.SUBTRACTION);

        return Matrix.sum(m1, Matrix.multiplication(m2, -1.0));
    }

    public static Matrix multiplication(Matrix m, double d){
        Matrix result = new Matrix(m.h, m.w);
        for (int i=0; i<result.h; i++){
            for (int j = 0; j < result.w; j++) {
                result.data[i][j] = m.data[i][j]*d;
            }
        }

        return result;
    }

    public static Matrix multiplication(Matrix m1, Matrix m2){
        if (m1.w != m2.h) throw new MathMatrixException(m1, m2, MathMatrixException.Type.MULTIPLICATION);

        Matrix result = new Matrix(m1.h, m2.w);
        for (int i = 0; i < result.h; i++) {
            for (int j = 0; j < result.w; j++) {
                for (int k = 0; k < m1.w; k++) {
                    result.data[i][j] += m1.data[i][k]*m2.data[k][j];
                }
            }
        }

        return result;
    }

    public static Matrix transposition(Matrix m){
        Matrix result = new Matrix(m.w, m.h);

        for (int i=0; i<result.h; i++){
            for (int j = 0; j < result.w; j++) {
                result.data[i][j] = m.data[j][i];
            }
        }

        return result;
    }

    private static double[][] copyArray(double[][] array){
        double[][] newArray = new double[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                newArray[i][j] = array[i][j];
            }
        }

        return newArray;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();

        for (int i=0; i<data.length; i++){
            for (int j=0; j<data[i].length; j++){
                result.append(String.format("%.3f", data[i][j]) + " ");
            }
            result.append("\n");
        }

        return result.toString();
    }

}
