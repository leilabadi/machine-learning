package fun.leilabadi.machinelearning.neuralnetwork.ui;

import fun.leilabadi.machinelearning.neuralnetwork.viewmodels.LayerViewModel;
import fun.leilabadi.machinelearning.neuralnetwork.viewmodels.LinkViewModel;
import fun.leilabadi.machinelearning.neuralnetwork.viewmodels.NetworkViewModel;
import fun.leilabadi.machinelearning.neuralnetwork.viewmodels.NeuronViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;

public class NetworkVisualizerImpl extends JComponent implements NetworkVisualizer {
    private final ViewModelBuilder viewModelBuilder;
    private NetworkViewModel networkViewModel;
    private BufferedImage buffer;

    public NetworkVisualizerImpl(ViewModelBuilder viewModelBuilder) {
        this.viewModelBuilder = viewModelBuilder;
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
        networkViewModel = viewModelBuilder.buildNetwork(getWidth(), getHeight());
        repaint();
    }

    private void drawNetwork(Graphics2D graphics) {
        for (LayerViewModel layer : networkViewModel.getLayers()) {
            for (NeuronViewModel item : layer.getNeurons()) {
                graphics.setColor(Color.white);
                graphics.fill(item.getNeuronShape());
                for (LinkViewModel link : item.getLinks()) {
                    graphics.setPaint(link.getPaint());
                    graphics.draw(link.getLinkShape());
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
    public void showActivation() {
        repaint();
    }
}
