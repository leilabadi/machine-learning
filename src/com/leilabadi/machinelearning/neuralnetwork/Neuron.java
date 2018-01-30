package com.leilabadi.machinelearning.neuralnetwork;

public class Neuron {
    private Link[] inputLinks;
    private Link[] outputLinks;

    public Link[] getInputLinks() {
        return inputLinks;
    }

    public void setInputLinks(Link[] inputLinks) {
        this.inputLinks = inputLinks;
    }

    public Link[] getOutputLinks() {
        return outputLinks;
    }

    public void setOutputLinks(Link[] outputLinks) {
        this.outputLinks = outputLinks;
    }
}
