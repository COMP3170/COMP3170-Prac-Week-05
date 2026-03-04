package comp3170.week5.sceneobjects;

import static org.lwjgl.opengl.GL41.*;

import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import comp3170.GLBuffers;
import comp3170.SceneObject;
import comp3170.Shader;
import comp3170.ShaderLibrary;

public class Flower extends SceneObject {
	
	private static final String VERTEX_SHADER = "vertex.glsl";
	private static final String FRAGMENT_SHADER = "fragment.glsl";
		
	private Vector3f position;
	private float angle; 		// in radians
	private Vector2f scale;
	
	private Shader shader;
	
	private Matrix4f modelMatrix;
	
	private final float STEM_HEIGHT = 1.0f;
	private final float STEM_WIDTH = 0.1f;

	private Vector4f[] stemVertices;
	private int stemVertexBuffer;
	private int[] stemIndices;
	private int stemIndexBuffer;
	private Vector3f stemColour;

	
	public Flower(int nPetals) {
		
		shader = ShaderLibrary.instance.compileShader(VERTEX_SHADER, FRAGMENT_SHADER);		
		position = new Vector3f();
		modelMatrix = new Matrix4f();
	
		// make the stem of the flower

		// vertices for a wxh square with origin at the end
		// 
		//  (-w/2, h)     (w/2, h)		
		//       2-----------3
		//       | \         |
		//       |   \       |
		//       |     \     |
		//       |       \   |
		//       |         \ |
		//       0-----*-----1
		//  (-w/2, 0)     (w/2, 0)	
		
		//@formatter:off
		stemVertices = new Vector4f[] {
			new Vector4f(-STEM_WIDTH / 2,           0, 0, 1),
			new Vector4f( STEM_WIDTH / 2,           0, 0, 1),
			new Vector4f(-STEM_WIDTH / 2, STEM_HEIGHT, 0, 1),
			new Vector4f( STEM_WIDTH / 2, STEM_HEIGHT, 0, 1),
		};
		//@formatter:on
		
		stemVertexBuffer = GLBuffers.createBuffer(stemVertices);
		
	    stemIndices = new int[] {
		    	0, 1, 2,
		    	3, 2, 1,
		};
		    
		stemIndexBuffer = GLBuffers.createIndexBuffer(stemIndices);
		stemColour = new Vector3f(0f, 0.5f, 0f);	// dark green

		// TODO: make the flower head with nPetals petals
	}

	public Vector3f getPosition(Vector3f dest) {
		return dest.set(position);
	}
	
	public void setPosition(Vector3f position) {
		this.position.set(position);
	}

	public float getAngle() {
		return angle;
	}

	public void setAngle(float angle) {
		this.angle = angle;
	}

	public void getScale(Vector2f dest) {
		dest.set(scale);
	}

	public void setScale(float sx, float sy) {
		scale.x = sx;
		scale.y = sy;
	}
	

	public void draw() {
		
		shader.enable();

		// draw the stem
		calcModelMatrix();
		shader.setUniform("u_modelMatrix", modelMatrix);
	    shader.setAttribute("a_position", stemVertexBuffer);
	    shader.setUniform("u_colour", stemColour);	    
	    
	    glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, stemIndexBuffer);
	    glDrawElements(GL_TRIANGLES, stemIndices.length, GL_UNSIGNED_INT, 0);		

	    // TODO: draw the flower head
		
	}

	private void calcModelMatrix() {
		// TODO calculate the model matrix
		
		modelMatrix.identity();
	}

	public void update(float dt) {
		// TODO: make the flower sway and the head rotate 
	}
	
}
