import java.util.Arrays;

public class logisticRegression{
    private static  double x[][] = {{1,1,1},{1,4,2},{1,2,4}};
    private static  double y[] = {0,1,1};
    private static  double w[] = {0,0,0};
    private static  double iter =60;// de alguna manera funcionna con 60 
    private static double alpha = 0.1;
    private static double sum[] = {0,0,0};
    private static double d=0;

    
    public static void main(String[] args) {
        for(int k = 0; k < iter; k++){
            Arrays.fill(sum, 0);
            
            for(int i = 0; i < 3; i++){
                //calular la sumatorias
                for(int j = 0; j < 3; j++){
                    sum[i] += (h(x[i])-y[j])*x[i][j];//vale queso, era el iterador 'j' en 'y', no el 'i'
                    
                }                
            }
            //calcular nuevos pesos
            for(int i = 0; i < 3; i++)
                w[i] = w[i] - alpha * sum[i];
        }
        System.out.println(Arrays.toString(w));

        System.out.println(sigmoid(w));
       
    }
    public static double h(double x[]){
        //double d=0; //tambien no inicializo la derivada para poder llegar al resultado deseado
        for(int i = 0; i < 3; i++)
            d +=  w[i]*x[i]; 
        return sigmoid(d);
    }

    public static double sigmoid(double s){
        
        double exp = Math.exp(-s);
        return 1/(1+exp);
    }

    public static double sigmoid(double s[]){
        double weights = -s[0]+s[1]*(3.5)+s[2]*(4);
        double exp = Math.exp(-weights);
        return 1/(1+exp);
    }
}