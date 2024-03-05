package returntype;

class B {
    public double m() { return 0.0; }
    public B self() { return this; }
}

class D extends B {
    // m below does not override the m from B!
    //public int m() { return 0; }

    // overriding: narrowing return type is OK
    // (see below for examples)
    @Override
    public D self() { return this; }

    public void f() {}
}

public class ReturnTypesDemo {
    public static void main(String[] args) {
        B b = new D();
        b.m(); // not clear which m to call

        B bp = b.self(); // an instance of D, type of reference is B
        D d = new D();
        D dp = d.self(); // an instance of D, type of reference is D
        dp.f();
        B dpp = d.self(); // an instance of D, type reference is B
        //dpp.f();
    }
}
