package com.leilabadi.machinelearning.neuralnetwork;

import com.leilabadi.machinelearning.common.Matrix;

public abstract class NeuralNetwork {
    protected NeuronLayer[] layers;

    public NeuralNetwork(NeuronLayer[] layers) {
        this.layers = layers;
    }

    public abstract void activate(NeuralNetworkInputAdapter inputAdapter);

    public abstract float[] getOutput();
}
