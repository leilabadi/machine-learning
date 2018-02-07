package fun.leilabadi.machinelearning.neuralnetwork;

public class Link {
    private final Neuron source;
    private final Neuron destination;
    private float weight;

    Link(Neuron source, Neuron destination, float weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public Neuron getSource() {
        return source;
    }

    public Neuron getDestination() {
        return destination;
    }

    public float getWeight() {
        return weight;
    }

    protected void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("%.2f", weight);
    }
}
