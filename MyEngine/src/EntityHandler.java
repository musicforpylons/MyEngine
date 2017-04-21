import java.awt.Color;
import java.awt.Graphics;

public class EntityHandler {
	Game game;
	Paddle paddle1, paddle2;
	Ball ball;
	
	/**
	 * Constructs EntityHandler
	 * @param game Game object to interact with and Game frame to draw to
	 */
	public EntityHandler(Game game) {
		this.game = game;
	}
	
	/**
	 * Adds all entities required at the start of game
	 */
	public void onInitialize() {
		paddle1 = new Player(Game.WINDOW_WIDTH/16, Game.WINDOW_HEIGHT / 2, Color.BLUE, game);
		paddle2 = new Player(((Game.WINDOW_WIDTH*15/16) ), Game.WINDOW_HEIGHT / 2, Color.BLUE, game); 
		ball = new Ball(Game.WINDOW_WIDTH/2, Game.WINDOW_HEIGHT / 2, Color.RED, game);
	}
	
	/**
	 * Collectively steps through all entities' update logic
	 */
	public void onUpdate() {
		this.paddle1.onUpdate(game.getInput());
		this.paddle2.onUpdate(game.getInput());
		this.ball.onUpdate(game.getInput());
	}
	
	/**
	 * Collectively steps through all entities' draw logic
	 * @param bbg
	 */
	public void onDraw(Graphics bbg) {
		paddle1.onDraw(bbg);
		paddle2.onDraw(bbg);
		ball.onDraw(bbg);
	}
	
}
