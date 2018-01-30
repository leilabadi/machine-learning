package com.leilabadi.machinelearning.neuralnetwork;

public abstract class NeuralNetworkBuilder {

    protected NeuralNetwork network;

    public abstract void build();

    public NeuralNetwork getResult() {
        return network;
    }
}
