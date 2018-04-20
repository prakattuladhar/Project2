import observable.*;

public class FridgeDoorOpenButton extends GUIButton {
	private static final long serialVersionUID = 1L;
	/**
	 * Button for opening fridge door
	 * 
	 * @param string
	 */
	public FridgeDoorOpenButton(String string) {
		super(string);
	}
	@Override
	public void inform(GUI source) {
		FridgeDoorOpenListenerList.instance().notifyListeners( new DoorOpenEvent(source) );
	}
}
