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

public class FlowerHead extends SceneObject {
	
	private static final String VERTEX_SHADER = "vertex.glsl";
	private static final String FRAGMENT_SHADER = "fragment.glsl";
		
	private Vector3f position;
	private float angle; 		// in radians
	private Vector2f scale;
	
	private Shader shader;
	
	private Matrix4f modelMatrix;
	
	private int petals;
	private Vector4f petalColour = new Vector4f(1.0f,1.0f,1.0f,1.0f);

	
	public FlowerHead(int nPetals, Vector4f colour) {
		
		shader = ShaderLibrary.instance.compileShader(VERTEX_SHADER, FRAGMENT_SHADER);		
		position = new Vector3f();
		modelMatrix = new Matrix4f();
		
		petalColour = colour;
	
		// TODO: make the flower head with nPetals petals
	}

	public Vector3f getPosition(Vector3f dest) {
		return position;
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

	public Vector2f getScale() {
		return scale;
	}

	public void setScale(float sx, float sy) {
		scale.x = sx;
		scale.y = sy;
	}
	

	public void draw() {
		shader.enable();

	    // TODO: draw the flower head
		
	}

	public void update(float dt) {
		// TODO: make the flowerhead rotate 
	}
	
}
