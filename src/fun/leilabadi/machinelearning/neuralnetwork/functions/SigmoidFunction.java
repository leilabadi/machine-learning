package fun.leilabadi.machinelearning.neuralnetwork.functions;

public class SigmoidFunction implements NormalizationFunction {

    @Override
    public float normalize(float value) {
        return 1 / (float) (1 + Math.exp(-value));
    }
}
