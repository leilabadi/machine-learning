package com.leilabadi.machinelearning.neuralnetwork;

public class NetworkTrainer {
    private final NeuralNetwork network;
    private final ActivationSet expectedResult;

    public NetworkTrainer(NeuralNetwork network, ActivationSet expectedResult) {
        this.network = network;
        this.expectedResult = expectedResult;
    }

    public float calculateCost() {

        final ActivationSet output = network.getOutput();

        float cost = 0;
        for (int i = 0; i < expectedResult.getCount(); i++) {
            cost += Math.pow(output.getNeuron(i) - expectedResult.getNeuron(i), 2);
        }

        return cost;
    }
}
