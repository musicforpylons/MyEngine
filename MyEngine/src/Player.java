import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Player extends Paddle {
	//Methods
	public Player(int x, int y, Color color, Game game) {
		super(x, y, color, game);
		System.out.println(getX());
		System.out.println(getID());

	}
	
	/**
	 * All player-controlled behaviors are inserted here
	 */
	public void onUpdate(InputHandler input) {
		keepOnScreen();
		if(getID() == 0) {
			if(input.isKeyDown(KeyEvent.VK_W)) {
				setY(getY()	- 5);
			}
		
			if(input.isKeyDown(KeyEvent.VK_S)) {
				setY(getY()	+ 5);
			}
		}
		if(getID() == 1) {
			if(input.isKeyDown(KeyEvent.VK_UP)) {
				setY(getY()	- 5);
			}
		
			if(input.isKeyDown(KeyEvent.VK_DOWN)) {
				setY(getY()	+ 5);
			}
		}
	}
	
}
