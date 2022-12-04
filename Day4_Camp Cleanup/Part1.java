import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.Stream;

public class Part1 {
    static int[] parseIntArray(String[] arr) {
        return Stream.of(arr).mapToInt(Integer::parseInt).toArray();
    }

    public static void main(String[] args)throws FileNotFoundException {
        File file = new File("Input.txt");
        Scanner sc=new Scanner(file).useDelimiter("\n");

        int count = 0;
        while(sc.hasNextLine()){
            int[] t = parseIntArray(sc.nextLine().split("-|,"));
            int p1_lower = t[0], p1_upper = t[1], p2_lower = t[2], p2_upper = t[3];

            if (p1_lower >= p2_lower && p1_upper <= p2_upper) count++;
            else if (p2_lower >= p1_lower && p2_upper <= p1_upper) count++;
        }
        System.out.println(count);
    }
}
