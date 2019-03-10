import java.util.Scanner;

/**
 * Code for computing multiplication of 2 matrices for AP's 2nd homework
 */
public class Matrix {
    int matrix[][];
    private int rows;
    private int columns;

    /**
     * returns the number of current matrix's columns
     */
    public int getColumns() {
        return columns;
    }

    /**
     *
     * @param rows - the number of rows in the matrix
     * @param columns - the number of columns in the matrix
     */
    public Matrix(int rows, int columns) {
        matrix = new int[rows][columns];
        this.rows = rows;
        this.columns = columns;

    }

    public int getRows() {
        return rows;
    }

    public void setValue(int row, int column, int value) {
        matrix[row][column] = value;
    }

    public int getValue(int row, int column) {
        return matrix[row][column];
    }
    /**
     * @param m - the matrix that the multiplication will be operated on
     * @return returns a new Matrix which is m3 = m1 * m2
     */
    public Matrix multiply(Matrix m) {
        if (m.getRows() != this.columns) {
            return null;
        }
        Matrix m3 = new Matrix(rows, m.getColumns());
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < m.getColumns(); j++) {
                for (int k = 0; k < this.getColumns(); k++) {
                    int r1 = this.getValue(i, k);
                    int r2 = m.getValue(k, j);
                    m3.setValue(i, j, m3.getValue(i, j) + r1 * r2);
                }
            }
        }
        return m3;
    }

    /**
     *
     * @param m the m matrix in computation : S = r - [m]
     * @return the m3 which is the result of subtraction : m3 = m1 - m
     */
    public Matrix subtract(Matrix m) {
        if (m.columns != this.columns || this.rows != m.rows) {
            return null;
        }
        Matrix m3 = new Matrix(m.rows, m.columns);
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < m.getColumns(); j++) {
                m3.setValue(i, j, this.getValue(i, j) - m.getValue(i, j));
            }
        }
        return m3;
    }

    public Matrix add(Matrix m) {
        if (m.columns != this.columns || this.rows != m.rows) {
            return null;
        }
        Matrix m3 = new Matrix(m.rows, m.columns);
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < m.getColumns(); j++) {
                m3.setValue(i, j, m.getValue(i, j) + this.getValue(i, j));
            }
        }
        return m3;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                res.append(getValue(i, j)).append(" ");
            }
            res.append("\n");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        Matrix m1 = new Matrix(r1, c1);
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                m1.setValue(i, j, sc.nextInt());
            }
        }
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();

        Matrix m2 = new Matrix(r2, c2);
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                m2.setValue(i, j, sc.nextInt());
            }
        }
        char c = sc.next().charAt(0);
        switch (c) {
            case '+':
                for (int i = 0; i < n; i++) {
                    if (m1 == null)
                        break;
                    m1 = m1.add(m2);
                }
                break;
            case '-':
                for (int i = 0; i < n; i++) {
                    if (m1 == null)
                        break;
                    m1 = m1.subtract(m2);
                }
                break;
            case '*':
                for (int i = 0; i < n; i++) {
                    if (m1 == null)
                        break;
                    m1 = m1.multiply(m2);
                }
                break;
        }
        if (m1 == null){
            System.out.println("ERROR");
        }else
        System.out.println(m1.toString());
    }
}
