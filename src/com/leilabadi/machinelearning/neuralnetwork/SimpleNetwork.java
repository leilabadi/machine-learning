package com.leilabadi.machinelearning.neuralnetwork;

import com.leilabadi.machinelearning.common.Matrix;

public class SimpleNetwork extends NeuralNetwork {

    public SimpleNetwork(NeuronLayer[] layers) {
        super(layers);
    }

    @Override
    void load(Matrix matrix) {

    }

    @Override
    public ActivationSet getOutput() {
        return null;
    }
}
