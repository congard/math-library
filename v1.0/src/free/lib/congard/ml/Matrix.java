package free.lib.congard.ml;

/**
 * CML (Congard's Math Library) includes tools for working with matrices, vectors, points, etc.
 * Version 1.0
 * Email: dbcongard@gmail.com
 * Telegram: t.me/congard
 * GitHub: github.com/congard
 * @author congard
 *
 */
public class Matrix {
	/**
	 * Multiplies 2 matrices of the float type. 
	 * Congard code
	 * @param a - first matrix float[][]
	 * @param b - second matrix float[][]
	 * @return a*b
	 */
	public static float[][] multiplyMMf(float[][] a, float[][] b) {
        if (a[0].length != b.length) { // aColumns != bRows
            throw new IllegalArgumentException("A:Rows: " + a[0].length + " did not match B:Columns " + b.length + ".");
        }

        float[][] c = new float[a.length][b[0].length]; // [aRows][bColumns]
        
        for (int i = 0; i < a.length; i++) { // aRow
            for (int j = 0; j < b[0].length; j++) { // bColumn
                for (int k = 0; k < a[0].length; k++) { // aColumn
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return c;
    }
	
	/**
	 * Multiplies 2 matrices of the float type. 
	 * Congard code
	 * @param a - first matrix double[][]
	 * @param b - second matrix double[][]
	 * @return a*b
	 */
	public static double[][] multiplyMMd(double[][] a, double[][] b) {
        if (a[0].length != b.length) { // aColumns != bRows
            throw new IllegalArgumentException("A:Rows: " + a[0].length + " did not match B:Columns " + b.length + ".");
        }

        double[][] c = new double[a.length][b[0].length]; // [aRows][bColumns]
        
        for (int i = 0; i < a.length; i++) { // aRow
            for (int j = 0; j < b[0].length; j++) { // bColumn
                for (int k = 0; k < a[0].length; k++) { // aColumn
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return c;
    }
}
