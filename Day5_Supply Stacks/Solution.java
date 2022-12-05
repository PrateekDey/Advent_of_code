import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    private List<List<Integer>> instructions;
    private List<Stack<Character>> stacks;


    public void Part1() {
        for (List<Integer> ins : instructions) {
            for (int i = 0; i < ins.get(0); ++i) {
                Character from = stacks.get(ins.get(1) - 1).pop();
                stacks.get(ins.get(2) - 1).push(from);
            }
        }
    }

    public void Part2() {
        Stack<Character> temp = new Stack<>();
        for (List<Integer> ins : instructions) {
            for (int i = 0; i < ins.get(0); ++i) {
                Character from = stacks.get(ins.get(1) - 1).pop();
                temp.push(from);
            }
            while (!temp.isEmpty()) {
                stacks.get(ins.get(2) - 1).push(temp.pop());
            }
        }
    }

    private void input_instructions() {
        List<List<Integer>> ins = new ArrayList<>();
        Scanner sc;
        try {
            File instruction_file = new File("Instruction_Input.txt");
            sc = new Scanner(instruction_file);
        } catch (FileNotFoundException message) {
            throw new RuntimeException(message);
        }
        while (sc.hasNext()) {
            List<Integer> curr = new ArrayList<>();
            for (int i = 0; i < 3; ++i) {
                curr.add(sc.useDelimiter("\\D+").nextInt());
            }
            ins.add(curr);
        }
        instructions = ins;
    }
    
    public void input_stack(){
        List<Stack<Character>> cargo = new ArrayList<>();
        for (int i = 0; i < 9; ++i) cargo.add(new Stack<>());
        Scanner sc;
        try {
            File stack_file = new File("Stack_Input.txt");
            sc = new Scanner(stack_file);
        } catch (FileNotFoundException message) {
            throw new RuntimeException(message);
        }
        while (sc.hasNext()) {
            String currLine = sc.nextLine();
            int len = currLine.length();
            int stackIdx = 0;
            for (int i = 0; i < len; i += 4) {
                Character curr = currLine.charAt(i + 1);
                if (!curr.equals(' ')) cargo.get(stackIdx).add(0, curr);
                stackIdx++;
            }
        }
        stacks = cargo;
    }

    private String printTopChars() {
        StringBuilder output = new StringBuilder();
        for (Stack<Character> stack : stacks) {
            output.append(stack.peek());
        }
        return output.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Solution test = new Solution();

        //Part1
        test.input_stack();
        test.input_instructions();
        test.Part1();
        System.out.println(test.printTopChars());

        //Part2
        test.input_stack();
        test.input_instructions();
        test.Part2();
        System.out.println(test.printTopChars());
    }
}
