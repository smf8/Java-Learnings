import java.util.Scanner;

public class Minesweeper {
    private static int[][] map;
    private static int n,m;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        // columns
        n = scanner.nextInt();
        // rows
        m = scanner.nextInt();
        map = new int[n+2][m+2];
        for (int i = 1; i < n+1 ; i++) {
            String line = scanner.next();
            for (int j =1; j< m + 1; j++){
                if (line.charAt(j-1) == '*'){
                    map[i][j] = -1;
                    }
            }
        }
        int[][] result = new int[n][m];
        for (int i = 1; i < n+1 ; i++) {
            for (int j =1 ; j< m+1; j++){
                if (map[i][j] != -1){
                    int neighbourBombs = -1*(map[i-1][j-1] + map[i-1][j] + map[i-1][j+1] + map[i+1][j-1] + map[i+1][j] + map[i+1][j+1] + map[i][j+1] + map[i][j-1]);
                    result[i-1][j-1] = neighbourBombs;
                }else{
                    result[i-1][j-1] = -1;
                }
            }
        }
        printMap(result);

    }
    private static void printMap(int[][] result){
        for (int i = 0; i < n ; i++) {
            for (int j =0; j< m; j++){
                if (result[i][j] != -1){
                    System.out.print(result[i][j]);
                }else{
                    System.out.print('*');
                }
            }
            System.out.println();
        }
    }
}
