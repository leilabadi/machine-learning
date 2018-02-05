package fun.leilabadi.machinelearning.neuralnetwork.ui;

public class VisualLayer {

    private final VisualNeuron[] neurons;

    public VisualLayer(VisualNeuron[] neurons) {
        this.neurons = neurons;
    }

    public VisualNeuron[] getNeurons() {
        return neurons;
    }

    public int size() {
        return neurons.length;
    }
}
