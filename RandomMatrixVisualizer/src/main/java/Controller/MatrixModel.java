package Controller;

import view.MatrixPanel;
import Model.RandomSquareMatrixGenerator;

public class MatrixModel {
    
    private final int MATRIX_SIZE = 10;
    private float minMatrixValue;
    private float maxMatrixValue;
    private final RandomSquareMatrixGenerator matrixGenerator;
    private Integer[][] matrixToShow;
            
    public MatrixModel() {
        minMatrixValue = 1f;
        maxMatrixValue = 1f;
        matrixGenerator = new RandomSquareMatrixGenerator(MATRIX_SIZE);
    }

    public void setMinMatrixValue(int minMatrixValue) {
        this.minMatrixValue = minMatrixValue;
    }

    public void setMaxMatrixValue(int maxMatrixValue) {
        this.maxMatrixValue = maxMatrixValue;
    }
    
    public void generate(){
        matrixToShow = matrixGenerator.generate(minMatrixValue, maxMatrixValue);
    }
    
    public MatrixPanel getMatrixPanel(int threshold) {
        return new MatrixPanel(matrixToShow, threshold);
    }
}
