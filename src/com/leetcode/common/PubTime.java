package com.leetcode.common;

import java.util.concurrent.*;

public class PubTime {
    public void setTime(int seconds) {

        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
        ScheduledFuture<Integer> future = service.schedule(new MyTast(seconds), seconds, TimeUnit.SECONDS);
        try {
            System.out.println(future.get());
            if (future.get().equals(1)){
                System.out.println(seconds+"seconds到了");
                System.out.println("doSomeThing");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    class MyTast implements Callable<Integer> {
        int seconds ;
        public MyTast(int seconds){
            this.seconds = seconds;
        }
        @Override
        public Integer call() throws Exception {
            System.out.println("MyTast");
            return 1;
        }
    }
}
