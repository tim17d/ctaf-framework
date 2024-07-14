package steps;

import logging.LogColors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractSteps {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    protected void logStep(String msg, Object... vars) {
        log.info(LogColors.cyan(msg), vars);
    }
}
