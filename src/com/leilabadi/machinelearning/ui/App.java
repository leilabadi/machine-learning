package com.leilabadi.machinelearning.ui;

import com.leilabadi.machinelearning.Constants;
import com.leilabadi.machinelearning.DigitMatrix;
import com.leilabadi.machinelearning.common.Matrix;
import com.leilabadi.machinelearning.neuralnetwork.*;

public class App {

    public static void main(String[] args) {

        Matrix matrix = new DigitMatrix();

        NeuralNetworkBuilder builder = new DigitRecognitionNeuralNetworkBuilder();
        NeuralNetworkDirector director = new NeuralNetworkDirector();
        NeuralNetwork network = director.build(builder);

        ActivationSet expectedResult = new ActivationSet(Constants.DIGIT_COUNT);
        //TODO: activate network

        NetworkTrainer trainer = new NetworkTrainer(network, expectedResult);
        trainer.calculateCost();
    }
}
