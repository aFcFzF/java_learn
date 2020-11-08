public class Thread2 {
    public static void main(String[] args) {
        new Window("窗口1： ").start();
        new Window("窗口2： ").start();
        new Window("窗口3： ").start();
    }
}

class Window extends Thread {
    public static int ticket = 100;

    String name = "";

    public Window(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (ticket > 0) {
            System.out.println(name + ticket--);
        }
    }

    public String sayName() {
        return this.name;
    }
}

class Test2 implements Runnable {
    int ticket = 0;
    @Override
    public void run() {
        while (ticket > 0) {
            System.out.println(ticket--);
        }
    }
}

class Test3 extends Window {
    private String name = "";

    public Test3(String name) {
        super(name);
        this.name = name;
    }

    public Test3(String name) {
        super(name);
        this.name = name;
    }
}