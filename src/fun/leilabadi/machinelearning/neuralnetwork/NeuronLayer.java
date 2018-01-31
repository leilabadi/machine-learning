package fun.leilabadi.machinelearning.neuralnetwork;

public class NeuronLayer {
    private final Neuron[] neurons;

    public NeuronLayer(Neuron[] neurons) {
        this.neurons = neurons;
    }

    public Neuron[] getNeurons() {
        return neurons;
    }

    public void activate(float[] activations) {
    }

    public float[] getOutput() {
        return null;
    }
}