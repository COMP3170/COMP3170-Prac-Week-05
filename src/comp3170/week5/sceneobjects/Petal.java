package comp3170.week5.sceneobjects;

import static comp3170.Math.TAU;
import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL11.glDrawElements;
import static org.lwjgl.opengl.GL15.GL_ELEMENT_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL41.*;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import comp3170.GLBuffers;
import comp3170.SceneObject;
import comp3170.Shader;
import comp3170.ShaderLibrary;

public class Petal extends SceneObject {
	
	private static final String VERTEX_SHADER = "vertex.glsl";
	private static final String FRAGMENT_SHADER = "fragment.glsl";
		
	private Shader shader;

	private Vector3f colour;
	
	private Vector4f[] vertices = new Vector4f[4];
	private int vertexBuffer;
	
	private int[] indices;
	private int indexBuffer;

	
	public Petal(float rot, float outerRad, float innerRad, Vector3f col) {
		
		shader = ShaderLibrary.instance.compileShader(VERTEX_SHADER, FRAGMENT_SHADER);		
		
		vertices[0] = new Vector4f(0.0f,0.0f,0.f,1.0f);
		vertices[1] = new Vector4f(0.0f,outerRad,0.0f,1.0f);
		vertices[2] = new Vector4f(0.0f,innerRad,0.0f,1.0f);
		vertices[3] = new Vector4f(0.0f,innerRad,0.0f,1.0f);
		
		Matrix4f rotation = new Matrix4f();
		rotation.rotationZ(rot);
		vertices[2].mul(rotation);
		rotation.rotationZ(-rot);
		vertices[3].mul(rotation);
		
		vertexBuffer = GLBuffers.createBuffer(vertices);
		
		indices = new int[] {
				0, 2, 1,
				0, 1, 3,
		};
		indexBuffer = GLBuffers.createIndexBuffer(indices);
		
		colour = col;
	}

	public void drawSelf(Matrix4f mvpMatrix) {
		shader.enable();
		
		shader.setUniform("u_mvpMatrix", mvpMatrix);
	    shader.setAttribute("a_position", vertexBuffer);
	    shader.setUniform("u_colour", colour);	    
	    
	    glPolygonMode( GL_FRONT_AND_BACK, GL_FILL );
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, indexBuffer);
		glDrawElements(GL_TRIANGLES, indices.length, GL_UNSIGNED_INT, 0);
		
	}
}
