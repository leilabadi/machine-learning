package fun.leilabadi.machinelearning.neuralnetwork;

public class NetworkTrainer {
    private final NeuralNetwork network;
    private final float[] expectedResult;

    public NetworkTrainer(NeuralNetwork network, float[] expectedResult) {
        this.network = network;
        this.expectedResult = expectedResult;
    }

    public float calculateCost() {

        final float[] output = network.getOutput();

        float cost = 0;
        for (int i = 0; i < expectedResult.length; i++) {
            cost += Math.pow(output[i] - expectedResult[i], 2);
        }

        return cost;
    }
}
