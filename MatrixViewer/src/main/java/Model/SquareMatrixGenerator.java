package Model;

public class SquareMatrixGenerator {
    
    private final int MATRIX_SIZE;
    
    public SquareMatrixGenerator(int MATRIX_SIZE) {
        this.MATRIX_SIZE = MATRIX_SIZE;
    }
    
    public Float[][] generate(float low, float high){
        Float[][] returnMatrix = new Float[MATRIX_SIZE][MATRIX_SIZE];
        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++) {
                float randomValue = (float) (Math.random() * (high - low)) + low;
                returnMatrix[i][j] = randomValue;
            }
        }
        return returnMatrix;
    }
}
