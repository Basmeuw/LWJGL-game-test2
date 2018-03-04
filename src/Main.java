import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

//Main classs
public class Main {
	
	public Main(){
		if(!glfwInit()){
			System.err.println("GLFW Failed to initialize!");
			System.exit(1);
		}
		
		long win = glfwCreateWindow(640, 480, "Window", 0, 0);
		
		glfwShowWindow(win);
		
		glfwMakeContextCurrent(win);
		
		GL.createCapabilities();
		
		glEnable(GL_TEXTURE_2D);
		
		float[] vertices = new float[]{
				-0.5f, 0.5f, 0,  // TOP LEFT
				0.5f, 0.5f, 0, 	 // TOP RIGHT
				0.5f, -0.5f, 0,  // BOTTOM RIGHT
				-0.5f, -0.5f, 0, // BOTTOM LEFT
		};
		
		float[] texture = new float[]{
				0,0,
				1,0,
				1,1,
				0,1,
		};

		int[] indices = new int[]{
				0,1,2,
				2,3,0
		};
		
		Model model = new Model(vertices, texture, indices);
		
		
		
		Texture tex = new Texture("./res/Poppetje.png");
		

		
//		glClearColor(1, 1, 1, 1);
		
		
		while(!glfwWindowShouldClose(win)){
			
			if(glfwGetKey(win, GLFW_KEY_ESCAPE) == GL_TRUE){
				glfwSetWindowShouldClose(win, true);
			}
				
			
			glfwPollEvents();
		
			
			glClear(GL_COLOR_BUFFER_BIT);
			
			tex.bind();
			
			model.render();
			
//			glBegin(GL_QUADS);
//			
//				glTexCoord2f(0, 0);
//				glVertex2f(-0.5f, 0.5f);
//				
//				glTexCoord2f(1, 0);
//				glVertex2f(0.5f, 0.5f);
//				
//				glTexCoord2f(1, 1);
//				glVertex2f(0.5f, -0.5f);
//				
//				glTexCoord2f(0, 1);
//				glVertex2f(-0.5f, -0.5f);
//				
//			glEnd();
			
			glfwSwapBuffers(win);
		}
		
		glfwTerminate();
	}
	
	public static void main(String args[]){
		new Main();
	}
}
