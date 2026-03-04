package comp3170.week5;

import org.lwjgl.opengl.GLCapabilities;
import static org.lwjgl.opengl.GL41.*;

import java.util.ArrayList;
import java.util.List;

import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector3f;

import comp3170.GLBuffers;
import comp3170.OpenGLException;
import comp3170.IWindowListener;
import comp3170.Shader;
import comp3170.ShaderLibrary;
import comp3170.Window;
import comp3170.SceneObject;

import comp3170.week5.sceneobjects.*;

public class Scene extends SceneObject {
	
	private List<Flower> flowers;

	
	public Scene() {
		
		// initialise flowers
		flowers = new ArrayList<Flower>();
		
		Flower flower = new Flower(6);
		flowers.add(flower);
		
	}

	public void draw() {

		for (Flower flower : flowers) {
			flower.draw();
		}
		// draw the stem
	

	    // TODO: draw the flower head
		
	}


	public void update(float dt) {
		
		for (Flower flower : flowers) {
			flower.update(dt);
		}
		// TODO: make the flower sway and the head rotate 
	}
	
}
