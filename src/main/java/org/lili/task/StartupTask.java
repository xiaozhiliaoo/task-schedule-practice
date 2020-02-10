package org.lili.task;

import java.util.Date;

/**
 * @author lili
 * @date 2020/2/2 14:40
 * @description spring管理的定时任务，在web容器关闭时候会自动关闭任务
 */
public class StartupTask implements Runnable {
    @Override
    public void run() {
        //task生命周期在ExecutorConfigurationSupport中进行管理
        //test tomcat reload true
        System.out.println(" StartupTask By Spring Task ... " + new Date());
    }
}
