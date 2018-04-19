import javax.swing.JButton;

/**
 * 
 * @author Colin Quinn
 *
 */
public abstract class GUIButton extends JButton {
	private static final long serialVersionUID = 1L;
	public GUIButton(String string) {
		super(string);
	}
	/**
	 * Used to inform corresponding ListenerList of Events
	 * @param source
	 */
	public abstract void inform(GUI source);
}
