package fun.leilabadi.machinelearning.neuralnetwork.viewmodels;

public class NetworkViewModel {

    private final LayerViewModel[] layers;

    public NetworkViewModel(LayerViewModel[] layers) {
        this.layers = layers;
    }

    public LayerViewModel[] getLayers() {
        return layers;
    }
}
