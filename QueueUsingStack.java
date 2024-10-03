import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer> first;
    Stack<Integer> second;

    public QueueUsingStack() {
       first=new Stack<>();
       second=new Stack<>();
    }

    public void push(int item){
       first.push(item);
       return;
    }
    public int pop() throws Exception{
        while(!first.isEmpty()){
            second.push(first.pop());
        }
        int removed=second.pop();
        while(!second.isEmpty()){
            first.push(second.pop());
        }
        return removed;
    }
    public boolean empty(){
        return first.isEmpty();
    }
    public int peek(){
        while(!first.isEmpty()){
            second.push(first.pop());
        }
        int peeked= second.peek();
        while(!second.isEmpty()){
            first.push(second.pop());
        }
        return peeked;
    }


}

class QueueUsingStackRemove{
    Stack<Integer> first;
    Stack<Integer> second;

    public QueueUsingStackRemove() {
        first=new Stack<>();
        second=new Stack<>();
    }

    public void add(int item) {
        while(!first.isEmpty()){
            second.push(first.pop());
        }
        second.push(item);
        while(!second.isEmpty()){
            first.push(second.pop());
        }
        return;
    }
    public boolean empty(){
        return first.isEmpty();
    }
    public int remove(){
        return first.pop();
    }
    public int peek(){
        return first.peek();
    }
}