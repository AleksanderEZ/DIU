package Controller;

import view.MatrixPanel;
import Model.SquareMatrixGenerator;

public class MatrixModelator {
    
    private final int MATRIX_SIZE = 10;
    private float minMatrixValue;
    private float maxMatrixValue;
    private final SquareMatrixGenerator matrixGenerator;
    private Float[][] matrixToShow;
            
    public MatrixModelator() {
        minMatrixValue = 1f;
        maxMatrixValue = 1f;
        matrixGenerator = new SquareMatrixGenerator(MATRIX_SIZE);
    }

    public void setMinMatrixValue(float minMatrixValue) {
        this.minMatrixValue = minMatrixValue;
    }

    public void setMaxMatrixValue(float maxMatrixValue) {
        this.maxMatrixValue = maxMatrixValue;
    }
    
    public void generate(){
        matrixToShow = matrixGenerator.generate(minMatrixValue, maxMatrixValue);
    }
    
    public MatrixPanel getMatrixPanel(int threshold) {
        return new MatrixPanel(matrixToShow, threshold);
    }
}
