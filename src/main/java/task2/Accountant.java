package task2;

import java.util.function.BinaryOperator;

class Accountant {
    public static int sum(int x, int y) {
        BinaryOperator<Integer> additionOperator = Integer::sum;
        ParallelCalculator parallelCalculator = new ParallelCalculator(additionOperator, x, y);
        Thread thread = new Thread(parallelCalculator);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return parallelCalculator.result;
    }
}