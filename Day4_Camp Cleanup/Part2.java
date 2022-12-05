import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.Stream;

public class Part2 {
    static int[] parseIntArray(String[] arr) {
        return Stream.of(arr).mapToInt(Integer::parseInt).toArray();
    }

    public static void main(String[] args)throws FileNotFoundException {
        File file = new File("Input.txt");
        Scanner sc=new Scanner(file).useDelimiter("\n");

        int count = 0;
        while(sc.hasNextLine()){
            int[] t = parseIntArray(sc.nextLine().split("-|,"));
            int p1_l = t[0], p1_u = t[1], p2_l = t[2], p2_u = t[3];

            if((p1_l>=p2_l && p1_l <= p2_u)||
                    (p1_u >= p2_l && p1_u <= p2_u)||
                    (p2_l >= p1_l && p2_l <= p1_u)||
                    (p2_u >= p1_l && p2_u <= p1_u)){
                count++;
            }

        }
        System.out.println(count);
    }
}
