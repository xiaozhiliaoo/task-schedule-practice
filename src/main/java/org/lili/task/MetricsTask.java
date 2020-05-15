package org.lili.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author lili
 * @date 2020/5/1 0:53
 * @description 任务执行过程的Metrics统计
 */
@EnableScheduling
@EnableAsync
@Slf4j
@Service
public class MetricsTask {


    @Autowired
    private ThreadPoolTaskScheduler taskScheduler;

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;


    //@Scheduled(cron = AOP_TEST)
    //@Async("threadPoolTaskExecutor")
    public void aop() {
        //1 @Scheduled 会等到任务执行完在执行下一个，所以防止重复不生效，但是任务会积压吗？不会积压
        //2 @Async 立马执行下一个任务，防止重复生效，任务会积压吗？不会积压
        //3 @Scheduled+@Async 定时执行时候异步,任务会积压吗？不会积压
        //那么选择1还是3呢？
        log.info("aop start ...");
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = taskScheduler.getScheduledThreadPoolExecutor();
        int size = scheduledThreadPoolExecutor.getQueue().size();
        log.info("scheduler task count:{}, complete count:{},queue size:{}", scheduledThreadPoolExecutor.getTaskCount(), scheduledThreadPoolExecutor.getCompletedTaskCount(), size);
        ThreadPoolExecutor threadPoolExecutor = taskExecutor.getThreadPoolExecutor();
        log.info("executor task count:{}, complete count:{},queue size:{}", threadPoolExecutor.getTaskCount(), threadPoolExecutor.getCompletedTaskCount(), threadPoolExecutor.getQueue().size());
    }

}
