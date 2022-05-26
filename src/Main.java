import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

   public static void main(String args[]){
       String exp1 = "{{[(())]}}";
       String exp2 = "[({]";
       String arr[]=exp1.split("(?!^)");
       System.out.println(validator(arr));

   }

   static boolean validator(String arr[]){
       Stack<String> stack = new Stack<String>();
       for (int i = 0; i<arr.length; i++) {
           if(arr[i].equals("(") || arr[i].equals("{") || arr[i].equals("[") ){
               stack.push(arr[i]);
           }else if (arr[i].equals(")") && !stack.isEmpty()){
               String current = stack.pop();
               if(!current.equals("(")) {
                   return false;

               }
           }else if(arr[i].equals("}") && !stack.isEmpty()){
               String current = stack.pop();
               if(!current.equals("{")){
                   return false;



               }
           }else if(arr[i].equals("]")&& !stack.isEmpty()){
               String current = stack.pop();
               if(!current.equals("[")){
                   return false;


               }
           }else{
               return false;
           }

       }
       if (!stack.isEmpty()){
           return false;
       }
       return true;
   }
}
