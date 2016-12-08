package com.lance.logging.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by perdonare on 2016/12/3.
 */
@EnableScheduling
@Service@Slf4j
public class LoggingTest {
    @Scheduled(cron = "1/5 * * * * ?")
    public void testLogging() {
        log.info("send message");
    }
}
