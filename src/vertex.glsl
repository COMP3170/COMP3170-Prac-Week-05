#version 410

in vec4 a_position;		// MODEL

uniform mat4 u_modelMatrix;	// MODEL->WORLD

void main() {
	
	vec4 p = u_modelMatrix * a_position;	// WORLD
		
	// TODO: Add view and projection matrices
		
    gl_Position = p;	// NDC 
}

