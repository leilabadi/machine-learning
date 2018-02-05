package fun.leilabadi.machinelearning.neuralnetwork.ui;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class VisualNeuron {

    private final Ellipse2D neuronShape;
    private Paint paint;
    private VisualLink[] links;

    public VisualNeuron(Ellipse2D neuronShape) {
        this.neuronShape = neuronShape;
    }

    public VisualNeuron(Ellipse2D neuronShape, Paint paint) {
        this.neuronShape = neuronShape;
        this.paint = paint;
    }

    public Ellipse2D getNeuronShape() {
        return neuronShape;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public VisualLink[] getLinks() {
        return links;
    }

    public void setLinks(VisualLink[] links) {
        this.links = links;
    }
}
