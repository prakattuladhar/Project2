import observable.*;

/**
 * 
 * @author Colin Quinn
 *
 */
public class FreezerDoorCloseButton extends GUIButton {
	private static final long serialVersionUID = 1L;
	/**
	 * Button for closing freezer door
	 * 
	 * @param string
	 */
	public FreezerDoorCloseButton(String string) {
		super(string);
	}
	@Override
	public void inform(GUI source) {
		FreezerDoorCloseListenerList.instance().notifyListeners( new DoorCloseEvent(source) );
	}
}
