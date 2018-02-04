package fun.leilabadi.machinelearning.neuralnetwork.ui;

import fun.leilabadi.machinelearning.neuralnetwork.NeuralNetwork;
import fun.leilabadi.machinelearning.neuralnetwork.NeuronLayer;
import fun.leilabadi.machinelearning.neuralnetwork.viewmodels.LayerViewModel;
import fun.leilabadi.machinelearning.neuralnetwork.viewmodels.LinkViewModel;
import fun.leilabadi.machinelearning.neuralnetwork.viewmodels.NetworkViewModel;
import fun.leilabadi.machinelearning.neuralnetwork.viewmodels.NeuronViewModel;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class ViewModelBuilder {
    private final NeuralNetwork network;

    public ViewModelBuilder(NeuralNetwork network) {
        this.network = network;
    }

    public NetworkViewModel buildNetwork(int width, int height) {

        final double neuronRadius = findNeuronRadius(height);
        final double layerDistance = (double) width / network.getLayers().length;

        final LayerViewModel[] layers = buildLayers(height, neuronRadius, layerDistance);
        addLinks(layers);

        return new NetworkViewModel(layers);
    }

    private LayerViewModel[] buildLayers(double height, double neuronRadius, double layerDistance) {
        double x, y;
        Ellipse2D circle;
        double neuronDistance;
        NeuronViewModel[] neuronViewModels;
        final LayerViewModel[] layers = new LayerViewModel[network.getLayers().length];

        x = layerDistance / 2;
        for (int i = 0; i < network.getLayers().length; i++) {
            NeuronLayer layer = network.getLayers()[i];

            neuronViewModels = new NeuronViewModel[layer.getNeurons().length];
            layers[i] = (new LayerViewModel(neuronViewModels));
            neuronDistance = height / layer.getNeurons().length;

            y = neuronDistance / 2;
            for (int j = 0; j < layer.getNeurons().length; j++) {
                circle = new Ellipse2D.Double(x - neuronRadius, y - neuronRadius, 2 * neuronRadius, 2 * neuronRadius);
                neuronViewModels[j] = new NeuronViewModel(circle);
                y += neuronDistance;
            }
            x += layerDistance;
        }
        return layers;
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

    private void addLinks(LayerViewModel[] layers) {

        LayerViewModel currentLayer, nextLayer;
        NeuronViewModel neuron;
        Line2D line;
        LinkViewModel[] linkViewModels;
        Ellipse2D currentShape, nextShape;
        for (int i = 0; i < layers.length; i++) {
            currentLayer = layers[i];
            for (int j = 0; j < currentLayer.getNeurons().length; j++) {
                neuron = currentLayer.getNeurons()[j];
                if (i < layers.length - 1) {
                    currentShape = neuron.getNeuronShape();
                    nextLayer = layers[i + 1];
                    linkViewModels = new LinkViewModel[nextLayer.getNeurons().length];
                    neuron.setLinks(linkViewModels);
                    for (int k = 0; k < nextLayer.getNeurons().length; k++) {
                        nextShape = nextLayer.getNeurons()[k].getNeuronShape();
                        line = new Line2D.Double(currentShape.getCenterX(), currentShape.getCenterY(), nextShape.getCenterX(), nextShape.getCenterY());
                        linkViewModels[k] = new LinkViewModel(line);
                    }
                } else {
                    neuron.setLinks(new LinkViewModel[0]);
                }
            }
        }
    }
}
