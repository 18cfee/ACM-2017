import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Driver {
    static List<String> words;
    static String ac;
    static int numWords;
    static int acSize;
    static int[][][] store;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("numbers.in"));
        PrintWriter out = new PrintWriter(new File("numbers.out"));
        while (in.hasNext()) {
            int n = in.nextInt();
            if(n == 0)break;
            String test = in.nextLine();
            HashSet<String> bannedWords = new HashSet<>(n);
            for(int i = 0; i < n; i++){
                bannedWords.add(in.nextLine());
            }
            String input = in.nextLine();
            words = new ArrayList<String>();
            while(!input.equals("LAST CASE")){
                int j = 0;
                char a;
                do{
                    a = input.charAt(j);
                    j++;
                }while(a != ' ');
                ac = input.substring(0,j - 1).toLowerCase();
                acSize = ac.length();
                while(j < input.length()){
                    int start = j;
                    do{
                        a = input.charAt(j);
                        j++;
                    }while(a != ' ' && j < input.length());
                    if(j == input.length()) j++;
                    String toAdd = input.substring(start,j-1);
                    if(!bannedWords.contains(toAdd)){
                        words.add(toAdd);
                    }
                }
                numWords = words.size();
                int output = func(0,0,0);
                out.println(ac + ": " + output);
                input = in.nextLine();
                words.clear();
            }
        }
        out.close();
    }

    public static int func(int indexAt, int wordIndex, int acLetter){
        if(wordIndex == numWords) return 0;
        String word = words.get(wordIndex);
        int len = word.length();
        if(indexAt == len) return 0;
        if(acLetter == acSize - 1 && wordIndex < numWords - 1) return 0;
        char cur = ac.charAt(acLetter);
        if(acLetter == acSize - 1 && wordIndex == numWords - 1) {
            int count = 0;
            for(int i = indexAt; i < len; i++){
                if(word.charAt(i) == cur){
                    count++;
                }
            }
            return count;
        } else if (word.charAt(indexAt) == cur){
            return func(indexAt + 1,wordIndex,acLetter) + func(indexAt + 1,wordIndex,acLetter + 1)
                    + func(0,wordIndex + 1,acLetter + 1);
        } else {
            return func(indexAt + 1,wordIndex,acLetter);
        }
    }
}
