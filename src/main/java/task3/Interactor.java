package task3;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

class Interactor implements Runnable {
    int x;

    @Override
    public void run() {

    }

    import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

    class Interactor {
        private final Object lock = new Object();
        private int x;

        public void serve(UnaryOperator<Integer> uo, int initializer) throws InterruptedException {
            synchronized (lock) {
                System.out.println("Serving thread running");
                x = uo.apply(initializer);
                System.out.println("Serving thread initializes the key \n" +
                        "key = " + x);
                lock.notify();
                lock.wait();
                System.out.println("Serving thread resumed");
            }
        }


        public void consume(BinaryOperator<Integer> bo, int operand2) throws InterruptedException {
            synchronized (lock) {
                lock.wait(3000);
                System.out.println("Consuming thread received the key. key = " + x);
                x = bo.apply(x, operand2);
                System.out.println("Consuming thread changed the key. key = " + x);
                lock.notify();
            }
        }
    }