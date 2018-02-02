package fun.leilabadi.machinelearning.neuralnetwork;

import fun.leilabadi.machinelearning.Constants;

import java.util.Random;

public class DigitRecognitionNeuralNetworkBuilder extends NeuralNetworkBuilder {

    @Override
    public void build() {
        buildDispatchedLayers();
        bindLayers();
    }

    private void buildDispatchedLayers() {
        final NeuronLayer[] layers = new NeuronLayer[Constants.DIGIT_NETWORK_LAYER_COUNT];

        final int[] neuronCounts = new int[]{
                Constants.DIGIT_NETWORK_LAYER1_NEURON_COUNT,
                Constants.DIGIT_NETWORK_LAYER2_NEURON_COUNT,
                Constants.DIGIT_NETWORK_LAYER3_NEURON_COUNT,
                Constants.DIGIT_NETWORK_LAYER4_NEURON_COUNT};

        for (int i = 0; i < neuronCounts.length; i++) {
            layers[i] = createLayer(neuronCounts[i]);
        }

        network = new SimpleNetwork(layers);
    }

    private void bindLayers() {

        NeuronLayer previousLayer, currentLayer, nextLayer;

        //bind first layer
        currentLayer = network.layers[0];
        nextLayer = network.layers[1];
        for (Neuron neuron : currentLayer.getNeurons()) {
            bindNeuronLinks(neuron, null, nextLayer);
        }

        //bind middle layer
        for (int i = 1; i < network.getLayers().length - 1; i++) {
            previousLayer = network.layers[i - 1];
            currentLayer = network.layers[i];
            nextLayer = network.layers[i + 1];
            for (Neuron neuron : currentLayer.getNeurons()) {
                bindNeuronLinks(neuron, previousLayer, nextLayer);
            }
        }

        //bind last layer
        previousLayer = network.layers[1];
        currentLayer = network.layers[2];
        for (Neuron neuron : currentLayer.getNeurons()) {
            bindNeuronLinks(neuron, previousLayer, null);
        }
    }

    private NeuronLayer createLayer(int neuronCount) {
        final Neuron[] neurons = new Neuron[neuronCount];
        for (int i = 0; i < neuronCount; i++) {
            neurons[i] = new Neuron();
        }
        return new NeuronLayer(neurons);
    }

    private void bindNeuronLinks(Neuron neuron, NeuronLayer previousLayer, NeuronLayer nextLayer) {

        Random random = new Random();

        if (previousLayer != null) {
            final Link[] inputLinks = new Link[previousLayer.getNeurons().length];
            for (int i = 0; i < previousLayer.getNeurons().length; i++) {
                inputLinks[i] = new Link(previousLayer.getNeurons()[i], neuron, random.nextFloat());
            }
            neuron.setInputLinks(inputLinks);
        }

        if (nextLayer != null) {
            final Link[] outputLinks = new Link[nextLayer.getNeurons().length];
            for (int i = 0; i < nextLayer.getNeurons().length; i++) {
                outputLinks[i] = new Link(neuron, nextLayer.getNeurons()[i], random.nextFloat());
            }
            neuron.setOutputLinks(outputLinks);
        }
    }
}
