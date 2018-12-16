
import java.util.concurrent.RecursiveTask;


//Напишите консольное приложение для вычисления суммы всех
//элементов массива (из 1_000_000 целых элементов, значения которых
//генерируются случайным образом в диапазоне от 0 до 100), используя
//фреймворк ForkJoin
public class Sum extends RecursiveTask<Integer> {
    private int[] data;
    private int start;
    private int end;


    Sum(int[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }


    @Override
    protected Integer compute() {
        int sum = 0;
        int seqThreshHold = 20;
        if ((end - start) < seqThreshHold) {
            for (int i = start; i < end; i++) {
                sum += data[i];
            }

        }else{
    int middle=(start+end)/2;
    Sum subTaskA= new Sum(data,start,middle);
            Sum subTaskB= new Sum(data,middle,end);

            subTaskA.fork();
            subTaskB.fork();
            sum=subTaskA.join()+subTaskB.join();

        }
        return sum;
    }
}
