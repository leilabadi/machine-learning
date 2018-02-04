package fun.leilabadi.machinelearning.neuralnetwork;

public abstract class NeuralNetwork {
    final NeuronLayer[] layers;
    private ActivationListener listener;

    NeuralNetwork(NeuronLayer[] layers) {
        this.layers = layers;
    }

    public NeuronLayer[] getLayers() {
        return layers;
    }

    public void activate(ActivationAdapter adapter) {
        activateFirstLayer(adapter);

        if (listener != null) listener.onActivation();
    }

    public abstract float[] getOutput();

    public void setActivationListener(ActivationListener listener) {
        this.listener = listener;
    }

    protected abstract void activateFirstLayer(ActivationAdapter adapter);
}
