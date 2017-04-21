import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/** 
 * Makes handling input a lot simpler 
 */ 
public class InputHandler implements KeyListener {
	//Fields
	private boolean tapControl[] = new boolean[256];
	private boolean keys[] = new boolean[256];
	
	//Methods
	/** 
     * Assigns the newly created InputHandler to a Component 
     * @param c Component to get input from 
     */
	public InputHandler(Component c) {
		c.addKeyListener(this);
	}//InputHander
	
	/**
	 * Checks whether a specific key has been pressed and then released
	 * @param keyCode the key to check
	 * @return Whether the key has been hit
	 */
	public boolean isKeyTapped(int keyCode) {
		if(keyCode > 0 && keyCode < 256) {
			if(tapControl[keyCode]) {
				tapControl[keyCode] = false;
				return true;
			}
		}
		return false;
	}
	
	/** 
     * Checks whether a specific key is down 
     * @param keyCode The key to check 
     * @return Whether the key is pressed or not 
     */ 
	public boolean isKeyDown(int keyCode) {
		if(keyCode > 0 && keyCode < 256) {
			return keys[keyCode];
		}
		return false;
		
	}//isKeyDown
	
	/** 
     * Called when a key is pressed while the component is focused 
     * @param e KeyEvent sent by the component 
     */ 
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() > 0 && e.getKeyCode() < 256) {
			keys[e.getKeyCode()] = true;
		}
		
	}//keyPressed

	/** 
     * Called when a key is released while the component is focused 
     * @param e KeyEvent sent by the component 
     */ 
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() > 0 && e.getKeyCode() < 256) {
			keys[e.getKeyCode()] = false;
			tapControl[e.getKeyCode()] =  true;
		}
	}//keyReleased
	
	
	/** 
     * Not used 
     */ 
	public void keyTyped(KeyEvent e) {}

}
