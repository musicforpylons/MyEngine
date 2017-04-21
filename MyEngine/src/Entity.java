import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public abstract class Entity {
	//Fields
	private int x, y;
	private Color color;
	private int[] dimensions = {0, 0};
	private Game game;
	
	//Methods
	public abstract void onUpdate(InputHandler input);
	public abstract void onDraw(Graphics bbg);
	
	/**
	 * Constucts, places, and colors the entity unto the @param game
	 * @param x X-Coord to place entity
	 * @param y Y-Coor to place entity
	 * @param color The Color to draw the entity in
	 * @param game The specific game and canvas this happens in
	 */
	public Entity(int x, int y, Color color, Game game) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.game = game;
	}
	
	/**
	 * Returns a rectangle representative of the location and bounds of the entity
	 * @return the bounding rectangle 
	 */
	public Rectangle getBounds() {
	    return new Rectangle(x, y, this.getDimensions()[0], this.getDimensions()[1]);
	}
	
	//Accessors
	/**
	 * @return the game canvas
	 */
	public Game getGame() {
		return this.game;
	}
	
	/**
	 * @return the Y-coord of the entity
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Sets a new Y-coord to draw entity at
	 * @param y the new Y-Coord
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * @return the X-Coord of the entity
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Sets a new X-coord to draw entity at
	 * @param x the new x-coord
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Return the color the entity is set to be drawn in
	 * @return
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * Silly method for setting an entity's Color to a color of randoml generated rgb values
	 */
	public void randomColor() {
		Random rand = new Random();
		Color randColor = new Color (rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
		this.color = randColor;
	}
	
	/**
	 * Sets the color that the entity is to be drawn in
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	/**
	 * returns an int array that contains the width and height values of the entity
	 * @return the width and height of the entity in an int array
	 */
	public int[] getDimensions() {
		return dimensions;
	}
	
	/**
	 * changes the width or height of the entity
	 * @param i the index of the dimensional array to alter-- 0:width, 1:height
	 * @param v the value to be stored in the dimensional array
	 */
	public void setDimensions(int i, int v) {
		this.dimensions[i] = v;
	}

}
