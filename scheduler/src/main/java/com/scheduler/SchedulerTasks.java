package com.scheduler;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class SchedulerTasks {
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Scheduled(cron = "1 * * * * ?")
    public void schedulerOnEveryMinute(){
        String runningEveryMinute = "Running every minute";
        log.info("Every Minute Rate Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()) );
    }


    @Scheduled(fixedDelay = 1000)
    public void schedulerOnEverySecond() {
        log.info("Fixed Rate Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()) );
    }

    @Scheduled(fixedRate = 2000, initialDelay = 5000)
    public void scheduleTaskWithInitialDelay() {
        log.info("Fixed Rate Task With Initial Delay :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()) );
    }

    @Scheduled(cron = "0 * 19 * * ?")
    public void scheduleTask()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "dd-MM-yyyy HH:mm:ss.SSS");

        String strDate = dateFormat.format(new Date());

        log.info("Cron job Scheduler Task :: Execution Time - {}", strDate );

    }

}
