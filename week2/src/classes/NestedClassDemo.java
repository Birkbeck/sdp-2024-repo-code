package classes;


import java.util.LinkedList;

class OuterClass {
    private int variable = 1;
    class InnerClass {
        private int variable = 2; // shadows variable from OuterClass

        // An instance of InnerClass can exist only within an instance of OuterClass
        // and has direct access to the methods and fields of its enclosing instance.
        int method1(int variable) {
            return this.variable; // refers to variable from InnerClass
        }
        int method2() {
            OuterClass outer = OuterClass.this;  // refers to the enclosing instance
            // return outer.variable; // refers to variable from OuterClass
            return OuterClass.this.variable; // refers to variable from OuterClass
        }
    }

    static class StaticNestedClass {
        int method() {
            //return variable; // not accessible
            //return OuterClass.this.variable; // Outer.this not available
            return 0;
        }
    }

    InnerClass method() { return new InnerClass(); }
}



public class NestedClassDemo {

    /*
       for varargs (...) - read
            https://docs.oracle.com/javase/tutorial/java/javaOO/arguments.html
            https://docs.oracle.com/javase/8/docs/technotes/guides/language/non-reifiable-varargs.html
     */
    public static void main(String... args) {
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner0 = outer.method();
        OuterClass.InnerClass inner = outer.new InnerClass();
        System.out.println(inner.method1(42));
        System.out.println(inner.method2());

        OuterClass.StaticNestedClass nested = new OuterClass.StaticNestedClass();
        System.out.println(nested.method());
    }
}
