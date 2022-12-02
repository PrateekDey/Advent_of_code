import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args)throws FileNotFoundException {
        File file=new File("Input.txt");
        Scanner sc=new Scanner(file).useDelimiter("\n");

        Map<Character, String> ldw_map = Map.of(
                'A', "YXZ", 'B', "ZYX", 'C', "XZY");

        Map<Character, Integer> shape_score = Map.of(
                'X', 1, 'Y', 2, 'Z',3);

        Map<Character, Integer> wdl_index_map = Map.of(
                'X', 2, 'Y', 1, 'Z',0);

        Map<Character, Integer> outcome_map = Map.of(
                'X', 0, 'Y', 3, 'Z',6);

        int[] wdl_score = {6, 3, 0};

        int score = 0, total_score = 0;
        while(sc.hasNext()) {
            String line = sc.next().trim();
            char l = line.charAt(0), r = line.charAt(2);

            score += Integer.valueOf((int)wdl_score[ldw_map.get(l).indexOf(r)] + shape_score.get(r));
            total_score += Integer.valueOf((int)shape_score.get(ldw_map.get(l).charAt(wdl_index_map.get(r))) + outcome_map.get(r));

        }
        System.out.println("Score: "+score+"\nTotal Score: "+ total_score);
    }
}
