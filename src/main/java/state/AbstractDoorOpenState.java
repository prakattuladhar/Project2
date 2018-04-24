package state;


import context.Common;
import observable.*;

/**
 * 
 * @author Colin Quinn
 * @version 0.1
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
		int currentTemp = context.getSubjectTemperature().getValue();
		if ( currentTemp < Common.getRoomTemp() ) {
			context.setTemperature( currentTemp + context.getDoorOpenLossRate() );
		}
	}
}
