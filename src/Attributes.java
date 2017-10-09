/**
 * Created by andre on 29.09.2017.
 */
public class Attributes {
    public static double[][][] GenerateGrid(double [][][] values, int gridSize ){
        for(int i = 0; i<gridSize;i++){
            for(int j = 0; j<gridSize;j++){
                for(int k = 0; k<gridSize;k++){
                    double x =  i/(((double)gridSize-1)/2) -1;
                    double y =  j/(((double)gridSize-1)/2) -1;
                    double z =  k/(((double)gridSize-1)/2) -1;
                    values[i][j][k] = Compute.ComputePolygon(x,y,z);
                }
            }
        }
        return values;
    }
    public static double[] GeneratePoints(double[] pointValue, double [] takenPoints){

    }
}
