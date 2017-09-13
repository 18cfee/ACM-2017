import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("numbers.in"));
        PrintWriter out = new PrintWriter(new File("numbers.out"));
        while (in.hasNext()) {
            int a = in.nextInt();
            if(a == 0) break;
            HashSet<Integer> S = funcMult(a);
            int tot = 0;
            for(Integer I: S){
                tot += I;
            }
            out.println(a == tot);
        }
        out.close();
    }

    public static HashSet<Integer> funcMult(int a){
        int b = a;
        HashSet<Integer> S = new HashSet<Integer>();
        S.add(1);
        for(int i = 2; i <= Math.sqrt(a); i++){
            while(a%i == 0) {
                HashSet<Integer> B = (HashSet<Integer>) S.clone();
                for(Integer I: B){
                    int mult = I*i;
                    S.add(mult);
                    //S.add(b/mult);
                }
                a=a/i;
            }
        }
        HashSet<Integer> B = (HashSet<Integer>) S.clone();
        for(Integer I: B){
            int mult = I*a;
            S.add(mult);
            //S.add(b/mult);
        }
        S.remove(b);
        return S;
    }
}
