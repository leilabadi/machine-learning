package fun.leilabadi.machinelearning.neuralnetwork.viewmodels;

import java.awt.geom.Ellipse2D;

public class NeuronViewModel {

    private final Ellipse2D neuronShape;
    private LinkViewModel[] links;

    public NeuronViewModel(Ellipse2D neuronShape) {
        this.neuronShape = neuronShape;
    }

    public Ellipse2D getNeuronShape() {
        return neuronShape;
    }

    public LinkViewModel[] getLinks() {
        return links;
    }

    public void setLinks(LinkViewModel[] links) {
        this.links = links;
    }
}
