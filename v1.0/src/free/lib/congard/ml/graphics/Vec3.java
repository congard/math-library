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
public class Vec3 {
	/**
	 * Create vec3
	 * @param x
	 * @param y
	 * @param z
	 * @return float[] { x, y, z }
	 */
	public static float[] createVec3(float x, float y, float z) {
		return new float[] {x, y, z};
	}
	
	/**
	 * Normalize vector ie length == 1
	 * @param vec3 - float[]
	 */
	public static void normalize(float[] vec3) {
		float length = GMatrix.length(vec3[0], vec3[1], vec3[2]);
		vec3[0] /= length;
		vec3[1] /= length;
		vec3[2] /= length;
	}
}
