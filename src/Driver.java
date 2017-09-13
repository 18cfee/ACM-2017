import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("numbers.in"));
        PrintWriter out = new PrintWriter(new File("numbers.out"));
        while (in.hasNext()) {
            int[] x = new int[4];
            int[] y = new int[4];
            boolean end = true;
            for(int i = 0; i < 4; i++){
                x[i] = in.nextInt();
                if(x[i] != 0) end = false;
                y[i] = in.nextInt();
                if(y[i] != 0) end = false;
            }
            if(end)break;
            double minArea = area(x,y);

        }
        out.close();
    }

    public static double area(int[] x, int[] y){
        
    }
}
