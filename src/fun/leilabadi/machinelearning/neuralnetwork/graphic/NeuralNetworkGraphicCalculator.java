package fun.leilabadi.machinelearning.neuralnetwork.graphic;

import fun.leilabadi.machinelearning.neuralnetwork.NeuralNetwork;
import fun.leilabadi.machinelearning.neuralnetwork.NeuronLayer;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class NeuralNetworkGraphicCalculator {
    private final NeuralNetwork network;

    public NeuralNetworkGraphicCalculator(NeuralNetwork network) {
        this.network = network;
    }

    public LayerGraphic[] calculateNeurons(int width, int height) {

        final double neuronRadius = findNeuronRadius(height);
        final double layerDistance = (double) width / network.getLayers().length;

        double x, y;
        Ellipse2D circle;
        double neuronDistance;
        NeuronGraphic[] neuronGraphics;
        final LayerGraphic[] layerGraphics = new LayerGraphic[network.getLayers().length];

        x = layerDistance / 2;
        for (int i = 0; i < network.getLayers().length; i++) {
            NeuronLayer layer = network.getLayers()[i];

            neuronGraphics = new NeuronGraphic[layer.getNeurons().length];
            layerGraphics[i] = (new LayerGraphic(neuronGraphics));
            neuronDistance = (double) height / layer.getNeurons().length;

            y = neuronDistance / 2;
            for (int j = 0; j < layer.getNeurons().length; j++) {
                circle = new Ellipse2D.Double(x - neuronRadius, y - neuronRadius, 2 * neuronRadius, 2 * neuronRadius);
                neuronGraphics[j] = new NeuronGraphic(circle);
                y += neuronDistance;
            }
            x += layerDistance;
        }

        addLinkLines(layerGraphics);

        return layerGraphics;
    }

    private void addLinkLines(LayerGraphic[] layers) {
        LayerGraphic currentLayer, nextLayer;
        NeuronGraphic neuron;
        Line2D[] lines;
        Ellipse2D currentShape, nextShape;
        for (int i = 0; i < layers.length; i++) {
            currentLayer = layers[i];
            for (int j = 0; j < currentLayer.getNeurons().length; j++) {
                neuron = currentLayer.getNeurons()[j];
                if (i < layers.length - 1) {
                    currentShape = neuron.getNeuronShape();
                    nextLayer = layers[i + 1];
                    lines = new Line2D[nextLayer.getNeurons().length];
                    neuron.setLinkLines(lines);
                    for (int k = 0; k < nextLayer.getNeurons().length; k++) {
                        nextShape = nextLayer.getNeurons()[k].getNeuronShape();
                        lines[k] = new Line2D.Double(currentShape.getCenterX(), currentShape.getCenterY(), nextShape.getCenterX(), nextShape.getCenterY());
                    }
                } else {
                    neuron.setLinkLines(new Line2D[0]);
                }
            }
        }
    }

    private double findNeuronRadius(int height) {
        int maxNeuronCount = 0;
        for (NeuronLayer layer : network.getLayers()) {
            if (layer.getNeurons().length > maxNeuronCount)
                maxNeuronCount = layer.getNeurons().length;
        }
        double neuronDistance = (double) height / maxNeuronCount;
        return 0.8 * Math.min(neuronDistance, 0.05 * height) / 2;
    }
}
