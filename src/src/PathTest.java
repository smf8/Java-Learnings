import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class PathTest {

    public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            try {
                if (reader.readLine() == null) break;
                String line = reader.readLine();
                System.out.println(line);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
