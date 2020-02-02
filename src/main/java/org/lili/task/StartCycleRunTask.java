package org.lili.task;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author lili
 * @date 2020/2/2 14:06
 * @description 模拟web应用关闭了，但是定时任务还没有关闭，在tomcat控制台关闭应用，一个tomcat可以有多个web应用
 * 所以需要在contextDestroyed将定时任务关闭
 * @notes
 */

public class StartCycleRunTask implements ServletContextListener {

    private Timer timer;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("webapp start ...");
        timer = new Timer();
        TimerTask timerTask = new SimpleTimerTask();
        timer.schedule(timerTask, 1000L, 3000L);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("webappp destroy");
        //timer.cancel();
        System.out.println("task cancel ...");
    }
}
