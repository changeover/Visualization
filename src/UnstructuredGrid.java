import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.DoubleSummaryStatistics;

/**
 * Created by andre on 29.09.2017.
 */
public class UnstructuredGrid {
    public static void main(String[] args) throws IOException {
        int pointCount = 70000;
        int gridSize = 100;
        String header = "# vtk DataFile Version 2.0";
        String name = "RegularGrid A. Ott";
        String dataType = "ASCII";
        String dataSet = "DATASET UNSTRUCTURED_GRID";
        String points = "POINTS"+ pointCount+ "float"

        double pointValue[pointCount][gridSize][gridSize][gridSize] =  new double[][][][];
        double takenPoints [pointCount] = new double[];
        pointValue = Attributes.GeneratePoints(pointValue,takenPoints);

        File vtkFile = new File("."+File.separator+"newUnstructVtkFile.vtk");

        vtkFile.createNewFile();
        FileWriter fileWriter = new FileWriter(vtkFile);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String metaData = header+" \n"+name+" \n"+dataType+" \n"+dataSet;
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
