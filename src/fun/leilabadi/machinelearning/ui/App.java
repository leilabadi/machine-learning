package fun.leilabadi.machinelearning.ui;

import fun.leilabadi.machinelearning.DigitImageMatrix;
import fun.leilabadi.machinelearning.common.Matrix;
import fun.leilabadi.machinelearning.neuralnetwork.DigitRecognitionNeuralNetworkBuilder;
import fun.leilabadi.machinelearning.neuralnetwork.NeuralNetwork;
import fun.leilabadi.machinelearning.neuralnetwork.NeuralNetworkBuilder;
import fun.leilabadi.machinelearning.neuralnetwork.NeuralNetworkDirector;
import fun.leilabadi.machinelearning.neuralnetwork.graphic.NeuralNetworkFrame;
import fun.leilabadi.machinelearning.neuralnetwork.graphic.NeuralNetworkVisualizer;
import fun.leilabadi.machinelearning.neuralnetwork.graphic.NeuralNetworkVisualizerImpl;

public class App {

    public static void main(String[] args) {

        Matrix matrix = new DigitImageMatrix();
        //set sample matrix data

        NeuralNetworkBuilder builder = new DigitRecognitionNeuralNetworkBuilder();
        NeuralNetworkDirector director = new NeuralNetworkDirector();
        NeuralNetwork network = director.build(builder);

        NeuralNetworkFrame frame= new NeuralNetworkFrame(network);

        /*NeuralNetworkInputAdapter inputAdapter = new MatrixInputAdapter(matrix);
        network.activate(inputAdapter);

        float[] expectedResult = new float[Constants.DIGIT_COUNT];

        NetworkTrainer trainer = new NetworkTrainer(network, expectedResult);
        trainer.calculateCost();*/
    }
}
