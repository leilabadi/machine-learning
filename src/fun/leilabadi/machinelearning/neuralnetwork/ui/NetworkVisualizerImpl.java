package fun.leilabadi.machinelearning.neuralnetwork.ui;

import fun.leilabadi.machinelearning.neuralnetwork.NeuralNetwork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;

public class NetworkVisualizerImpl extends JComponent implements NetworkVisualizer {
    private final StaticModelGenerator staticModelGenerator;
    private final NeuralNetwork network;
    private VisualNetwork visualNetwork;
    private BufferedImage buffer;

    public NetworkVisualizerImpl(NeuralNetwork network) {
        this.network = network;
        this.staticModelGenerator = new StaticModelGenerator(network);
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
        visualNetwork = staticModelGenerator.generateNetwork(getWidth(), getHeight());
        repaint();
    }

    private void drawNetwork(Graphics2D graphics) {
        for (VisualLayer layer : visualNetwork.getLayers()) {
            for (VisualNeuron neuron : layer.getNeurons()) {
                graphics.setColor(Color.white);
                graphics.draw(neuron.getNeuronShape());
            }
        }
    }

    private void drawActivations(Graphics2D graphics) {
        DynamicModelUpdater.getInstance().updateVisualModel(visualNetwork, network);

        VisualLayer layer;
        for (int i = 0; i < visualNetwork.getLayerCount(); i++) {
            layer = visualNetwork.getLayers()[i];
            for (VisualNeuron neuron : layer.getNeurons()) {
                for (VisualLink link : neuron.getLinks()) {
                    graphics.setPaint(link.getPaint());
                    graphics.draw(link.getLinkShape());
                }

                graphics.setPaint(neuron.getPaint());
                graphics.fill(neuron.getNeuronShape());
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (buffer == null) buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);

        Graphics2D g2 = (Graphics2D) buffer.getGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        drawActivations(g2);
        drawNetwork(g2);

        g.drawImage(buffer, 0, 0, null);
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void showActivation() {
        repaint();
    }
}
