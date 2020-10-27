// 超类更抽象，但不一定需要把方法都实现。如果子类都包含，他自身不包含的方法，用abstract占位
// 这样你超类想约定包含某些方法，就不用写一个函数 + 返回空字符了
// 子类还要抽象，就还定义成抽象类，否则就具体实现，这样该子类就不抽象了。
// 抽象类不能被实例化，不存在调用没有的问题

// 仅对本类可见: private
// 对本包和所有子类可见: protected
// 对本包可见: 不需要修饰符

public class ClassTest {
    public static void main(String[] args) {
        Student p = new Student("jlp", "语文");
        System.out.println(p.getDesc());
    }
}

class Person {
    public String name;

    Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // abstract String getDesc();
}

class Student extends Person {
    String major;

    Student(String name, String ma) {
        super(name);
        major = ma;
    }

    public String getDesc() {
        return name + "-" + major;
    }
}