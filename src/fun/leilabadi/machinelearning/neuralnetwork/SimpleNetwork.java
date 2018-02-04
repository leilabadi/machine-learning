package fun.leilabadi.machinelearning.neuralnetwork;

public class SimpleNetwork extends NeuralNetwork {

    public SimpleNetwork(NeuronLayer[] layers) {
        super(layers);
    }

    @Override
    protected void activateFirstLayer(ActivationAdapter adapter) {
        layers[0].activate(adapter.getActivations());
    }

    @Override
    public float[] getOutput() {
        return layers[layers.length - 1].getOutput();
    }
}
