import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part1 {
    public static int check_priority(char ch){
        String upper_cap = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower_cap = "abcdefghijklmnopqrstuvwxyz";
        if(Character.isUpperCase(ch)) return upper_cap.indexOf(ch) + 27;
        else return lower_cap.indexOf(ch) + 1;
    }

    public static void main(String[] args)throws FileNotFoundException{
        File file=new File("Input.txt");
        Scanner sc=new Scanner(file).useDelimiter("\n");

        int sum = 0;
        while(sc.hasNextLine()){
            String str = sc.next();
            String s1 = str.substring(0,(str.length()/2)), s2 = str.substring((str.length()/2), str.length());
            for(int i=0;i<s2.length();i++){
                if(s1.indexOf(s2.charAt(i)) != -1){
                    sum = sum + check_priority(s2.charAt(i));
                    break;
                }
            }
        }
        System.out.println(sum);
    }
}
