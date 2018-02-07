package fun.leilabadi.machinelearning.neuralnetwork.ui;

import fun.leilabadi.machinelearning.neuralnetwork.Layer;
import fun.leilabadi.machinelearning.neuralnetwork.NeuralNetwork;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class StaticModelGenerator {
    private final NeuralNetwork network;

    public StaticModelGenerator(NeuralNetwork network) {
        this.network = network;
    }

    public VisualNetwork generateNetwork(int width, int height) {

        final double neuronRadius = findNeuronRadius(height);
        final double layerDistance = (double) width / network.getLayerCount();

        final VisualLayer[] layers = generateLayers(height, neuronRadius, layerDistance);
        generateLinks(layers);

        return new VisualNetwork(layers);
    }

    private VisualLayer[] generateLayers(double height, double neuronRadius, double layerDistance) {
        double x, y;
        Ellipse2D circle;
        double neuronDistance;
        VisualNeuron[] visualNeurons;
        final Paint paint = Color.WHITE;
        final VisualLayer[] layers = new VisualLayer[network.getLayerCount()];

        x = layerDistance / 2;
        for (int i = 0; i < network.getLayerCount(); i++) {
            Layer layer = network.getLayers()[i];

            visualNeurons = new VisualNeuron[layer.size()];
            layers[i] = (new VisualLayer(visualNeurons));
            neuronDistance = height / layer.size();

            y = neuronDistance / 2;
            for (int j = 0; j < layer.size(); j++) {
                circle = new Ellipse2D.Double(x - neuronRadius, y - neuronRadius, 2 * neuronRadius, 2 * neuronRadius);
                visualNeurons[j] = new VisualNeuron(circle, paint);
                y += neuronDistance;
            }
            x += layerDistance;
        }
        return layers;
    }

    private void generateLinks(VisualLayer[] layers) {

        VisualLayer currentLayer, nextLayer;
        VisualNeuron neuron;
        VisualLink[] visualLinks;
        Ellipse2D currentShape, nextShape;
        Line2D line;
        final Paint paint = Color.green;
        for (int i = 0; i < layers.length; i++) {
            currentLayer = layers[i];
            for (int j = 0; j < currentLayer.size(); j++) {
                neuron = currentLayer.getNeurons()[j];
                if (i < layers.length - 1) {
                    currentShape = neuron.getNeuronShape();
                    nextLayer = layers[i + 1];
                    visualLinks = new VisualLink[nextLayer.size()];
                    neuron.setLinks(visualLinks);
                    for (int k = 0; k < nextLayer.size(); k++) {
                        nextShape = nextLayer.getNeurons()[k].getNeuronShape();
                        line = new Line2D.Double(currentShape.getCenterX(), currentShape.getCenterY(), nextShape.getCenterX(), nextShape.getCenterY());
                        visualLinks[k] = new VisualLink(line, paint);
                    }
                } else {
                    neuron.setLinks(new VisualLink[0]);
                }
            }
        }
    }

    private double findNeuronRadius(int height) {
        int maxNeuronCount = 0;
        for (Layer layer : network.getLayers()) {
            if (layer.size() > maxNeuronCount)
                maxNeuronCount = layer.size();
            ;
        }
        double neuronDistance = (double) height / maxNeuronCount;
        return 0.8 * Math.min(neuronDistance, 0.05 * height) / 2;
    }
}
