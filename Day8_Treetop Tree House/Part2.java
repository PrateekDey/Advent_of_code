import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Part2 {
    private static List<List<Integer>> tree_map;

    public void input() throws FileNotFoundException {
        File file = new File("Input.txt");
        Scanner sc = new Scanner(file);

        tree_map = new ArrayList<>();

        while(sc.hasNextLine()){
            int[] line = Stream.of((sc.next().split("")))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            tree_map.add(Arrays.stream(line).boxed().collect(Collectors.toList()));
        }
    }

    public static int check_left(int pos_i, int pos_j, int tree){
        int count = 0;
        for(int j=pos_j-1;j>=0;j--) {
            if (tree > tree_map.get(pos_i).get(j)) count++;
            else if(tree_map.get(pos_i).get(j) >= tree){count++; break;}
        }
        return count;
    }

    public static int check_right(int pos_i, int pos_j, int tree){
        int count = 0;
        for(int j=pos_j+1;j<tree_map.get(pos_i).size();j++) {
            if (tree > tree_map.get(pos_i).get(j)) count++;
            else if(tree_map.get(pos_i).get(j) >= tree){ count++; break;}
        }
        return count;
    }

    public static int check_up(int pos_i, int pos_j, int tree){
        int count = 0;
        for(int i=pos_i-1;i>=0;i--){
            if(tree_map.get(i).get(pos_j) < tree) count++;
            else if(tree_map.get(i).get(pos_j) >= tree){count++; break;}
        }
        return count;
    }

    public static int check_down(int pos_i, int pos_j, int tree){
        int count = 0;
        for(int i=pos_i+1;i<tree_map.size();i++){
            if(tree_map.get(i).get(pos_j) < tree) count++;
            else if(tree_map.get(i).get(pos_j) >= tree){count++; break;}
        }
        return count;
    }

    public void get_max(){
        int max  = 0;
        for(int i=1; i<tree_map.size()-1; i++) {
            for (int j = 1; j < tree_map.get(i).size() - 1; j++) {
                int tree = tree_map.get(i).get(j);
                int prod = check_up(i,j,tree) * check_right(i,j,tree) * check_down(i,j,tree) * check_left(i,j,tree);
                if(prod > max) max = prod;
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args)throws FileNotFoundException{
        Part2 test = new Part2();
        test.input();
        test.get_max();

    }
}
