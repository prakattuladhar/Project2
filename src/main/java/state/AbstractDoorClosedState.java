package state;

import observable.*;

/**
 * 
 * @author Colin Quinn
 * @version 1.0
 * 
 * This class represents a the state of a refridgeration unit with the door closed
 * and compressor off.  The unit will warm up, but at a different rate than in the
 * door open sate.
 *
 */
public abstract class AbstractDoorClosedState extends AbstractRefridgeratorState 
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
		int lossRate = context.getDoorClosedLossRate();
		
		// Check amount of seconds
		counter++;
		if (counter % lossRate == 0) {
			counter = 0;
			// Change temperature
			int currentTemp = context.getSubjectTemperature().getValue();
			currentTemp++;
			context.setTemperature(currentTemp);
			// Check against temperature
			if (
					currentTemp >= context.getDesiredTemperature().getValue()
					+ context.getCompressorStartDifferential()
			) {
				// Desired temperature reached
				return true;
			}
		}
		// Desired temperature not reached
		return false;
	}
}
