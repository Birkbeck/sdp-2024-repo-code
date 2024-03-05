public class Factorial {
    public static void main(String... args) {
        int f = factorial(6);
        System.out.println(f);
    }

    public static int factorial(int n) {
        int f = 1;
        for (int i = n; i > 1; i--)
            f *= i;
        return f;
    }
}

//Compiled from "Factorial.java"
//public class Factorial {
//  public Factorial();
//    Code:
//       0: aload_0
//       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
//       4: return
//
//  public static void main(java.lang.String...);
//    Code:
//       0: bipush        6
//       2: invokestatic  #7                  // Method factorial:(I)I
//       5: istore_1
//       6: getstatic     #13                 // Field java/lang/System.out:Ljava/io/PrintStream;
//       9: iload_1
//      10: invokevirtual #19                 // Method java/io/PrintStream.println:(I)V
//      13: return
//
//  public static int factorial(int);
//    Code:
//       0: iconst_1
//       1: istore_1
//       2: iload_0
//       3: istore_2
//       4: iload_2
//       5: iconst_1
//       6: if_icmple     19
//       9: iload_1
//      10: iload_2
//      11: imul
//      12: istore_1
//      13: iinc          2, -1
//      16: goto          4
//      19: iload_1
//      20: ireturn
//}
