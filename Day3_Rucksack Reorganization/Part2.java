import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part2 {
    public static String common(String s1, String s2){
        String s = "";
        for(int i=0;i<s2.length();i++){
            if(s1.indexOf(s2.charAt(i)) != -1){
                s = s + s2.charAt(i);
            }
        }
        return s;
    }

    public static int check_priority(char ch){
        String upper_cap = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower_cap = "abcdefghijklmnopqrstuvwxyz";
        if(Character.isUpperCase(ch)) return upper_cap.indexOf(ch) + 27;
        else return lower_cap.indexOf(ch) + 1;
    }

    public static void main(String[] args)throws FileNotFoundException {
        File file = new File("Input.txt");
        Scanner sc=new Scanner(file).useDelimiter("\n");

        List<String> list=new ArrayList<String>();
        int count=0, sum = 0;
        while(sc.hasNextLine()){
            list.add(count,sc.next());
            if((count+1)%3 == 0){
                String l1 = list.get(count-2), l2 =list.get(count-1), l3 = list.get(count);
                String temp = common(l1,l2);
                String rs = common(l3,temp);
                sum = sum + check_priority(rs.charAt(0));
            }
            count++;
        }
        System.out.println(sum);
    }
}
