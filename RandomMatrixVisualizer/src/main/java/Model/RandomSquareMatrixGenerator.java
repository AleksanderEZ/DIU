package Model;

public class RandomSquareMatrixGenerator {
    
    private final int MATRIX_SIZE;
    
    public RandomSquareMatrixGenerator(int MATRIX_SIZE) {
        this.MATRIX_SIZE = MATRIX_SIZE;
    }
    
    public Integer[][] generate(float low, float high){
        Integer[][] returnMatrix = new Integer[MATRIX_SIZE][MATRIX_SIZE];
        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++) {
                Integer randomValue =  (int) Math.round((Math.random() * (high - low)) + low);
                returnMatrix[i][j] = randomValue;
            }
        }
        return returnMatrix;
    }
}
