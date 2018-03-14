package free.lib.congard.ml.graphics;

/**
 * CML (Congard's Math Library) includes tools for working with matrices, vectors, points, etc.
 * Version 1.0
 * Email: dbcongard@gmail.com
 * Telegram: t.me/congard
 * GitHub: github.com/congard
 * @author congard
 *
 */
public class GMatrixTools {
	/**
	 * Convert matrix[][] to matrix[]
	 * @param mat - float[][] matrix
	 * @return float[] matrix
	 */
	public static float[] getMatrixln(float[][] mat) {
		float[] result = new float[mat.length*mat[0].length];
		for (int x = 0; x<mat[0].length; x++) 
			for (int y = 0; y<mat.length; y++) 
				result[y + x * mat.length] = mat[y][x];
		
		return result;
	}
	
	/**
	 * Convert matrix[] to matrix[][]
	 * @param mat - float[] matrix
	 * @param rows - rows count
	 * @return float[][] matrix
	 */
	public static float[][] getMatrix(float[] mat, int rows) {
		if (mat.length % rows != 0) throw new IllegalArgumentException("Rows and columns must be integer\nrows=" + rows + "\ncolumns=" + ((float)mat.length/(float)rows));
		float[][] result = new float[rows][mat.length/rows];
		for (int x = 0; x<result[0].length; x++) 
			for (int y = 0; y<result.length; y++) 
				result[y][x] = mat[y + x * result.length];
		
		return result;
	}
}
