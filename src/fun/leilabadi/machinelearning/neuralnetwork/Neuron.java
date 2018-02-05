package fun.leilabadi.machinelearning.neuralnetwork;

public class Neuron {
    private Link[] inputLinks;
    private Link[] outputLinks;
    float activation;

    Neuron() {
    }

    public Link[] getInputLinks() {
        return inputLinks;
    }

    void setInputLinks(Link[] inputLinks) {
        this.inputLinks = inputLinks;
    }

    public Link[] getOutputLinks() {
        return outputLinks;
    }

    void setOutputLinks(Link[] outputLinks) {
        this.outputLinks = outputLinks;
    }

    public float getActivation() {
        return activation;
    }

    @Override
    public String toString() {
        return String.format("%.2f", activation);
    }
}
