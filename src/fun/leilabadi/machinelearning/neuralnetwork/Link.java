package fun.leilabadi.machinelearning.neuralnetwork;

public class Link {
    private final Neuron startingNeuron;
    private final Neuron endingNeuron;
    private float weight;

    Link(Neuron startingNeuron, Neuron endingNeuron, float weight) {
        this.startingNeuron = startingNeuron;
        this.endingNeuron = endingNeuron;
        this.weight = weight;
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

    void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("%.2f", weight);
    }
}
