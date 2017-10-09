import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.DoubleSummaryStatistics;

/**
 * Created by andre on 29.09.2017.
 */
public class RegularGrid {
    public static void main(String[] args) throws IOException {
        int gridSize = 100; //this is always going to be a cube
        String header = "# vtk DataFile Version 2.0";
        String name = "RegularGrid A. Ott";
        String dataType = "ASCII";
        String dataSet = "DATASET STRUCTURED_POINTS";
        String dimension = "DIMENSIONS "+gridSize+" "+gridSize+" "+gridSize;
        String origin = "ORIGIN 0.0 0.0 0.0";
        double space = 2.00 / (gridSize - 1.00);
        String spacing = "SPACING "+ Double.toString(space) + " "+ Double.toString(space)+ " "+ Double.toString(space);
        String pointData = "POINT_DATA " + Integer.toString((int)Math.pow(gridSize,3));
        String scalars = "SCALARS scalars float";
        String lookup = "LOOKUP_TABLE default";

        double values [][][] = new double[gridSize][gridSize][gridSize];
        values = Attributes.GenerateGrid(values, gridSize);

        File vtkFile = new File("."+File.separator+"newVtkFile.vtk");

        vtkFile.createNewFile();
        FileWriter fileWriter = new FileWriter(vtkFile);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String metaData = header+" \n"+name+" \n"+dataType+" \n"+dataSet+" \n"+dimension+" \n"+origin+" \n"+spacing+" \n"+pointData+" \n"+scalars+" \n"+lookup+" \n";
        bufferedWriter.write(metaData);
        for(int i = 0; i<gridSize; i++){
            for(int j = 0; j<gridSize; j++){
                for(int k = 0; k<gridSize; k++){
                    DecimalFormat decForm = new DecimalFormat("#.##");
                    String entry = decForm.format(values[i][j][k])+" ";
                    bufferedWriter.write(entry);
                }
                bufferedWriter.write("\n");
            }
        }
        bufferedWriter.close();
    }
}
