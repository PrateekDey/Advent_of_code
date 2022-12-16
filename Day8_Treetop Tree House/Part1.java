import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Part1 {
    private static List<List<Integer>> tree_map;

    public void input() throws FileNotFoundException {
        File file = new File("Input.txt");
        Scanner sc = new Scanner(file);

        tree_map = new ArrayList<>();
        int i = 0;
        while(sc.hasNextLine()){
            int[] line = Stream.of((sc.next().split("")))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            tree_map.add(Arrays.stream(line).boxed().collect(Collectors.toList()));
        }
    }

    public static Boolean check_left(int pos_i, int pos_j, int tree){
        for(int j=0;j<pos_j;j++){
            if(tree_map.get(pos_i).get(j) >= tree)
                return false;
        }
        return true;
    }

    public static Boolean check_right(int pos_i, int pos_j, int tree){
        for(int j=pos_j+1;j<tree_map.get(pos_i).size();j++){
            if(tree_map.get(pos_i).get(j) >= tree)
                return false;
        }
        return true;
    }

    public static Boolean check_up(int pos_i, int pos_j, int tree){
        for(int i=0;i<pos_i;i++){
            if(tree_map.get(i).get(pos_j) >= tree)
                return false;
        }
        return true;
    }

    public static Boolean check_down(int pos_i, int pos_j, int tree){
        for(int i=pos_i+1;i<tree_map.size();i++){
            if(tree_map.get(i).get(pos_j) >= tree)
                return false;
        }
        return true;
    }
    public int check_visibility() {
        int count = 0;
        for(int i=1; i<tree_map.size()-1; i++) {
            for (int j = 1; j < tree_map.get(i).size() - 1; j++) {
                int tree = tree_map.get(i).get(j);
                if(check_up(i,j,tree) || check_right(i,j,tree) || check_down(i,j,tree) || check_left(i,j,tree))
                    count++;
            }
        }
        return count;
    }

    public int outer_tree(){
        return ((tree_map.get(0).size()*2) + (tree_map.size()*2) - 4);
    }

    public static void main(String[] args)throws FileNotFoundException{
        Part1 test = new Part1();
        test.input();
        System.out.println(test.outer_tree() + test.check_visibility());
    }
}
