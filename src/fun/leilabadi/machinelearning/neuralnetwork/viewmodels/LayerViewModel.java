package fun.leilabadi.machinelearning.neuralnetwork.viewmodels;

public class LayerViewModel {

    private final NeuronViewModel[] neurons;

    public LayerViewModel(NeuronViewModel[] neurons) {
        this.neurons = neurons;
    }

    public NeuronViewModel[] getNeurons() {
        return neurons;
    }
}
