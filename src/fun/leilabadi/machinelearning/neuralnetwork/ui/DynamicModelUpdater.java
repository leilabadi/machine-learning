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
        for (int i = 0; i < network.getLayerCount() - 1; i++) {
            layer = network.getLayers()[i];
            visualLayer = visualNetwork.getLayers()[i];
            for (int j = 0; j < layer.size(); j++) {
                neuron = layer.getNeurons()[j];
                visualNeuron = visualLayer.getNeurons()[j];
                colorElement = (int) (256 * neuron.getActivation());
                visualNeuron.setPaint(new Color(colorElement, colorElement, colorElement));
                for (int k = 0; k < neuron.getOutputLinks().length; k++) {
                    link = neuron.getOutputLinks()[k];
                    visualLink = visualNeuron.getLinks()[k];
                    visualLink.setPaint(new Color(0, (int) (256 * link.getWeight()), 0));
                }
            }
        }
    }
}
