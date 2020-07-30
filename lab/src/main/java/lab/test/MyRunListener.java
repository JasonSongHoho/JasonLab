package lab.test;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

/**
 * @author jasonsong
 * 2020/7/22
 */

@Slf4j
@Component
public class MyRunListener implements SpringApplicationRunListener, ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        log.info("MyRunListener onApplicationEvent.event:{} ",event);
        if (event instanceof ApplicationStartedEvent){
            ApplicationStartedEvent applicationStartedEvent=(ApplicationStartedEvent)event;
            ConfigurableApplicationContext applicationContext = applicationStartedEvent.getApplicationContext();
//            applicationContext.
        }

    }

    @Override
    public void starting() {
        log.info("MyRunListener starting");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        log.info("MyRunListener environmentPrepared");

    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        log.info("MyRunListener contextPrepared");

    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        log.info("MyRunListener contextLoaded");

    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        log.info("MyRunListener started");

    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        log.info("MyRunListener running");

    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        log.info("MyRunListener failed");

    }
}

