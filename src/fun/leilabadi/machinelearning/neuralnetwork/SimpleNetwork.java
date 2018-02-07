package fun.leilabadi.machinelearning.neuralnetwork;

import fun.leilabadi.machinelearning.neuralnetwork.functions.NormalizationFunction;

public class SimpleNetwork extends NeuralNetwork {

    SimpleNetwork(Layer[] layers, NormalizationFunction normalizationFunction) {
        super(layers, normalizationFunction);
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

        //activate first layer
        for (int i = 0; i < activations.getLength(); i++) {
            firstLayer().getNeurons()[i].activation = activations.getData()[i];
        }

        //activate middle layers
        Layer layer;
        Neuron nextNeuron;
        for (int i = 0; i < getLayerCount() - 1; i++) {
            layer = layers[i];
            normalizeLayer(layer);
            for (Neuron neuron : layer.getNeurons()) {
                for (Link link : neuron.getForwardLinks()) {
                    nextNeuron = link.getDestination();
                    nextNeuron.activation += neuron.activation * link.getWeight();
                }
            }
        }

        //activate last layer
        normalizeLayer(lastLayer());
    }

    private void normalizeLayer(Layer layer) {
        for (Neuron neuron : layer.getNeurons()) {
            neuron.activation = normalizationFunction.normalize(neuron.activation + neuron.bias);
        }
    }
}
