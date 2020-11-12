interface A {
    public String sayName();
}

interface B {
    public int sayName(name: string);
}

class Person implements A, B {
    public int sayName(name: string) {
        return 1;
    }
}

class Test {
    public void main() {
        Person p = new Person();
        System.out.println(p.sayName());
    }
}
