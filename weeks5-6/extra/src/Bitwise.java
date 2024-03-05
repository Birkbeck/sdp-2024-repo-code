public class Bitwise {
    public static void main(String... args) {
        int i = 0b1111_0000_1111_0000; // 0xf0f0
        int j = 0b1111_1111_0000_0000; // 0xff00
        int s = 3;
        int c = ~i;
        int k = c >>> 1;
        System.out.printf("%x\n%x\n", c, k);
        System.out.printf("%x\n", (int)Double.doubleToLongBits(1.0));
    }
}
