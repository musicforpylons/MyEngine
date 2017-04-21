import java.awt.Color;
import java.awt.Graphics;

public abstract class Paddle extends Entity {
	public static int idGen = 0;
	private int id, score = 0;
	
	/**
	 * Constructs a new paddle by calling Entity's constructor
	 * Additionally assigns a unique paddle id to every instance
	 * @param x the x-coord to initially place the paddle at
	 * @param y the y-coord to initially place the paddle at
	 * @param color the color to draw the entity in
	 * @param game the canvas and game instance to interact with
	 */
	public Paddle(int x, int y, Color color, Game game) {
		super(x, y, color, game);
		id = idGen;
		idGen++;
		setDimensions(0, 10);
		setDimensions(1, 100);
	}
	
	/**
	 * All the draw logic needed for paddle
	 */
	public void onDraw(Graphics bbg) {
		bbg.setColor(getColor());
		bbg.fillRect(getX(), getY(), getDimensions()[0], getDimensions()[1]);
	}
	
	/**
	 * Returns the unique paddle id of the current instance
	 * @return the instance id
	 * 
	 */
	public int getID() {
		return id;
	}
	
	public void incrementScore() {
		this.score++;
	}
	
	/**
	 * Prevents paddles from moving beyond the top and bottom of the screen-----------------
	 */
	public void keepOnScreen() {
		if(getY() < 0) {
			setY(0);
		}
		if(getY() > Game.WINDOW_HEIGHT- getDimensions()[1]) {
			setY(Game.WINDOW_HEIGHT- getDimensions()[1]);
		
		}
	}

}
