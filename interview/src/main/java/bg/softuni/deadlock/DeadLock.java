package bg.softuni.deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class DeadLock {

  private static Object lock1 = new Object();
  private static Object lock2 = new Object();

  //T1 -> lock(X) -> wait_for(Y)
  //T2 -> lock(Y) -> wait_for(X)

  public static void main(String[] args) throws InterruptedException {
    Worker1 worker1 = new Worker1();
    Worker2 worker2 = new Worker2();

    Thread t1 = new Thread(worker1);
    Thread t2 = new Thread(worker2);
    Thread t3 = new Thread(new DeadLockDetection());

    t1.start();
    t2.start();
    t3.start();

    t2.join();
  }

  private static class DeadLockDetection implements Runnable {
    @Override
    public void run() {
      while (true) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] threadIds = threadMXBean.findDeadlockedThreads();
        if (threadIds != null) {
          System.out.println("THREAD LOCK DETECTED!");
          for (long threadId : threadIds) {

            ThreadInfo threadInfo = threadMXBean.getThreadInfo(threadId);
            System.out.println(threadInfo.getThreadName());
          }
          return;
        }
      }
    }
  }

  private static class Worker1 implements Runnable {
    @Override
    public void run() {
      System.out.println("Request lock1 ");
      synchronized (lock1) {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        synchronized (lock2) {
          System.out.println("Huraaaaaa!");
        }
      }
    }
  }

  private static class Worker2 implements Runnable {
    @Override
    public void run() {
      System.out.println("Request lock2 ");
      synchronized (lock2) {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        synchronized (lock1) {
          System.out.println("Huraaaaaa!");
        }
      }
    }
  }
}
