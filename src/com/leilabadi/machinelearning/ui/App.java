package com.leilabadi.machinelearning.ui;

import com.leilabadi.machinelearning.Constants;
import com.leilabadi.machinelearning.DigitImageMatrix;
import com.leilabadi.machinelearning.common.Matrix;
import com.leilabadi.machinelearning.neuralnetwork.*;

public class App {

    public static void main(String[] args) {

        Matrix matrix = new DigitImageMatrix();
        //set sample matrix data

        NeuralNetworkBuilder builder = new DigitRecognitionNeuralNetworkBuilder();
        NeuralNetworkDirector director = new NeuralNetworkDirector();
        NeuralNetwork network = director.build(builder);

        NeuralNetworkInputAdapter inputAdapter = new MatrixInputAdapter(matrix);
        network.activate(inputAdapter);

        float[] expectedResult = new float[Constants.DIGIT_COUNT];

        NetworkTrainer trainer = new NetworkTrainer(network, expectedResult);
        trainer.calculateCost();
    }
}
