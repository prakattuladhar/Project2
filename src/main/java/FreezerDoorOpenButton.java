import observable.*;

/**
 * 
 * @author Colin Quinn
 *
 */
public class FreezerDoorOpenButton extends GUIButton {
	private static final long serialVersionUID = 1L;
	/**
	 * Button for opening freezer door
	 * 
	 * @param string
	 */
	public FreezerDoorOpenButton(String string) {
		super(string);
	}
	@Override
	public void inform(GUI source) {
		FreezerDoorOpenListenerList.instance().notifyListeners( new DoorOpenEvent(source) );
	}
}
