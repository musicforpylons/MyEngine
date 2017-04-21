import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Game extends JFrame {
	//Fields
	public static final int WINDOW_WIDTH = 600;
	public static final int WINDOW_HEIGHT = 400;
	
	private boolean isRunning = true;
	private int fps = 60;
	private BufferedImage backBuffer;
	private Insets insets;
	private InputHandler input;
	
	private EntityHandler entities;
	
	//Methods
	/**
	 * Runner Method
	 */
	public static void main(String str[]) throws IOException{
		Game game = new Game();
		game.run();
		System.exit(0);
	}
	
	/**
	 * Sets up all variables before game runs
	 */
	private void initialize() {
		setTitle("TEST");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

		
		backBuffer = new BufferedImage(WINDOW_WIDTH, WINDOW_HEIGHT, BufferedImage.TYPE_INT_RGB);
		
		insets = getInsets();
		setSize(WINDOW_WIDTH + insets.left + insets.right, WINDOW_HEIGHT + insets.bottom + insets.top);
		
		setInput(new InputHandler(this));
		
		entities = new EntityHandler(this);
		entities.onInitialize();
	}
	

	/**
	 * Starts game and runs it in a loop
	 */
	private void run() {
		initialize();
		
		while(isRunning) {
			long time = System.currentTimeMillis();
			
			update();
			draw();
			
			time = (1000 / fps) - (System.currentTimeMillis() - time); 
	        
	        if(time > 0) {
	        	try {
	        		Thread.sleep(time);
				}
	        	catch (Exception e) {}
	        }
		}
		setVisible(false);
	}
	
	/**
	 * Handles all game logic
	 */
	private void update() {
		entities.onUpdate();
	}
	
	/**
	 * Draws everything to the screen
	 */
	private void draw() {
		Graphics g = getGraphics();
		Graphics bbg = backBuffer.getGraphics();
		
		bbg.setColor(Color.WHITE);
		bbg.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
		
		entities.onDraw(bbg);
		
		g.drawImage(backBuffer, insets.left, insets.top, this);
	}

	public EntityHandler getEntities() {
		return this.entities;
	}
	
	public InputHandler getInput() {
		return input;
	}

	public void setInput(InputHandler input) {
		this.input = input;
	}
	
}