package fun.leilabadi.machinelearning.neuralnetwork.functions;

public class ReluFunction implements NormalizationFunction {

    @Override
    public float normalize(float value) {
        return Math.max(0, value);
    }
}
