import java.text.DecimalFormat;

/**
 * Created by andre on 29.09.2017.
 */
public class Compute {
    public static double ComputePolygon(double x, double y, double z){
        double val = 0.0;
        double a0 = 0.5;
        double a1 = 1.0;
        double a2 = 0.2;
        double a3 = 0.0;
        double a4 = 0.1;
        double a5 = 0.0;
        double a6 = 0.0;
        double a7 = 0.2;
        double a8 = 0.0;
        double a9 = 0.0;
        val = a0 * Math.pow(x,2) + a1 * Math.pow(y,2) + a2 * Math.pow(z,2) + a3 * x * y + a4 * y * z + a5 * x * z + a6 * x + a7 * y + a8 * z + a9;

        return val;
    }
}
