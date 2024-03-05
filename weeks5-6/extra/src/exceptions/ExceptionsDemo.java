package exceptions;

import java.io.FileNotFoundException;

class B {
    void m() throws FileNotFoundException {}
}

class D extends B {
    void m()  {}
}

public class ExceptionsDemo {
    public static void main(String[] args) throws FileNotFoundException {
        //B b = new B();
        //b.m();
        D d = new D();
        d.m();
        //B c = new D();
        //c.m();
    }
}
