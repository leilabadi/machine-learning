package fun.leilabadi.machinelearning.neuralnetwork.ui;

import fun.leilabadi.machinelearning.Constants;
import fun.leilabadi.machinelearning.common.Matrix;
import fun.leilabadi.machinelearning.common.SquareMatrix;
import fun.leilabadi.machinelearning.neuralnetwork.MatrixActivationAdapter;
import fun.leilabadi.machinelearning.neuralnetwork.NeuralNetwork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class NetworkFrame extends JFrame {
    private final NeuralNetwork network;
    private Thread thread;
    private boolean run;

    public NetworkFrame(NeuralNetwork network) {
        super("Neural Network");
        this.network = network;
        final NetworkVisualizer visualizer = new NetworkVisualizerImpl(network);

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
            thread = new Thread(this::feedSampleActivations);
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

    private void feedSampleActivations() {
        Matrix matrix;
        Random random = new Random();
        for (int index = 0; index < 20; index++) {
            matrix = new SquareMatrix(Constants.DIGIT_NETWORK_ACTIVATION_MATRIX_SIZE);
            for (int i = 0; i < Constants.DIGIT_NETWORK_ACTIVATION_MATRIX_SIZE; i++) {
                for (int j = 0; j < Constants.DIGIT_NETWORK_ACTIVATION_MATRIX_SIZE; j++) {
                    matrix.setElement(i, j, random.nextFloat());
                }
            }
            network.activate(new MatrixActivationAdapter(matrix));

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
