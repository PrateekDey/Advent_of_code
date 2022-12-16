import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
    private static Stack<String> path = new Stack<>();
    private static HashMap<String, Long> dirs_map = new HashMap<>();

    public static void goToRootDir(){
        for(int i=0;i<path.size();i++)
            path.pop();

        path.push("/home");
    }

    public static void goPreviousDirectory(){

        path.pop();
    }

    public static void updateDirectory(String directory){
        path.push(directory);
    }

    public static Stream<Object> reversePath(){
        Object[] temp = path.toArray();
        return IntStream.range(0, temp.length)
                .mapToObj(i -> temp[(temp.length - 1) - i]);
    }

    public static void updateSizeOfEveryDirectory(Long sum){
        Stream<Object> reverse_path = reversePath();
        reverse_path.forEach(e -> {
            String ele = String.valueOf(e);
            dirs_map.put(ele, dirs_map.get(ele) + sum);
        });
    }

    public static void directoryThatCanBeDeleted(){
        System.out.println("The directories that can be deleted");
        long sum = 0l;
        for (Map.Entry<String,Long> entry: dirs_map.entrySet())
            if(entry.getValue() < 100000){
                sum += entry.getValue();
            }
        System.out.println("The total sum of directories that can be deleted: "+ sum);
    }

    public static void printDirectories(){
        System.out.println("All the Directories");
        for(Map.Entry<String, Long> entry: dirs_map.entrySet())
            System.out.println(entry.getKey()+" "+entry.getValue());
    }

    public static void getSmallestDirectory(){
        long limit = 30000000 - (70000000 - dirs_map.get("/home"));
        List<Long> valid_dirs = new ArrayList<>();
        for(Map.Entry<String, Long> entry: dirs_map.entrySet()){
            if(limit <= entry.getValue())
                valid_dirs.add(entry.getValue());
        }
        System.out.println("Smallest directory to free up space is: "+ Collections.min(valid_dirs));
    }

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("Input.txt");
        Scanner sc = new Scanner(file).useDelimiter("//Z");
        dirs_map.put("/home",0l);

        while(sc.hasNext()){
            String cmd = sc.nextLine().trim();
            if(cmd.charAt(0) == '$'){
                if(cmd.substring(2,4).equalsIgnoreCase("ls")){
                    continue;
                } else if (cmd.substring(2,4).equalsIgnoreCase("cd")) {
                    if (cmd.contains("/")){
                        goToRootDir();
                    } else if (cmd.contains("..")) {
                        goPreviousDirectory();
                    }else {
                        updateDirectory(path.peek().concat("/".concat(cmd.substring(5))));
                    }
                }
            }else{
                String[] temp = cmd.split(" ");
                if(temp[0].equalsIgnoreCase("dir")){
                    dirs_map.put(path.peek().concat("/".concat(temp[1])), 0l);
                } else {
                    long size = Long.parseLong(temp[0]);
                    updateSizeOfEveryDirectory(size);
                }
            }
            //System.out.println(path);
        }

        printDirectories();

        // Part 1
        directoryThatCanBeDeleted();

        // Part 2
        getSmallestDirectory();
    }
}
