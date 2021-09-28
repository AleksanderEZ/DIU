package Controller;

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
    
    public Float[][] generate(){
        return null;
    } 
}
