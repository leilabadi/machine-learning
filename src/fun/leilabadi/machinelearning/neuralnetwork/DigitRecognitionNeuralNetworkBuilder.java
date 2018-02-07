package fun.leilabadi.machinelearning.neuralnetwork;

import fun.leilabadi.machinelearning.Constants;
import fun.leilabadi.machinelearning.neuralnetwork.functions.SigmoidFunction;

import java.util.Random;

public class DigitRecognitionNeuralNetworkBuilder extends NeuralNetworkBuilder {

    @Override
    public void build() {
        buildDispatchedLayers();
        bindLayers();
    }

    private void buildDispatchedLayers() {
        final Layer[] layers = new Layer[Constants.DIGIT_NETWORK_LAYER_COUNT];

        final int[] neuronCounts = new int[]{
                Constants.DIGIT_NETWORK_LAYER1_NEURON_COUNT,
                Constants.DIGIT_NETWORK_LAYER2_NEURON_COUNT,
                Constants.DIGIT_NETWORK_LAYER3_NEURON_COUNT,
                Constants.DIGIT_NETWORK_LAYER4_NEURON_COUNT};

        for (int i = 0; i < neuronCounts.length; i++) {
            layers[i] = createLayer(neuronCounts[i]);
        }

        network = new SimpleNetwork(layers, new SigmoidFunction());
    }

    private void bindLayers() {

        int i;
        Layer previousLayer, currentLayer, nextLayer;

        //bind first layer
        i = 0;
        currentLayer = network.layers[i];
        nextLayer = network.layers[i + 1];
        for (Neuron neuron : currentLayer.getNeurons()) {
            bindNeuronLinks(neuron, null, nextLayer);
        }

        //bind middle layer
        for (i = 1; i < network.getLayerCount() - 1; i++) {
            previousLayer = network.layers[i - 1];
            currentLayer = network.layers[i];
            nextLayer = network.layers[i + 1];
            for (Neuron neuron : currentLayer.getNeurons()) {
                bindNeuronLinks(neuron, previousLayer, nextLayer);
            }
        }

        //bind last layer
        previousLayer = network.layers[i - 1];
        currentLayer = network.layers[i];
        for (Neuron neuron : currentLayer.getNeurons()) {
            bindNeuronLinks(neuron, previousLayer, null);
        }
    }

    private Layer createLayer(int neuronCount) {
        final Neuron[] neurons = new Neuron[neuronCount];
        for (int i = 0; i < neuronCount; i++) {
            neurons[i] = new Neuron();
        }
        return new Layer(neurons);
    }

    private void bindNeuronLinks(Neuron neuron, Layer previousLayer, Layer nextLayer) {

        Random random = new Random();

        //link neuron to the previous layer
        if (previousLayer != null) {
            final Link[] inputLinks = new Link[previousLayer.size()];
            for (int i = 0; i < previousLayer.size(); i++) {
                inputLinks[i] = new Link(previousLayer.getNeurons()[i], neuron, 0);
            }
            neuron.setBackwardLinks(inputLinks);
        } else neuron.setBackwardLinks(new Link[0]);

        //link neuron to the next layer
        if (nextLayer != null) {
            final Link[] outputLinks = new Link[nextLayer.size()];
            for (int i = 0; i < nextLayer.size(); i++) {
                outputLinks[i] = new Link(neuron, nextLayer.getNeurons()[i], 2 * random.nextFloat() - 1);
            }
            neuron.setForwardLinks(outputLinks);
        } else neuron.setForwardLinks(new Link[0]);
    }
}
