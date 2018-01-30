package com.leilabadi.machinelearning.neuralnetwork;

import com.leilabadi.machinelearning.common.Matrix;

public abstract class NeuralNetwork {
    protected NeuronLayer[] layers;

    public NeuralNetwork(NeuronLayer[] layers) {
        this.layers = layers;
    }

    abstract void load(Matrix matrix);

    abstract ActivationSet getOutput();
}
