package view;

import java.awt.GridLayout;
import javax.swing.JPanel;

public class MatrixPanel extends JPanel{

    private Float[][] matrix;
    private int matrixSize;
            
    public MatrixPanel(Float[][] matrixToShow, int threshold) {
        matrix = matrixToShow;
        matrixSize = matrix.length;
        setLayout(new GridLayout(matrixSize, matrixSize));
        showMatrix(threshold);
    }

    private void showMatrix(int threshold) {
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                if (matrix[i][j] > threshold) {
                    add(new MatrixCell(matrix[i][j].toString()));
                } else {
                    add(new MatrixCell("-"));
                }
            }
        }
    }

}
