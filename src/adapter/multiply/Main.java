package adapter.multiply;


class A {

    interface B {
        int c();
        int d();
    }

    int e(B b) {
        return b.c()* b.d();
    }

}

public class Main {
    public static void main(String[] args) {
        A a = new A();

        int result = a.e(new A.B() {
            @Override
            public int c() {
                return 30;
            }

            @Override
            public int d() {
                return 2;
            }
        });

        System.out.println("Result: " + result);
    }
}
