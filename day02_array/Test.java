import java.util.Arrays;

class Test {
    public static void main(String[] args) {
        // int[] arr = new int[]{1, 2, 3, 4, 5};
        // int idx = arr.length;
        // while (idx-- > 0) {
        //     System.out.println("结果： " + arr[idx]);
        // }
        // float[] arr = new float[5];
        // arr[2] = '1';

        // float[] arr1 = arr;
        // System.out.println(arr);
        // int[] a = {1};
        // int[] b[] = {{2}};
        // System.out.println(a[0]);
        // System.out.println(b[0][0]);

        int[] arr = {1, 6, 3};
        // int target = 2;
        // int l = 0; 
        // int r = arr.length - 1;
        // while (l <= r) {
        //     int mid = l + r >> 1;
        //     System.out.println("找1次 "+ "l: " + l + " mid: " + mid + " r: " + r);
        //     if (arr[mid] == target) {
        //         System.out.println("找到了，下标是: " + mid);
        //         return;
        //     } else if (target < arr[mid]) {
        //         r = mid - 1;
        //     } else {
        //         l = mid + 1;
        //     }
        // }
        // System.out.println("没找到！");

        // System.out.println("结果: " + Arrays.toString(arr));

        // for (int i: arr) System.out.println(i);
        // int[] arr2;
        // arr2 = Arrays.copyOf(arr, arr.length);
        // arr[1][0] = 999;
        // Arrays.fill(arr, 1);
        // int[] arr2 = Arrays.copyOf(arr, arr.length);
        // System.out.println(Arrays.equals(arr, arr2));
        // System.out.println(Arrays.toString(arr2));
        // System.out.println(Arrays.toString(arr2));
        // System.out.println(Arrays.binarySearch(arr, 2));

        Student student = new Student("jlp");
        student.sayName();

        try {
            Thread.sleep(5000);
        } catch (Exception err) {
            System.out.println("爆错了！");
        }
        Person person = new Person("123");
        person.sayName();
    }
}

class Person {
    String name;
    String[] nameList = {};

    public Person(String n) {
        name = n;
        sayName();
    }

    public void sayName() {
        System.out.println(name);
        try {
        } catch (ArrayIndexOutOfBoundsException err) {
            System.out.println("出错啦" + err.toString());
            err.printStackTrace();
        } catch (Exception e) {
            System.out.println("exception ??" + e.toString());
        }
        System.out.println("最后");
    }
}

class Student extends Person {
    public Student(String name) {
        super("student is: " + name);
    }

    public void sayName () {
        System.out.println(name);
    }
}