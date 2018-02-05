package fun.leilabadi.machinelearning.neuralnetwork.ui;

public class VisualNetwork {

    private final VisualLayer[] layers;

    public VisualNetwork(VisualLayer[] layers) {
        this.layers = layers;
    }

    public VisualLayer[] getLayers() {
        return layers;
    }

    public int getLayerCount() {
        return layers.length;
    }
}
