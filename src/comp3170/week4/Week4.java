package comp3170.week4;

import org.lwjgl.opengl.GLCapabilities;

import static org.lwjgl.opengl.GL11.glViewport;
import static org.lwjgl.opengl.GL41.*;
import static org.lwjgl.glfw.GLFW.*;


import org.joml.Matrix3f;
import org.joml.Vector2f;
import org.joml.Vector2i;
import org.joml.Vector3f;
import org.joml.Vector4f;


import comp3170.GLBuffers;
import comp3170.OpenGLException;
import comp3170.IWindowListener;
import comp3170.Shader;
import comp3170.ShaderLibrary;
import comp3170.Window;
import comp3170.InputManager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Week4 implements IWindowListener {

	private Window window;
	private Shader shader;
	private int width = 800;
	private int height = 800;
	
	final private File DIRECTORY = new File("src/comp3170/week4"); 
	final private String VERTEX_SHADER = "vertex.glsl";
	final private String FRAGMENT_SHADER = "fragment.glsl";

	private InputManager input;
	private long oldTime;
	
	private Scene scene;

	public Week4()  throws OpenGLException {		
		
		window = new Window("Week 4 prac", width, height, this);
		window.setResizable(true);
	    window.run();
	}

	@Override
	/**
	 * Initialise the Window
	 */
	public void init() {
		// create an input manager to listen for keypresses and mouse events		
		input = new InputManager(window);
		
		new ShaderLibrary(DIRECTORY);
		scene = new Scene();
		
		// initialise oldTime
		oldTime = System.currentTimeMillis();
	}
	
	private Vector2i position = new Vector2i();
		
	private void update() {
		long time = System.currentTimeMillis();
		float deltaTime = (time - oldTime) / 1000f;
		oldTime = time;
		//System.out.println("update: deltaTime = " + deltaTime + "s");
		
		if (input.isMouseDown()) {

			// read the mouse position (in NDC)
			input.getCursorPos(position);
			
			// TODO: Add a new flower at the mouse position
			
		}

		// update all the flowers
		
		scene.update(deltaTime);
		

	}
	
	@Override
	/**
	 * Called when the window is redrawn
	 */
	public void draw() {
		update();
	
		// set the background colour to dirt brown
		glClearColor(87f/255, 60f/255f, 23f/255, 1.0f);	
		glClear(GL_COLOR_BUFFER_BIT);		
		
		scene.draw();
			
		// TODO: set the view and projection matrices
		
		// draw the flowers		
	}

	@Override
	/**
	 * Called when the window is resized
	 */
	public void resize(int width, int height) {
		// record the new width and height
		this.width = width;
		this.height = height;
		glViewport(0,0,width,height);
		
		// TODO: Recalculate the projection matrix when the window is resized
	}

	@Override
	/**
	 * Called when we close of the window 
	 */
	public void close() {
		// nothing to do
	}

	public static void main(String[] args) throws IOException, OpenGLException {
		new Week4();
	}

}
