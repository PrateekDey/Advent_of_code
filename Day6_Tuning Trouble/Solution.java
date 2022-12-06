import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static Boolean check_unique(String temp, int window_size){
        List<Character> dp = new ArrayList<Character>();

        for(int i=0;i<window_size;i++){
            if(dp.contains(temp.charAt(i))) return false;
            dp.add(temp.charAt(i));
        }
        return true;
    }

    public static void part1(String line){
        System.out.println("4 Distinct Characters");
        for (int i = 0; i < line.length() - 3; i++) {
            String temp = line.substring(i, i + 4);
            if (check_unique(temp, 4)) {
                System.out.println("first marker after character: " + (i + 4));
                break;
            }
        }
    }

    public static void part2(String line){
        System.out.println("14 Distinct Characters");
        for (int i = 0; i < line.length() - 13; i++) {
            String temp = line.substring(i, i + 14);
            if (check_unique(temp, 14)) {
                System.out.println("first marker after character: "+ (i + 14));
                break;
            }
        }
    }

    public static void main(String[] args)throws FileNotFoundException {
        File file = new File("Input.txt");
        Scanner sc = new Scanner(file);

        while(sc.hasNextLine()) {
            String line = sc.next();
            // Part 1
            part1(line);

            // Part 2
            part2(line);
        }
    }
}
