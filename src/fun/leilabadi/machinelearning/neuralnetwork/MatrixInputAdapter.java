package fun.leilabadi.machinelearning.neuralnetwork;

import fun.leilabadi.machinelearning.common.Matrix;

public class MatrixInputAdapter implements NeuralNetworkInputAdapter {
    private final Matrix matrix;

    public MatrixInputAdapter(Matrix matrix) {
        this.matrix = matrix;
    }

    @Override
    public float[] getActivations() {

        final float[] activations = new float[matrix.getRowCount() * matrix.getColumnCount()];
        for (int i = 0; i < matrix.getRowCount(); i++) {
            for (int j = 0; j < matrix.getColumnCount(); j++) {
                activations[i * matrix.getColumnCount() + j] = matrix.getElement(i, j);
            }
        }
        return activations;
    }
}
