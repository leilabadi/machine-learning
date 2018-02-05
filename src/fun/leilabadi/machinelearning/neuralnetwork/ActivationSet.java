package fun.leilabadi.machinelearning.neuralnetwork;

public class ActivationSet {
    private final float[] data;

    public ActivationSet(float[] data) {
        if (data == null) throw new IllegalArgumentException("Activation array can not be null.");

        this.data = data;
    }

    public float[] getData() {
        return data;
    }

    public int getLength() {
        return data.length;
    }
}
