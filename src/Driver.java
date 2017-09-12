import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("numbers.in"));
        PrintWriter out = new PrintWriter(new File("numbers.out"));
        int i2 = in.nextInt();
        in.nextLine();
        while (in.hasNext()) {
            String g = in.nextLine();
            String f = in.nextLine();
            String create = "";
            for (int i = 0; i < f.length(); i++) {
                int a1 = ((int) g.charAt(i) - 1);
                int b1 = (int) f.charAt(i) + 1;
                if (a1 == 31) a1 = 126;
                if (b1 == 127) b1 = 32;
                String a = String.valueOf((char) (a1));
                String b = String.valueOf((char) (b1));
                create += a + b;
            }
            if (f.length() < g.length())
                create += (g.charAt(g.length() - 1) + 1); // this does not work or have logic to roll around
            out.println(create);
        }
        out.close();
    }
}
