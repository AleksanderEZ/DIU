package View;

import java.awt.GridLayout;
import javax.swing.JPanel;

public class MatrixPanel extends JPanel{

    private Float[][] matrix;
    private int matrixSize;
            
    public MatrixPanel(Float[][] matrixToShow) {
        matrix = matrixToShow;
        matrixSize = matrix.length;
        setLayout(new GridLayout(matrixSize, matrixSize));
        showMatrix();
    }

    private void showMatrix() {
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                add(new MatrixCell(matrix[i][j]));
            }
        }
    }

}
