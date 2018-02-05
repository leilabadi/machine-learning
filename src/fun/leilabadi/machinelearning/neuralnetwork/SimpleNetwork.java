package fun.leilabadi.machinelearning.neuralnetwork;

public class SimpleNetwork extends NeuralNetwork {

    SimpleNetwork(Layer[] layers) {
        super(layers);
    }

    @Override
    public float[] getOutput() {
        Neuron neuron;
        final float[] result = new float[lastLayer().size()];
        for (int i = 0; i < result.length; i++) {
            neuron = lastLayer().getNeurons()[i];
            result[i] = neuron.activation;
        }
        return result;
    }

    @Override
    protected void activateLayers(ActivationSet activations) {
        if (activations.getLength() != firstLayer().size())
            throw new RuntimeException("Size of activation set doesn't match.");

        for (int i = 0; i < activations.getLength(); i++) {
            firstLayer().getNeurons()[i].activation = activations.getData()[i];
        }

        Layer layer;
        Neuron nextNeuron;
        for (int i = 0; i < getLayerCount() - 1; i++) {
            layer = layers[i];
            for (Neuron neuron : layer.getNeurons()) {
                for (Link link : neuron.getOutputLinks()) {
                    nextNeuron = link.getEndingNeuron();
                    //nextNeuron.activation += neuron.activation * link.getWeight();
                    //TODO: Normalize activations
                }
            }
        }
    }
}
