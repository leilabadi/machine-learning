package com.leilabadi.machinelearning.neuralnetwork;

public class SimpleNetwork extends NeuralNetwork {

    public SimpleNetwork(NeuronLayer[] layers) {
        super(layers);
    }

    @Override
    public void activate(NeuralNetworkInputAdapter inputAdapter) {
        layers[0].activate(inputAdapter.getActivations());
    }

    @Override
    public float[] getOutput() {
        return layers[layers.length - 1].getOutput();
    }
}
