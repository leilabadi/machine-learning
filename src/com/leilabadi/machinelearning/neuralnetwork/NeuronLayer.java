package com.leilabadi.machinelearning.neuralnetwork;

public class NeuronLayer {
    private final Neuron[] neurons;

    public NeuronLayer(Neuron[] neurons) {
        this.neurons = neurons;
    }

    public Neuron[] getNeurons() {
        return neurons;
    }

    public void activate(ActivationSet activations) {
    }

    public ActivationSet getOutput() {
        return null;
    }
}
