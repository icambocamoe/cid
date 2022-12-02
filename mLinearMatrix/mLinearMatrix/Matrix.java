package mLinearMatrix;

import java.util.stream.*;
import java.util.Arrays;

public class Matrix {

    private static Dataset d = new Dataset("ad.csv");
    private static double atod[][] = d.getXData();
    
    private static double y[] = d.getYData();
    
    private static double product_matrix[][] = new double[atod.length][atod.length];
    private static Inverse i = new Inverse();

    Matrix(){}

    public static double[][] get2dMatrix() {

        addzero();
        
        return i.invert(productMatrix(transpose(atod),atod.length));
       
    }

    public static double[] get1dMatrix(){
        return productVector(atod,y);
    }

    public static void addzero(){
        for(int i=0;i<atod[0].length;i++){
            atod[0][i]=1;
        }
    }
    
    public static double[][] transpose(double[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        double transpose[][] = new double[columns][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        return transpose;
    }

    public static double[][] productMatrix(double[][] transatod, int size){
        for(int i=0;i<size;i++) {
            for(int j=0;j<transatod[0].length;j++) {
                for(int k=0;k<transatod.length;k++) {
                    product_matrix[i][j] += atod[i][k]*transatod[k][j];
                }
            }
        }
        return product_matrix;
    }

    public static double[] productVector(double[][] matrix, double[] vector){
        return Arrays.stream(matrix)
                .mapToDouble(row -> IntStream.range(0, row.length)
                        .mapToDouble(col -> row[col] * vector[col])
                        .sum())
                .toArray();
    }
    


}
