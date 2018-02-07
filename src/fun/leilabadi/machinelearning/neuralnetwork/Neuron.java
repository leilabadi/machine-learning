package fun.leilabadi.machinelearning.neuralnetwork;

public class Neuron {
    private Link[] forwardLinks;
    private Link[] backwardLinks;
    protected float activation;
    protected float bias;

    Neuron() {
    }

    public Link[] getForwardLinks() {
        return forwardLinks;
    }

    protected void setForwardLinks(Link[] forwardLinks) {
        this.forwardLinks = forwardLinks;
    }

    public Link[] getBackwardLinks() {
        return backwardLinks;
    }

    protected void setBackwardLinks(Link[] backwardLinks) {
        this.backwardLinks = backwardLinks;
    }

    public float getActivation() {
        return activation;
    }

    public float getBias() {
        return bias;
    }

    @Override
    public String toString() {
        return String.format("%.2f", activation);
    }
}
