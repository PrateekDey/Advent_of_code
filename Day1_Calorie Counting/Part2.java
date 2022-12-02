import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Part2 {
    public static void main(String[] args)throws FileNotFoundException {
        File file = new File("Input.txt");
        Scanner sc = new Scanner(file).useDelimiter("\n");
        long sum = 0;
        List<Long> ls=new ArrayList<Long>();
        while(sc.hasNext()){
            String val;
            if((val = sc.next().trim()).isEmpty()){
                ls.add(sum);
                sum = 0;
            }else{
                sum += Long.parseLong(val);
            }
        }
        Collections.sort(ls);
        List<Long> top3 = new ArrayList<Long>(ls.subList(ls.size() -3, ls.size()));
        System.out.println(top3.stream()
                .mapToLong(Long::longValue)
                .sum());
    }
}
