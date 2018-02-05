package fun.leilabadi.machinelearning.neuralnetwork;

import fun.leilabadi.machinelearning.common.Matrix;

public class MatrixActivationAdapter implements ActivationAdapter {
    private final Matrix matrix;

    public MatrixActivationAdapter(Matrix matrix) {
        this.matrix = matrix;
    }

    @Override
    public ActivationSet getActivations() {

        final float[] activations = new float[matrix.getRowCount() * matrix.getColumnCount()];
        for (int i = 0; i < matrix.getRowCount(); i++) {
            for (int j = 0; j < matrix.getColumnCount(); j++) {
                activations[i * matrix.getColumnCount() + j] = matrix.getElement(i, j);
            }
        }
        return new ActivationSet(activations);
    }
}
