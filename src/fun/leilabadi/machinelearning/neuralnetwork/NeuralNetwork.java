package fun.leilabadi.machinelearning.neuralnetwork;

public abstract class NeuralNetwork {
    protected final NeuronLayer[] layers;

    public NeuralNetwork(NeuronLayer[] layers) {
        this.layers = layers;
    }

    public NeuronLayer[] getLayers() {
        return layers;
    }

    public abstract void activate(NeuralNetworkInputAdapter inputAdapter);

    public abstract float[] getOutput();

}
