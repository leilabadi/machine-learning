package fun.leilabadi.machinelearning.neuralnetwork.ui;

import java.awt.*;
import java.awt.geom.Line2D;

public class VisualLink {

    private final Line2D linkShape;
    private Paint paint;

    public VisualLink(Line2D linkShape) {
        this.linkShape = linkShape;
    }

    public VisualLink(Line2D linkShape, Paint paint) {
        this.linkShape = linkShape;
        this.paint = paint;
    }

    public Line2D getLinkShape() {
        return linkShape;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }
}
