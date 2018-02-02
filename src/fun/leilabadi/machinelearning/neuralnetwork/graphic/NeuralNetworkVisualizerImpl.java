package fun.leilabadi.machinelearning.neuralnetwork.graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;

public class NeuralNetworkVisualizerImpl extends JComponent implements NeuralNetworkVisualizer {
    private final NeuralNetworkGraphicCalculator calculator;
    private LayerGraphic[] layerGraphics;
    private BufferedImage buffer;

    public NeuralNetworkVisualizerImpl(NeuralNetworkGraphicCalculator calculator) {
        this.calculator = calculator;
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
        layerGraphics = calculator.calculateNeurons(getWidth(), getHeight());
        repaint();
    }

    private void drawNetwork(Graphics2D graphics) {
        for (LayerGraphic layer : layerGraphics) {
            graphics.setColor(Color.white);
            for (NeuronGraphic item : layer.getNeurons()) {
                graphics.fill(item.getNeuronShape());
                for (Shape line : item.getLinkLines()) {
                    graphics.draw(line);
                }
            }
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
