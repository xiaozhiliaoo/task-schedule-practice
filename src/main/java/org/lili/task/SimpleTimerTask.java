package org.lili.task;

import java.util.Date;
import java.util.TimerTask;

/**
 * @author lili
 * @date 2020/2/2 14:09
 * @description
 * @notes
 */

public class SimpleTimerTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("SimpleTimerTask execute at:" + new Date());
    }
}
