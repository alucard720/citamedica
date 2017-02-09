package dr.gob.hacienda.servicios.procesos;

import org.apache.deltaspike.scheduler.api.Scheduled;

@Scheduled(cronExpression = "0 0 3 ? 1 MON#1 *")
public class LimpiadorQuincenal extends LimpiadorObsoletos {

}
