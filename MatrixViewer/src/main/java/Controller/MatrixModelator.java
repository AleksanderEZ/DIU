package Controller;

import View.MatrixPanel;
import Model.SquareMatrixGenerator;

public class MatrixModelator {
    
    private final int MATRIX_SIZE = 10;
    private float minMatrixValue;
    private float maxMatrixValue;
    private final SquareMatrixGenerator matrixGenerator;
            
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
    
    public MatrixPanel generate(){
        Float[][] matrixToShow = matrixGenerator.generate(minMatrixValue, maxMatrixValue);
        return new MatrixPanel(matrixToShow);
    } 
}
