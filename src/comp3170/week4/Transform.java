package comp3170.week4;

import org.joml.Matrix4f;
import static comp3170.Math.TAU;
/**
 * Methods to create 2D transformation matrices for translation, rotation and scaling.
 * 
 * Note: All of these methods assume a matrix has already been allocated, and sets the entries of that matrix.
 * To use them, you will need to allocate a matrix first, as:
 * 
 * Matrix4f matrix = new Matrix4f();
 * Transform.rotationMatrix(Transform.TAU / 4, matrix);	// M = R(90)
 * 
 * It is generally good practice to allocate the matrices you need at initialisation 
 * then re-use them from frame to frame, rather than allocating new matrices every frame.
 * 
 * Note that although we are using Mat4fs, we will not be allocating anything to any of the z values, or the k column, as there is no depth.
 * The use of Mat4s here is to get you used to the functionality of them for when we move to 3D.
 * @author malcolmryan, update by cameronedmond
 */
public class Transform {
	
	/**
	 * Set the destination matrix to a translation matrix.
	 * Note the destination matrix must already be allocated. 
	 * 
	 * @param tx	Offset in the x direction
	 * @param ty	Offset in the y direction
	 * @param dest	Destination matrix to write into
	 * @return
	 */
	
	public static Matrix4f translationMatrix(float tx, float ty, Matrix4f dest) {
		// clear the matrix to the identity matrix
		dest.identity();
		
		//     [ 1 0 0 tx ]
		// T = [ 0 1 0 ty ]
		//	   [ 0 0 0  0 ]
		//     [ 0 0 0  1 ]
		
		dest.m30(tx);
		dest.m31(ty);
		
		return dest;
	}
	
	/**
	 * Set the destination matrix to a rotation matrix.
	 * Note the destination matrix must already be allocated. 
	 *
	 * @param angle	Angle of rotation (in radians)
	 * @param dest	Destination matrix to write into
	 * @return
	 */

	public static Matrix4f rotationMatrix(float angle, Matrix4f dest) {
		
		// clear the matrix to the identity matrix
		dest.identity();
		
		//     [ cos(a)  -sin(a)  0  0 ]
		// R = [ sin(a)   cos(a)  0  0 ]
		//     [   0        0     0  0 ]
		//     [   0        0     0  1 ]
		
		float s = (float) Math.sin(angle);
		float c = (float) Math.cos(angle);
		
		dest.m00(c);
		dest.m01(s);
		dest.m10(-s);
		dest.m11(c);
		
		return dest;
	}

	/**
 	 * Set the destination matrix to a scale matrix.
	 * Note the destination matrix must already be allocated. 
	 *
	 * @param sx	Scale factor in x direction
	 * @param sy	Scale factor in y direction
	 * @param dest	Destination matrix to write into
	 * @return
	 */
	
	public static Matrix4f scaleMatrix(float sx, float sy, Matrix4f dest) {
		
		// clear the matrix to the identity matrix
		dest.identity();
		
		//     [ sx  0  0  0 ]
		// S = [  0 sy  0  0 ]
		//     [  0  0  0  0 ]
		//     [  0  0  0  1 ]
		
		dest.m00(sx);
		dest.m11(sy);
		
		return dest;
	}

}
