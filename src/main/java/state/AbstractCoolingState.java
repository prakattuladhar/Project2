package state;

import observable.*;

/**
 * 
 * @author Colin Quinn
 * @version 1.0
 * 
 * This class represents a the state of a refridgeration unit with the compressor
 * running so it is cooling
 *
 */
public abstract class AbstractCoolingState extends AbstractRefridgeratorState
	implements DoorOpenListener {

	/**
	 * Actions to be performed when door is open
	 */
	public abstract void onDoorOpen(DoorOpenEvent event);
	
	/**
	 * Changes the temperature and checks to see if desired temperature has been reached
	 * 
	 * @return true if desired temperature reached, false otherwise
	 */
	public boolean changeTemperature() {
		int coolingRate = context.getCompressorCoolingRate();
		
		// Check amount of seconds
		counter++;
		if (counter % coolingRate == 0) {
			counter = 0;
			// Change temperature
			int currentTemp = context.getSubjectTemperature().getValue();
			currentTemp--;
			context.setTemperature(currentTemp);
			// Check against temperature
			if (
					currentTemp <= context.getDesiredTemperature().getValue()
					- context.getCompressorStartDifferential()
			) {
				// Desired temperature reached
				return true;
			}
		}
		// Desired temperature not reached
		return false;
	}
}
