package state;

import observable.*;

public abstract class AbstractDoorClosedState extends AbstractRefridgeratorState 
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
		int currentTemp = context.getSubjectTemperature().getValue() + 
				context.getDoorClosedLossRate();
		context.setTemperature(currentTemp);
		
		if ( currentTemp > context.getDesiredTemperature().getValue() +
				context.getCompressorStartDifferential() ) {
			return true;
		}
		return false;
	}
}
