import java.io.FileReader;
import java.util.Stack;

public class MatchParentheses {

    //Determines if the parentheses in a text file match.
    public static String parenthesesMatch(String file){
        Stack<Character> stack = new Stack<>();

        try{
            FileReader fr = new FileReader(file);

            int i = 0;
            //Look out for these characters
            char[] chars = {'{', '}', '[', ']','(', ')'};

            while ((i = fr.read()) != -1){
                //Print all the content of a file
                char c = (char)i;

                if(contains(chars, c)){
                    if(!stack.isEmpty()) {
                        //Pushes similar brackets, pops dissimilar brackets.
                        switch (c) {
                            case '{':
                                if (stack.peek() == '}') {
                                    stack.pop();
                                }else{
                                    stack.push(c);
                                }
                                break;
                            case '}':
                                if (stack.peek() == '{') {
                                    stack.pop();
                                }else{
                                    stack.push(c);
                                }
                                break;
                            case '[':
                                if (stack.peek() == ']') {
                                    stack.pop();
                                }else{
                                    stack.push(c);
                                }
                                break;
                            case ']':
                                if (stack.peek() == '[') {
                                    stack.pop();
                                }else{
                                    stack.push(c);
                                }
                                break;
                            case '(':
                                if (stack.peek() == ')') {
                                    stack.pop();
                                }else{
                                    stack.push(c);
                                }
                                break;
                            case ')':
                                if (stack.peek() == '(') {
                                    stack.pop();
                                }else{
                                    stack.push(c);
                                }
                                break;
                            default:
                                break;
                        }
                    }else{
                        stack.push(c);
                    }
                }
            }
        }catch(Exception e){
            System.out.println(e);
            return "Incorrect";
        }

        //If the stack is empty, each open bracket must've had a corresponding and valid closing bracket.
        if(stack.isEmpty()){
            return "Correct";
        }else{
            return "Incorrect";
        }
    }

    //Checks for our designated characters
    public static boolean contains(char[] array, char c){
        for(char a: array){
            if(c == a){
                return true;
            }
        }

        return false;
    }
}
