package fun.leilabadi.machinelearning.neuralnetwork.ui;

import fun.leilabadi.machinelearning.neuralnetwork.ActivationListener;
import fun.leilabadi.machinelearning.neuralnetwork.NeuralNetwork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NetworkFrame extends JFrame {
    private final NetworkVisualizer visualizer;
    private Thread thread;
    private boolean run;

    public NetworkFrame(NeuralNetwork network) {
        super("Neural Network");

        ViewModelBuilder viewModelBuilder = new ViewModelBuilder(network);
        visualizer = new NetworkVisualizerImpl(viewModelBuilder);

        setSize(800, 600);
        setLayout(new BorderLayout());
        setVisible(true);
        add((JComponent) visualizer, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                onWindowClosing();
            }
        });

        network.setActivationListener(visualizer::showActivation);

        run();
    }

    private void run() {
        if (!run) {
            if (thread != null) {
                try {
                    thread.join();
                } catch (InterruptedException ignored) {
                }
            }

            run = true;
            thread = new Thread(visualizer::showActivation);
            thread.start();
        }
    }

    private void onWindowClosing() {
        if (thread != null) {
            try {
                thread.join();
            } catch (InterruptedException ignored) {
            }
        }

        thread = null;
        System.exit(0);
    }
}
