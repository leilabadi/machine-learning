package fun.leilabadi.machinelearning.common;

public class Matrix {
    private final int rowCount;
    private final int columnCount;
    private final float[][] elements;

    public Matrix(int rowCount, int columnCount) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        elements = new float[rowCount][columnCount];
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public float getElement(int i, int j) {
        return elements[i][j];
    }
}
