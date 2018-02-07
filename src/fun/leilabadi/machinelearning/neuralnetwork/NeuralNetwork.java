package fun.leilabadi.machinelearning.neuralnetwork;

import fun.leilabadi.machinelearning.neuralnetwork.functions.NormalizationFunction;

public abstract class NeuralNetwork {
    protected final Layer[] layers;
    protected final NormalizationFunction normalizationFunction;
    protected ActivationListener listener;

    NeuralNetwork(Layer[] layers, NormalizationFunction normalizationFunction) {
        this.layers = layers;
        this.normalizationFunction = normalizationFunction;
    }

    public Layer[] getLayers() {
        return layers;
    }

    public void setActivationListener(ActivationListener listener) {
        this.listener = listener;
    }

    protected Layer firstLayer() {
        return layers[0];
    }

    protected Layer lastLayer() {
        return layers[getLayerCount() - 1];
    }

    public int getLayerCount() {
        return layers.length;
    }

    public abstract float[] getOutput();

    public void activate(ActivationAdapter adapter) {
        final ActivationSet activations = adapter.getActivations();
        resetNeuronActivations();
        activateLayers(activations);

        if (listener != null)
            listener.onActivation();
    }

    protected void resetNeuronActivations() {
        for (Layer layer : layers) {
            for (Neuron neuron : layer.getNeurons()) {
                neuron.activation = 0;
            }
        }
    }

    protected abstract void activateLayers(ActivationSet activations);
}
