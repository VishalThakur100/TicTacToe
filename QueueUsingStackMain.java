public class QueueUsingStackMain {
    public static void main(String[] args) throws Exception {
        QueueUsingStackRemove queueUsingStack = new QueueUsingStackRemove();
        queueUsingStack.add(34);
        queueUsingStack.add(340);
        queueUsingStack.add(4);
        queueUsingStack.add(3);

//        insertion effecient

        System.out.println(queueUsingStack.remove());
        System.out.println(queueUsingStack.remove());
        System.out.println(queueUsingStack.remove());
        System.out.println(queueUsingStack.remove());

    }
}
