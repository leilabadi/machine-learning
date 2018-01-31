package fun.leilabadi.machinelearning.neuralnetwork.graphic;

import fun.leilabadi.machinelearning.neuralnetwork.NeuralNetwork;
import fun.leilabadi.machinelearning.neuralnetwork.NeuronLayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class NeuralNetworkVisualizerImpl extends JComponent implements NeuralNetworkVisualizer {
    private final NeuralNetwork network;
    private BufferedImage buffer;

    public NeuralNetworkVisualizerImpl(NeuralNetwork network) {
        this.network = network;
        init();

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                buffer = null;
                init();
            }
        });
    }

    private void init() {
    }

    private void drawNetwork(Graphics2D graphics) {
        graphics.setColor(Color.YELLOW);

        final double layerDistance = (double) getWidth() / network.getLayers().length;

        double x = layerDistance / 2;
        Rectangle2D.Double rectangle;
        for (NeuronLayer layer : network.getLayers()) {
            rectangle = new Rectangle2D.Double(x, 0, 10, getHeight());
            graphics.fill(rectangle);
            x += layerDistance;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (buffer == null) buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);

        Graphics2D g2 = (Graphics2D) buffer.getGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        drawNetwork(g2);

        g.drawImage(buffer, 0, 0, null);
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void showData() {
        repaint();
    }
}
