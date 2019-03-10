import java.util.Scanner;
/*
        Baraye in soal mishe tamame zir araye haye araye ro hesab konim jam jomalateshoon ro
        va mesl hesab kardane maximum az beyn chanta adad maximum ro hesab mikonim.
 */
public class FarzadKarKon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        int[] numbers = new int[cases];
        for (int i = 0; i < cases; i++) {
            numbers[i] = sc.nextInt();
        }
        int max = 0, maxIndex = 0, maxlastIndex = 0;

        for (int size = 1; size <= cases; size++){
            // start from index = 0 to index = length - size to compute all sub arrays with length j
            for (int index = 0; index+size <= cases; index++){
                int sum = 0;
                for (int j = index; j < size + index; j++){
                    sum += numbers[j];
                }
                if (sum > max){
                    maxIndex = index;
                    maxlastIndex = index + size;
                    max = sum;
                }
            }
        }
        System.out.println(max);
    }
}
