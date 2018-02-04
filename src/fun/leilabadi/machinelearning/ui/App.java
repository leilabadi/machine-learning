package fun.leilabadi.machinelearning.ui;

import fun.leilabadi.machinelearning.DigitImageMatrix;
import fun.leilabadi.machinelearning.common.Matrix;
import fun.leilabadi.machinelearning.neuralnetwork.DigitRecognitionNeuralNetworkBuilder;
import fun.leilabadi.machinelearning.neuralnetwork.NeuralNetwork;
import fun.leilabadi.machinelearning.neuralnetwork.NeuralNetworkBuilder;
import fun.leilabadi.machinelearning.neuralnetwork.NeuralNetworkDirector;
import fun.leilabadi.machinelearning.neuralnetwork.ui.NetworkFrame;

public class App {

    public static void main(String[] args) {

        Matrix matrix = new DigitImageMatrix();
        //set sample matrix data

        NeuralNetworkBuilder builder = new DigitRecognitionNeuralNetworkBuilder();
        NeuralNetworkDirector director = new NeuralNetworkDirector();
        NeuralNetwork network = director.build(builder);

        NetworkFrame frame= new NetworkFrame(network);

        /*ActivationAdapter inputAdapter = new MatrixActivationAdapter(matrix);
        network.activate(inputAdapter);

        float[] expectedResult = new float[Constants.DIGIT_COUNT];

        NetworkTrainer trainer = new NetworkTrainer(network, expectedResult);
        trainer.calculateCost();*/
    }
}
