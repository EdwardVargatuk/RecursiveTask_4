import java.util.Random;
import java.util.concurrent.ForkJoinPool;


public class ForkJoinTask {


    public static void main(String[] args) {

        long before, after;
        ForkJoinPool forkJoinPool = new ForkJoinPool(8);
        Random random =new Random(System.nanoTime());

        int []nums= new int[1000000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(100);
        }
            Sum task = new Sum(nums, 0, nums.length);

            before= System.nanoTime();
            int summation= forkJoinPool.invoke(task);
            after= System.nanoTime();
            System.out.println("sum : "+summation);

            System.out.println("time : "+(after-before)+" ns");


    }
}
