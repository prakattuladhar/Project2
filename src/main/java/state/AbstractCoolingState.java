package state;

import observable.*;

/**
 * 
 * @author Colin
 *
 */
public abstract class AbstractCoolingState extends AbstractRefridgeratorState
	implements DoorOpenListener {

	/**
	 * 
	 */
	public abstract void onDoorOpen(DoorOpenEvent event);
	
	/**
	 * 
	 * @return
	 */
	public boolean changeTemperature() {
		int currentTemp = context.getSubjectTemperature().getValue() - 
				context.getCompressorCoolingRate();
		context.setTemperature(currentTemp);
		if ( currentTemp < context.getDesiredTemperature().getValue() ) {
			return true;
		}
		return false;
	}
}
