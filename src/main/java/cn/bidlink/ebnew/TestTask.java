package cn.bidlink.ebnew;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@Component("hotSearchScheduled12")
public class TestTask {

    @Scheduled(cron = "0/01 * * * * ?")
    public void execute() {
        System.out.println("11111");
    }


    /**
     * 设置定时任务延时执行时间为1小时
     */
    private static long PERIOD_DAY = 2 * 1000;
    private static long delay = 0;
    //调用的时候执行一次，之后延时PERIOD_DAY毫秒执行
    public static void timeSchedule(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                Date date = new Date(this.scheduledExecutionTime());
                System.out.println("本次执行该线程的时间为：" + date);
            }

        }, delay, PERIOD_DAY);
    }

}
