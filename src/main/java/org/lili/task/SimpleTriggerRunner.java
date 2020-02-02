package org.lili.task;

import org.quartz.*;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.triggers.SimpleTriggerImpl;

import java.util.Date;

/**
 * @author lili
 * @date 2020/2/2 12:18
 * @description
 * @notes
 */

public class SimpleTriggerRunner {
    public static void main(String[] args) {
        JobDetail jobDetail = new JobDetailImpl("job1_1", "jgroup", SimpleJob.class);
    }
}
