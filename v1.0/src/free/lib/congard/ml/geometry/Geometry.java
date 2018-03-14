package free.lib.congard.ml.geometry;

/**
 * CML (Congard's Math Library) includes tools for working with matrices, vectors, points, etc.
 * Version 1.0
 * Email: dbcongard@gmail.com
 * Telegram: t.me/congard
 * GitHub: github.com/congard
 * @author congard
 *
 */
public class Geometry {
	public static final int X_AXIS = 0, Y_AXIS = 1, Z_AXIS = 2;
	
	/**
	 * sin function / 0 value fix
	 * @param angleRad - angle in radians
	 * @return double angle sin
	 */
	public static double sin(double angleRad) {
		return Math.toDegrees(angleRad)%360 == 0 ? 0 : Math.sin(angleRad);
	}
	
	/**
	 * cos function / 0 value fix
	 * @param angleRad - angle in radians
	 * @return double angle cos
	 */
	public static double cos(double angleRad) {
		return Math.toDegrees(angleRad)%360 == 90 ? 0 : Math.cos(angleRad);
	}
	
	/**
	 * Returns the rotation angles around the axes between two points
	 * @param p1X - first point x
	 * @param p1Y - first point y
	 * @param p1Z - first point z
	 * @param p2X - second point x
	 * @param p2Y - second point y
	 * @param p2Z - second point z
	 * @return double[] { angle in degrees around x axis, angle in degrees around y axis, angle in degrees around z axis }
	 */
	public static double[] getAngle(double p1X, double p1Y, double p1Z, double p2X, double p2Y, double p2Z) {
		double[] result = new double[3];
		// trng 1 - around z
		double xLength = Math.abs(p2X-p1X);
		double yLength = Math.abs(p2Y-p1Y);
		double zLength = Math.abs(p2Z-p1Z);
		result[2] = Math.atan(yLength/xLength);
		result[1] = Math.atan(zLength/xLength);
		result[0] = Math.atan(yLength/zLength);
		return result;
	}
	
	/**
	 * Returns the rotation angles around the axes between two points
	 * @param p1X - first point x
	 * @param p1Y - first point y
	 * @param p1Z - first point z
	 * @param p2X - second point x
	 * @param p2Y - second point y
	 * @param p2Z - second point z
	 * @return float[] { angle in degrees around x axis, angle in degrees around y axis, angle in degrees around z axis }
	 */
	public static float[] getAnglef(float p1X, float p1Y, float p1Z, float p2X, float p2Y, float p2Z) {
		double[] tmp = getAngle(p1X, p1Y, p1Z, p2X, p2Y, p2Z);
		return new float[]{(float)tmp[0], (float)tmp[1], (float)tmp[2]};
	}

	// ROTATE FUNCTIONS START
	// >> core calc
	/**
	 * Rotates a point about an axis x
	 * @param ox - origin x
	 * @param oy - origin y
	 * @param oz - origin z
	 * @param px - point x
	 * @param py - point y
	 * @param pz - point z
	 * @param sin - angle sin
	 * @param cos - angle cos
	 * @return double[] { x, newY, newZ }
	 */
	public static double[] rotateAroundX(double ox, double oy, double oz, double px, double py, double pz, double sin, double cos) {
		return new double[] {
				px,
				(py - oy) * cos - (pz - oz) * sin + oy, // y
				(py - oy) * sin + (pz - oz) * cos + oz // z
		};
	}
	
	/**
	 * Rotates a point about an axis y
	 * @param ox - origin x
	 * @param oy - origin y
	 * @param oz - origin z
	 * @param px - point x
	 * @param py - point y
	 * @param pz - point z
	 * @param sin - angle sin
	 * @param cos - angle cos
	 * @return double[] { newX, y, newZ }
	 */
	public static double[] rotateAroundY(double ox, double oy, double oz, double px, double py, double pz, double sin, double cos) {
		return new double[] {
				(px - ox) * cos + (pz - oz) * sin + ox, // x
				py, // y
				-(px - ox) * sin + (pz - oz) * cos + oz // z
		};
	}
	
	/**
	 * Rotates a point about an axis z
	 * @param ox - origin x
	 * @param oy - origin y
	 * @param oz - origin z
	 * @param px - point x
	 * @param py - point y
	 * @param pz - point z
	 * @param sin - angle sin
	 * @param cos - angle cos
	 * @return double[] { newX, newY, z }
	 */
	public static double[] rotateAroundZ(double ox, double oy, double oz, double px, double py, double pz, double sin, double cos) {
		return new double[] {
				(px - ox) * cos - (py - oy) * sin + ox, // x
				(px - ox) * sin + (py - oy) * cos + oy, // y
				pz // z
		};
	}
	
	// float
	// BEGIN
	// >>
	/**
	 * Rotates a point about an axis x
	 * @param ox - origin x
	 * @param oy - origin y
	 * @param oz - origin z
	 * @param px - point x
	 * @param py - point y
	 * @param pz - point z
	 * @param sin - angle sin
	 * @param cos - angle cos
	 * @return float[] { x, newY, newZ }
	 */
	public static float[] rotateAroundXf(float ox, float oy, float oz, float px, float py, float pz, float sin, float cos) {
		return new float[] {
				px,
				(py - oy) * cos - (pz - oz) * sin + oy, // y
				(py - oy) * sin + (pz - oz) * cos + oz // z
		};
	}
	
	/**
	 * Rotates a point about an axis y
	 * @param ox - origin x
	 * @param oy - origin y
	 * @param oz - origin z
	 * @param px - point x
	 * @param py - point y
	 * @param pz - point z
	 * @param sin - angle sin
	 * @param cos - angle cos
	 * @return float[] { newX, y, newZ }
	 */
	public static float[] rotateAroundYf(float ox, float oy, float oz, float px, float py, float pz, float sin, float cos) {
		return new float[] {
				(px - ox) * cos + (pz - oz) * sin + ox, // x
				py, // y
				-(px - ox) * sin + (pz - oz) * cos + oz // z
		};
	}
	
	/**
	 * Rotates a point about an axis z
	 * @param ox - origin x
	 * @param oy - origin y
	 * @param oz - origin z
	 * @param px - point x
	 * @param py - point y
	 * @param pz - point z
	 * @param sin - angle sin
	 * @param cos - angle cos
	 * @return float[] { newX, newY, z }
	 */
	public static float[] rotateAroundZf(float ox, float oy, float oz, float px, float py, float pz, float sin, float cos) {
		return new float[] {
				(px - ox) * cos - (py - oy) * sin + ox, // x
				(px - ox) * sin + (py - oy) * cos + oy, // y
				pz // z
		};
	}
	// float
	// END
	// <<
	// <<
	
	/**
	 * Rotates a points about an axis x
	 * @param points - double[] points / Point { x, y, z }
	 * @param ox - origin x
	 * @param oy - origin y
	 * @param oz - origin z
	 * @param sin - angle sin
	 * @param cos - angle cos
	 */
	public static void rotatePointsAroundX(double[] points, double ox, double oy, double oz, double sin, double cos) {
		for (int i = 0; i<points.length; i+=3) {
			double[] tmp = rotateAroundX(ox, oy, oz, points[i], points[i+1], points[i+2], sin, cos);
			points[i] = tmp[0];
			points[i+1] = tmp[1];
			points[i+2] = tmp[2];
		}
	}
	
	/**
	 * Rotates a points about an axis y
	 * @param points - double[] points / Point { x, y, z }
	 * @param ox - origin x
	 * @param oy - origin y
	 * @param oz - origin z
	 * @param sin - angle sin
	 * @param cos - angle cos
	 */
	public static void rotatePointsAroundY(double[] points, double ox, double oy, double oz, double sin, double cos) {
		for (int i = 0; i<points.length; i+=3) {
			double[] tmp = rotateAroundY(ox, oy, oz, points[i], points[i+1], points[i+2], sin, cos);
			points[i] = tmp[0];
			points[i+1] = tmp[1];
			points[i+2] = tmp[2];
		}
	}
	
	/**
	 * Rotates a points about an axis z
	 * @param points - double[] points / Point { x, y, z }
	 * @param ox - origin x
	 * @param oy - origin y
	 * @param oz - origin z
	 * @param sin - angle sin
	 * @param cos - angle cos
	 */
	public static void rotatePointsAroundZ(double[] points, double ox, double oy, double oz, double sin, double cos) {
		for (int i = 0; i<points.length; i+=3) {
			double[] tmp = rotateAroundZ(ox, oy, oz, points[i], points[i+1], points[i+2], sin, cos);
			points[i] = tmp[0];
			points[i+1] = tmp[1];
			points[i+2] = tmp[2];
		}
	}
	
	// float
	// BEGIN
	// >>
	/**
	 * Rotates a points about an axis x
	 * @param points - float[] points / Point { x, y, z }
	 * @param ox - origin x
	 * @param oy - origin y
	 * @param oz - origin z
	 * @param sin - angle sin
	 * @param cos - angle cos
	 */
	public static void rotatePointsAroundXf(float[] points, float ox, float oy, float oz, float sin, float cos) {
		for (int i = 0; i<points.length; i+=3) {
			float[] tmp = rotateAroundXf(ox, oy, oz, points[i], points[i+1], points[i+2], sin, cos);
			points[i] = tmp[0];
			points[i+1] = tmp[1];
			points[i+2] = tmp[2];
		}
	}
	
	/**
	 * Rotates a points about an axis y
	 * @param points - float[] points / Point { x, y, z }
	 * @param ox - origin x
	 * @param oy - origin y
	 * @param oz - origin z
	 * @param sin - angle sin
	 * @param cos - angle cos
	 */
	public static void rotatePointsAroundYf(float[] points, float ox, float oy, float oz, float sin, float cos) {
		for (int i = 0; i<points.length; i+=3) {
			float[] tmp = rotateAroundYf(ox, oy, oz, points[i], points[i+1], points[i+2], sin, cos);
			points[i] = tmp[0];
			points[i+1] = tmp[1];
			points[i+2] = tmp[2];
		}
	}
	
	/**
	 * Rotates a points about an axis z
	 * @param points - float[] points / Point { x, y, z }
	 * @param ox - origin x
	 * @param oy - origin y
	 * @param oz - origin z
	 * @param sin - angle sin
	 * @param cos - angle cos
	 */
	public static void rotatePointsAroundZf(float[] points, float ox, float oy, float oz, float sin, float cos) {
		for (int i = 0; i<points.length; i+=3) {
			float[] tmp = rotateAroundZf(ox, oy, oz, points[i], points[i+1], points[i+2], sin, cos);
			points[i] = tmp[0];
			points[i+1] = tmp[1];
			points[i+2] = tmp[2];
		}
	}
	// float
	// END
	// <<
	
	/**
	 * Rotates a points about an axes xyz in the sequence
	 * @param points - double[] points / Point { x, y, z }
	 * @param origin - double[] origin / Point { x, y, z }
	 * @param sequence - int[] sequence / Sequence { n0_AXIS, n1_AXIS, n2_AXIS }
	 * @param xAxisSin - angle around x sin
	 * @param xAxisCos - angle around x cos
	 * @param yAxisSin - angle around y sin
	 * @param yAxisCos - angle around y cos
	 * @param zAxisSin - angle around z sin
	 * @param zAxisCos - angle around z cos
	 */
	public static void rotatePointsAroundXYZ(double[] points, double[] origin, int[] sequence, 
			double xAxisSin, double xAxisCos, 
			double yAxisSin, double yAxisCos, 
			double zAxisSin, double zAxisCos) {
		
		for (short i = 0; i<3; i++) {
			if (sequence[i] == X_AXIS) rotatePointsAroundX(points, origin[0], origin[1], origin[2], xAxisSin, xAxisCos);
			else if (sequence[i] == Y_AXIS) rotatePointsAroundY(points, origin[0], origin[1], origin[2], yAxisSin, yAxisCos);
			else if (sequence[i] == Z_AXIS) rotatePointsAroundZ(points, origin[0], origin[1], origin[2], zAxisSin, zAxisCos);
		}
	}
	
	
	// float
	// BEGIN
	// >>
	/**
	 * Rotates a points about an axes xyz in the sequence
	 * @param points - float[] points / Point { x, y, z }
	 * @param origin - float[] origin / Point { x, y, z }
	 * @param sequence - int[] sequence / Sequence { n0_AXIS, n1_AXIS, n2_AXIS }
	 * @param xAxisSin - angle around x sin
	 * @param xAxisCos - angle around x cos
	 * @param yAxisSin - angle around y sin
	 * @param yAxisCos - angle around y cos
	 * @param zAxisSin - angle around z sin
	 * @param zAxisCos - angle around z cos
	 */
	public static void rotatePointsAroundXYZf(float[] points, float[] origin, int[] sequence, 
			float xAxisSin, float xAxisCos, 
			float yAxisSin, float yAxisCos, 
			float zAxisSin, float zAxisCos) {
		
		for (short i = 0; i<3; i++) {
			if (sequence[i] == X_AXIS) rotatePointsAroundXf(points, origin[0], origin[1], origin[2], xAxisSin, xAxisCos);
			else if (sequence[i] == Y_AXIS) rotatePointsAroundYf(points, origin[0], origin[1], origin[2], yAxisSin, yAxisCos);
			else if (sequence[i] == Z_AXIS) rotatePointsAroundZf(points, origin[0], origin[1], origin[2], zAxisSin, zAxisCos);
		}
	}
	// float
	// END
	// <<
	// <<
	// ROTATE FUNCTIONS END
}
