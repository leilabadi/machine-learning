package fun.leilabadi.machinelearning.neuralnetwork.graphic;

import fun.leilabadi.machinelearning.neuralnetwork.NeuralNetwork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NeuralNetworkFrame extends JFrame {
    private NeuralNetworkVisualizer visualizer;
    private Thread thread;
    private boolean run;

    public NeuralNetworkFrame(NeuralNetwork network) {
        super("Neural Network");

        NeuralNetworkGraphicCalculator calculator = new NeuralNetworkGraphicCalculator(network);
        visualizer = new NeuralNetworkVisualizerImpl(calculator);

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

        run();
    }

    protected void run() {
        if (!run) {
            if (thread != null) {
                try {
                    thread.join();
                } catch (InterruptedException ignored) {
                }
            }

            run = true;
            thread = new Thread(() -> {
                visualizer.showData();
            });
            thread.start();
        }
    }

    protected void onWindowClosing() {
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
