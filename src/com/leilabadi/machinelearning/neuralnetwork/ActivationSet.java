package com.leilabadi.machinelearning.neuralnetwork;

public class ActivationSet {
    private final int count;
    private final float[] neurons;

    public ActivationSet(int count) {
        this.count = count;
        this.neurons = new float[count];
    }

    public int getCount() {
        return count;
    }

    public float getNeuron(int i) {
        return neurons[i];
    }
}
