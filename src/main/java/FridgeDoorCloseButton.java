import observable.*;

/**
 * 
 * @author Colin Quinn
 *
 */
public class FridgeDoorCloseButton extends GUIButton {
	private static final long serialVersionUID = 1L;
	/**
	 * Button for closing fridge door
	 * 
	 * @param string
	 */
	public FridgeDoorCloseButton(String string) {
		super(string);
	}
	@Override
	public void inform(GUI source) {
		FridgeDoorCloseListenerList.instance().notifyListeners( new DoorCloseEvent(source) );
	}
}
