package state;


import context.Common;
import observable.*;

/**
 * 
 * @author Colin Quinn
 * @version 1.0
 * 
 * This class represents a the state of a refridgeration unit with the door open
 * and compressor off.  The unit will warm up until it reaches room temperature.
 *
 */
public abstract class AbstractDoorOpenState extends AbstractRefridgeratorState
	implements DoorCloseListener {
	
	/**
	 * Handle door closing event
	 */
	public abstract void onDoorClose(DoorCloseEvent event);

	/**
	 * Temperature increases until room temperature has been reached
	 */
	@Override
	public void onClockTick() {
		int lossRate = context.getDoorOpenLossRate();
		
		// Check amount of seconds
		counter++;
		if (counter % lossRate == 0) {
			counter = 0;
			int currentTemp = context.getSubjectTemperature().getValue();
			// Change temperature if less than room temperature
			if ( currentTemp < Common.getRoomTemp() ) {
				currentTemp++;
				context.setTemperature(currentTemp);
			}
		}
	}
}
