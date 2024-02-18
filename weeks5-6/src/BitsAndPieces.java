public class BitsAndPieces {
    public static void main(String[] args) {
        int minus1  = 0xffff_ffff; // two's complement; see https://en.wikipedia.org/wiki/Two%27s_complement
        int zero    = 0x0000_0000;

        int one        = 0x0000_0001; // 1 in binary is 0001
        int complement = 0xffff_fffe; // e in binary is 1110
        int minusOne   = 0xffff_ffff; // the complement + 1

        int minus2      = 0xffff_fffe; // -2
        int minus2plus1 = 0xffff_ffff; // -2 + 1 = -1

        int largest_positive = 0x7fff_ffff; // 7 in binary is 0111
        int sum = 0x7fff_ffff + 0x7fff_ffff;
        long mul = 0x0000_0000_7fff_ffffL * 0x7fff_ffff;

        int div = (int)(mul / 2); // cast after division

        int div2 = (int)mul / 2; // cast before division

        System.out.println(div2 + " v " + div);

        // ADD AX, DX -> a single int (operation code + operands all fit in one int)
        // ADD AX, 1000 -> two ints (operation code + AX fits into the opcode, but the second int is for 1000)
        // ADD [BP + 1000], 2000 -> three ints (one int = opcode + BP, two ints for 1000 and 2000)
        // opcode = 7 bits + 3 bits for the 1st register operand + 3 bits for the 2nd register operand - can easily fit into one int
    }
}
