import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Ball extends Entity{
	//Fields
	private double velX, velY;
	private double speedMod = 1;

	/**
	 * Constructs a ball using entity's constructor
	 * Additionaly specifies the dimensions of the the ball
	 * @param x The x-coord to initially place the ball at
	 * @param y The y-coord to initially place the ball at
	 * @param color The color in which to draw the ball
	 * @param game The window and game instance to interact with
	 */
	public Ball(int x, int y, Color color, Game game) {
		super(x, y, color, game);
		setDimensions(0, 25);
		setDimensions(1, 25);
		
		velX = -5;
		velY = 1;
	}
	
	/**
	 * Resets the ball, adds to the scoring paddle's score
	 */
	public void sideTouch() {
		//Right Paddle Scores
		if(this.getX() < 0) {
			this.getGame().getEntities().paddle2.incrementScore();
			reset();
		}
		
		//Left Paddle Scores
		if(this.getX() + this.getDimensions()[0] > Game.WINDOW_WIDTH) {
			this.getGame().getEntities().paddle1.incrementScore();
			reset();
		}
		
	}
	 
	public void reset() {
		Random rand = new Random();
		velX = 0;
		velY = 0;
		speedMod = 0;
		setX(Game.WINDOW_WIDTH / 2);
		setY(Game.WINDOW_HEIGHT / 2);
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
		velX = rand.nextInt(3) - 3;
		velY = rand.nextInt(4) - 4;
	}
	
	/**
	 * Checks for bounding box intersections with the two paddle entities present in this object's EntityHandler
	 * also automatically pushes bounce code and score code
	 */
	public void checkCollisions() {
		//Left paddle
		if(this.getBounds().intersects(this.getGame().getEntities().paddle1.getBounds())) {
			velX = - velX;
			this.setX(this.getGame().getEntities().paddle1.getX() + this.getGame().getEntities().paddle1.getDimensions()[0] + 5 );
			changeSpeed(0, .25);
		}
		
		//Right paddle
		if(this.getBounds().intersects(this.getGame().getEntities().paddle2.getBounds())) {
			velX = - velX;
			this.setX(this.getGame().getEntities().paddle2.getX() - this.getDimensions()[0] - 5);
			changeSpeed(0, .25);
		}
	}
	
	/**
	 * Changes speed by a random number within the defined range
	 * @param lo 
	 * @param hi
	 */
	public void changeSpeed(double lo, double hi) {
		Random rand = new Random();
		speedMod += lo + (hi - lo) * rand.nextDouble();


	}

	/**
	 * Bounces the ball off of the top and bottom of the screen
	 */
	public void verticalBounce() {
		if((getY() + getDimensions()[1]) > Game.WINDOW_HEIGHT) {
			setY(Game.WINDOW_HEIGHT - getDimensions()[1]);
			velY = -velY;
		}
		if(getY() < 0) {
			setY(0);
			velY = -velY;
		}
	}
	
	/**
	 * Updates the ball's position, velocity, speed, checks for collisions, ect
	 */
	public void onUpdate(InputHandler input) {
		randomColor();
		
		setX((int)((double)getX() + (int)(velX * speedMod)));
		setY((int)((double)getY() + (int)(velY * speedMod)));
		
	//	horizontalBounce();
		checkCollisions();
		verticalBounce();
		sideTouch();
		
	}

	/**
	 * Draws the ball
	 */
	public void onDraw(Graphics bbg) {
		bbg.setColor(getColor());
		bbg.fillOval(getX(), getY(), getDimensions()[0], getDimensions()[1]);
	}

	/**
	 * returns the Ball's X Velocity
	 * @return the ball's x velocity
	 */
	public double getVelX() {
		return velX;
	}
	

	public void setVelX(double velX) {
		this.velX = velX;
	}

	public double getVelY() {
		return velY;
	}

	public void setVelY(double velY) {
		this.velY = velY;
	}
}
