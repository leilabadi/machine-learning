package fun.leilabadi.machinelearning.neuralnetwork;

public class NeuralNetworkDirector {

    public NeuralNetwork build(NeuralNetworkBuilder builder) {
        builder.build();
        return builder.getResult();
    }
}
