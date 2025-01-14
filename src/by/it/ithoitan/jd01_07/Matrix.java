package by.it.ithoitan.jd01_07;

import java.util.Arrays;


class Matrix extends Var {
    private final double[][] values;

    public Matrix(double[][] values) {
        this.values = Arrays.copyOf(values, values.length);
    }

    public Matrix(Matrix otherMatrix) {
        values = otherMatrix.values;
    }

    public Matrix(String stringValues) {
        String s = stringValues.replace("{{", "").replace("}}", "").replace("{", "").replace(",", " ");
        String trim = s.trim();
        String[] arr1 = trim.split("}");
        int columns = arr1[0].split(" ").length;
        String s2 = stringValues.replaceAll("[\\W]+", " ").trim();
        String[] arr3 = s2.split(" ");
        double[][] matrix = new double[arr1.length][columns];
        int k = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Double.parseDouble(arr3[k]);
                k++;
            }
        }
        values = matrix;

    }


    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        String delimiter = "";
        for (int i = 0; i < values.length; i++) {
            if (i == 0) {
                out.append("{");
            } else {
                out.append("}, ");
            }

            for (int j = 0; j < values[i].length; j++) {

                if (j == 0) {
                    delimiter = "";
                    out.append("{").append(delimiter).append(values[i][j]);
                } else {
                    out.append(delimiter).append(values[i][j]);
                }
                delimiter = ",";
            }
        }
        out.append("}}");
        return out.toString();
    }
}
