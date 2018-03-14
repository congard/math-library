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
public class Vec4 {
	/**
	 * Create vec4
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @return float[] { x, y, z, w }
	 */
	public static float[] createVec4(float x, float y, float z, float w) {
		return new float[] {x, y, z, w};
	}
	
	/**
	 * Create vec4
	 * @param x
	 * @param y
	 * @param z
	 * @return float[] { x, y, z, 1 }
	 */
	public static float[] createVec4(float x, float y, float z) {
		return createVec4(x, y, z, 1);
	}
	
	/**
	 * Create vec4
	 * @param vec3
	 * @param w
	 * @return float[] { x, y, z, w }
	 */
	public static float[] createVec4(float[] vec3, float w) {
		return new float[] {vec3[0], vec3[1], vec3[2], w};
	}
	
	/**
	 * Create vec4
	 * @param vec3
	 * @return float[] { x, y, z, 1 }
	 */
	public static float[] createVec4(float[] vec3) {
		return createVec4(vec3, 1);
	}
	
	/**
	 * Normalize vector ie length == 1
	 * @param vec4
	 */
	public static void normalize(float[] vec4) {
		vec4[0] /= vec4[3];
		vec4[1] /= vec4[3];
		vec4[2] /= vec4[3];
		float length = GMatrix.length(vec4[0], vec4[1], vec4[2]);
		vec4[0] /= length;
		vec4[1] /= length;
		vec4[2] /= length;
		vec4[3] = 1;
	}
}
