package by.it.vrublevskii.jd01_07;

import java.util.Arrays;
import java.util.StringJoiner;

public class Vector extends Var {
    private final double[] vector;

    public Vector(double[] vector) {
        this.vector = Arrays.copyOf(vector, vector.length);
    }

    public Vector(Vector otherVector) {
        this.vector = otherVector.vector;
    }

    public Vector(String stringVector) {
        stringVector = stringVector.replaceAll("[{|}]", " ");
        String[] stringArray = stringVector.split(",");
        double[] vectorBuffer = new double[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            vectorBuffer[i] = Double.parseDouble(stringArray[i]);
        }
        this.vector = Arrays.copyOf(vectorBuffer, vectorBuffer.length);
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "{", "}");
        for (double vectorElement : vector) {
            joiner.add(Double.toString(vectorElement));
        }
        return joiner.toString();
    }
}
