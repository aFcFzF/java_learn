/**
 * @file 01.java
 * @author afcfzf(9301462@qq.com)
 */
import static java.lang.Math.*;

class VariableTest {
    public static void main(String[] args) {
        int myNumber = 1;
        byte myByte = -3;
        short myShort = 9999;
        float f1 = 1.1f;

        float a = 1.2f;

        System.out.println("结果是： " + Math.pow(3, 2));
        System.out.println("结果2是： " + args);
        System.out.println("结果3是： " + Byte.toUnsignedInt(myByte));
        final int abb = 1;
        System.out.println("结果4是:" + abb);
    }
}