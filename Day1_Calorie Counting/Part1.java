import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args)throws FileNotFoundException {
        File file = new File("Input.txt");
        Scanner sc = new Scanner(file).useDelimiter("\n");
        long max = 0, sum = 0;
        while(sc.hasNext()){
            String val;
            if((val = sc.next().trim()).isEmpty()){
                if(max<sum) max = sum;
                sum = 0;
            }else{
                sum += Long.parseLong(val);
            }
        }
        System.out.println(max);
    }
}
