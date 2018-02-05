package fun.leilabadi.machinelearning.neuralnetwork;

public class Layer {
    private final Neuron[] neurons;

    Layer(Neuron[] neurons) {
        this.neurons = neurons;
    }

    public Neuron[] getNeurons() {
        return neurons;
    }

    public int size() {
        return neurons.length;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (Neuron neuron : neurons) {
            sb.append(neuron).append(", ");
        }
        return sb.toString();
    }
}
