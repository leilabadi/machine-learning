package fun.leilabadi.machinelearning.neuralnetwork.ui;

import fun.leilabadi.machinelearning.neuralnetwork.Layer;
import fun.leilabadi.machinelearning.neuralnetwork.Link;
import fun.leilabadi.machinelearning.neuralnetwork.NeuralNetwork;
import fun.leilabadi.machinelearning.neuralnetwork.Neuron;

import java.awt.*;

public class DynamicModelUpdater {
    private static DynamicModelUpdater instance;

    private DynamicModelUpdater() {
    }

    static {
        if (instance == null) instance = new DynamicModelUpdater();
    }

    public static DynamicModelUpdater getInstance() {
        return instance;
    }

    public void updateVisualModel(VisualNetwork visualNetwork, NeuralNetwork network) {
        updateActivations(visualNetwork, network);
    }

    private void updateActivations(VisualNetwork visualNetwork, NeuralNetwork network) {
        Layer layer;
        VisualLayer visualLayer;
        Neuron neuron;
        VisualNeuron visualNeuron;
        Link link;
        VisualLink visualLink;
        int colorElement;
        float maxActivation;
        float minWeight, maxWeight;
        for (int i = 0; i < network.getLayerCount(); i++) {
            layer = network.getLayers()[i];
            visualLayer = visualNetwork.getLayers()[i];
            maxActivation = getMaxActivation(layer.getNeurons());
            for (int j = 0; j < layer.size(); j++) {
                neuron = layer.getNeurons()[j];
                visualNeuron = visualLayer.getNeurons()[j];
                colorElement = (int) (255 * neuron.getActivation() / maxActivation);
                visualNeuron.setPaint(new Color(colorElement, colorElement, colorElement));

                if (neuron.getForwardLinks().length > 0) {
                    minWeight = getMinWeight(neuron.getForwardLinks());
                    maxWeight = getMaxWeight(neuron.getForwardLinks());
                    for (int k = 0; k < neuron.getForwardLinks().length; k++) {
                        link = neuron.getForwardLinks()[k];
                        visualLink = visualNeuron.getLinks()[k];
                        colorElement = (int) (255 * (link.getWeight() - minWeight) / (maxWeight - minWeight));
                        visualLink.setPaint(new Color(0, colorElement, 0));
                    }
                }
            }
        }
    }

    private float getMaxActivation(Neuron[] neurons) {
        float max = neurons[0].getActivation();
        for (int i = 1; i < neurons.length; i++) {
            if (neurons[i].getActivation() > max)
                max = neurons[i].getActivation();
        }
        return max;
    }

    private float getMinWeight(Link[] links) {
        float min = links[0].getWeight();
        for (int i = 1; i < links.length; i++) {
            if (links[i].getWeight() < min)
                min = links[i].getWeight();
        }
        return min;
    }

    private float getMaxWeight(Link[] links) {
        float max = links[0].getWeight();
        for (int i = 1; i < links.length; i++) {
            if (links[i].getWeight() > max)
                max = links[i].getWeight();
        }
        return max;
    }
}
