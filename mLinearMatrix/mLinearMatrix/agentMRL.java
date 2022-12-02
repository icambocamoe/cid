//cd C:\Users\jehu\Downloads\JADE-all-4.5.0\jade
//javac -cp lib\jade.jar -d classes C:\Users\jehu\Desktop\cid\java\mLinearMatrix\mLinearMatrix\*.java
//java -cp lib\jade.jar;classes jade.Boot -gui -agents MLR:mLinearMatrix.agentMRL
package mLinearMatrix;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;


public class agentMRL extends Agent {

    private double predictX1 = 0.0;
    private double predictX2 = 0.0;
    private double predictX3 = 0.0;
    private static final MLR train = new MLR();
    
    private static double bethas [] = new double[4];
    protected void setup() {
        System.out.println("Agent " + getLocalName() + " started.");

       
            addBehaviour(new Train());
            predictX1 = 10000;
            predictX2 = 10000;
            predictX3 = 10000;
            System.out.println("x1 = " + predictX1);
            
            System.out.println("x2 = " + predictX2);
            
            System.out.println("x3 = " + predictX3);
     

    }

    private class Train extends OneShotBehaviour{
        
        public void action(){
            bethas=train.train();
        }

        public int onEnd() {
            StringBuilder s = new StringBuilder();
            s.append(String.format("%.2f + %.2fx1+%.2fx2+ %.2fx3", bethas[0], bethas[1], bethas[2], bethas[3]));
            System.out.print("\nRegression equation: " + s.toString());
            double predicted_y = (bethas[1] * predictX1)+(bethas[2] * predictX2)+(bethas[3] * predictX3) + bethas[0];
            System.out.print(String.format("\nx1: %.2f | x2: %.2f | x3: %.2f |predicted y: %.2f\n", predictX1, predictX2, predictX3, predicted_y));
            
            return super.onEnd();
        }
    }


    
}
