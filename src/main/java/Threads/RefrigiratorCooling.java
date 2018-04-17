package Threads;

import context.RefridgeratorContext;

public class RefrigiratorCooling implements Runnable{
    @Override
    public void run() {
        while(RefridgeratorContext.instance().getDesiredTemparature().getValue()<RefridgeratorContext.instance().getSubjectTemperature().getValue()){

        }
    }
}
