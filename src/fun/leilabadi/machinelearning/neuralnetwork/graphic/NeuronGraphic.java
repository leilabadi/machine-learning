package fun.leilabadi.machinelearning.neuralnetwork.graphic;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class NeuronGraphic {
    private final Ellipse2D neuronShape;
    private Line2D[] linkLines;

    public NeuronGraphic(Ellipse2D neuronShape) {
        this.neuronShape = neuronShape;
    }

    public Ellipse2D getNeuronShape() {
        return neuronShape;
    }

    public Line2D[] getLinkLines() {
        return linkLines;
    }

    public void setLinkLines(Line2D[] linkLines) {
        this.linkLines = linkLines;
    }
}
