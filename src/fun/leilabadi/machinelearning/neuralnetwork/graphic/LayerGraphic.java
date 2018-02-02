package fun.leilabadi.machinelearning.neuralnetwork.graphic;

public class LayerGraphic {
    private final NeuronGraphic[] neurons;

    public LayerGraphic(NeuronGraphic[] neurons) {
        this.neurons = neurons;
    }

    public NeuronGraphic[] getNeurons() {
        return neurons;
    }
}
