package org.lili.task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @author lili
 * @date 2020/2/2 12:14
 * @description
 * @notes
 */

public class SimpleJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println(context.getTrigger().getCalendarName() +
                " triggered. time is:" + new Date());
    }
}
