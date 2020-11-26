package src;
public class Action {
    int intValue;
    char charValue;
    String message;
    void setMessage(String msg){
        //System.out.println("setMessage Action msg is: " + msg);
        message = msg;
    }

    void setIntValue(int v){
        //System.out.println("setIntValue Action int v is: " + v);
        intValue = v;
    }

    void setCharValue(char c){
        //System.out.println("SetCharValue Action char c is: " + c);
        charValue = c;
    }
}