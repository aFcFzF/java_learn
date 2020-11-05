/**
 * @file ThreadLearn.class
 * @author afcfzf(9301462@qq.com)
 */

class ThreadLearn {
    public static void main(String[] args) {
        // Console c1 = new Console("线程1");
        // Console c2 = new Console("=== 线程2");
        // c1.start();
        // c2.start();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("当前输出： " + i);
                }
            }
        };
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("当前输出222 ： " + i);
                }
            }
        };

        t2.setPriority(Thread.MAX_PRIORITY);

        t2.start();
        System.out.println("调用了" + Thread.currentThread().getPriority());
        // System.out.println("调用了");
    }
}

class Console extends Thread {
    String namespace = "";

    public Console(String ns) {
        this.namespace = ns;
    }

    public void run() {
        int i = 0;
        System.out.println("获取名字：" + Thread.currentThread().getName());
        while (i < 30) {
            System.out.println(namespace + i);
            i++;
        }
    }
}
