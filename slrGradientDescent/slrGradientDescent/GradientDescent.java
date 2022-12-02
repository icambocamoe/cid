package slrGradientDescent;

public class GradientDescent {


    public static void main(String[] args) {
        
       // double[] x = {23,26,30,34,43,48,52,57,58};
       // double[] y = {651,762,856,1063,1190,1298,1421,1440,1518};
        
        double[] x = {1,2,3,4,5,6,7,8,9};
        double[] y = {3,6,9,12,15,18,21,24,27};
        double theta0 = 0;
        double theta1 = 0;
        double iter =10000;
        double alpha = 0.00001;
        double m = x.length;
        double Dc = 0;
        double Dm = 0;
        int j =0;
        
        while (j<iter) {   
            Dc=0; //i dont know why this is working
            Dm=0;    
            for (int i = 0; i < m; i++) {   
                                    
                Dc += (-2/m) * ((y[i] - (theta0 + theta1 * x[i])));          
                Dm += (-2/m) * ((y[i] - (theta0 + theta1 * x[i])))*x[i];   
  
            } 
            theta0 = theta0 - alpha * Dc;
            theta1 = theta1 - alpha * Dm;
          j++;
        }
        
        
        System.out.println("theta 0 = " + theta0+" theta 1 = " + theta1);
     
        
    }



}