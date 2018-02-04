package fun.leilabadi.machinelearning.neuralnetwork.viewmodels;

import java.awt.*;
import java.awt.geom.Line2D;

public class LinkViewModel {

    private final Line2D linkShape;
    private Paint paint;

    public LinkViewModel(Line2D linkShape) {
        this.linkShape = linkShape;
    }

    public LinkViewModel(Line2D linkShape, Paint paint) {
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
