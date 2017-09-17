import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("shop.in"));
        PrintWriter out = new PrintWriter(new File("shop.out"));
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            int c = in.nextInt();
            int c2 = c/2 + 2;
            int[] arrayShop = new int[c2];
            int indexShop = c2 - 1;
            if(!(c == 1)) arrayShop[indexShop] = Math.max(in.nextInt(),in.nextInt());
            else arrayShop[indexShop] = in.nextInt();
            for(int j = 2; j < c; j++){
                int insert = in.nextInt();
                if(j%2 == 1){
                    indexShop--;
                    arrayShop[indexShop] = insert;
                    Arrays.sort(arrayShop);
                } else {
                    int lowIn = arrayShop[indexShop];
                    if(insert > lowIn){
                        arrayShop[indexShop] = insert;
                        Arrays.sort(arrayShop);
                    }
                }
            }
            int b = 0;
            for(int j = 0; j < c2; j++){
                b += arrayShop[j];
            }
            System.out.println("Spree #" + (i+1) + ": " + b + "  ff " + c);
        }
        out.close();
    }

}
