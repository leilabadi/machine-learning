package com.leilabadi.machinelearning.neuralnetwork;

public class Link {
    private final Neuron startingNeuron;
    private final Neuron endingNeuron;
    private float weight;

    public Link(Neuron startingNeuron, Neuron endingNeuron) {
        this.startingNeuron = startingNeuron;
        this.endingNeuron = endingNeuron;
    }

    public Neuron getStartingNeuron() {
        return startingNeuron;
    }

    public Neuron getEndingNeuron() {
        return endingNeuron;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
