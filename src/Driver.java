import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Driver
{
    public static void main (String [] args) throws FileNotFoundException
    {
        Scanner in = new Scanner (new File("numbers.in"));
        PrintWriter out = new PrintWriter (new File ("numbers.out"));

        while (in.hasNext())
        {
            int g = in.nextInt();
            int l = in.nextInt();
            if(g + l == 0) break;
            int finalNum = method(g,l);
            out.println(finalNum);
        }
        out.close();
    }
    public static int method(int g, int l) {
        if(g == 0){
            return 0;
        }else if(l==0){
            return g;
        }
        int one = method(g-1,l-1);
        int two = method(g-1,l);
        return one + two + 1;
    }
}

