package org.lili.task;

/**
 * @author lili
 * @date 2020/2/10 12:32
 * @description
 * @notes
 */


import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.*;
import java.util.concurrent.TimeUnit;

@EnableScheduling
public class FetchSomethingTask {


    @Scheduled(cron = "*/5 * * * * ?")
    public void batchFetchMarketNetValue() {
        try {
            System.out.println("batchFetchMarketNetValue:" + new Date());
            TimeUnit.SECONDS.sleep(5);
            throw new UnsupportedOperationException("not support:" + new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
