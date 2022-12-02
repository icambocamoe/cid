package mLinearMatrix;

import java.util.Arrays;

public class MLR {
    private static Dataset d = new Dataset();
    
    private static Matrix m = new Matrix();
    
    private static int length=d.getSize();

    private static double inverse_matrix [] [] = new double[length][length];
    
    private static double final_matrix[][] = new double[length][length];

    private static double vector_y [] = new double[length];

    private static double bethas [] = new double[length];

   
    MLR() {}

    public static double[] train() {

        inverse_matrix = m.get2dMatrix();//get inverse matrix to multiply by the vector
        vector_y = m.get1dMatrix();//get y vector to multiply by minverse matix

        return setBethas();
    }



    public static double[] setBethas() {
        for(int i=0;i<length;i++){
            //matriz final
            for(int j=0;j<length;j++){
                final_matrix[i][j]=vector_y[i]*inverse_matrix[i][j];
            }
            //sacar las bethas
            for(int k=0;k<length;k++){
                bethas[k]+=final_matrix[i][k];
            }
        }
        return bethas;
    }
}

