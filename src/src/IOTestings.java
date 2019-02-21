// Differences between Java I/O Methods and classes

import java.io.*;
import java.time.Duration;
import java.time.Instant;

public class IOTestings {

    private static long copyByByteStream() throws IOException{
        Instant startTime = Instant.now();
        FileInputStream inputStream = new FileInputStream("theFuck.txt");
        FileOutputStream outputStream = new FileOutputStream("outputByteStream.txt");
        while(true){
            int c = inputStream.read();
            if (c!=-1)
                outputStream.write(c);
            else
                break;
        }
        inputStream.close();
        outputStream.close();
        return Duration.between(startTime, Instant.now()).toMillis();
    }
    private static long copyByCharacterStream() throws IOException{
        Instant startTime = Instant.now();
        FileReader reader = new FileReader("theFuck.txt");
        FileWriter writer = new FileWriter("outputCharacterStream.txt");
        int c;
        while (( c = reader.read()) != -1){
            writer.write(c);
        }
        reader.close();
        writer.close();
        return Duration.between(startTime, Instant.now()).toMillis();
    }

    private static long copyByBufferedByteStream() throws IOException{
        Instant startTime = Instant.now();
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("theFuck.txt"));
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("outputBufferedStream.txt"));
        int c;
        while (( c = inputStream.read()) != -1){
            outputStream.write(c);
        }
        outputStream.flush();
        inputStream.close();
        inputStream.close();
        return Duration.between(startTime, Instant.now()).toMillis();
    }

    private static long copyByBufferedCharacterStream() throws IOException{
        Instant startTime = Instant.now();
        BufferedReader inputStream = new BufferedReader(new FileReader("theFuck.txt"));
        BufferedWriter outputStream = new BufferedWriter(new FileWriter("outputBufferedCharacterStream.txt"));
        int c;
        while (( c = inputStream.read()) != -1){
            outputStream.write(c);
        }
        outputStream.flush();
        inputStream.close();
        inputStream.close();
        return Duration.between(startTime, Instant.now()).toMillis();
    }
    public static void main(String[] args) throws IOException {
        System.out.println("ByteStream copying took " + copyByByteStream() + " mili seconds.");
        System.out.println("CharacterStream copying took " + copyByCharacterStream() + " mili seconds.");
        System.out.println("BufferedByteStream copying took " + copyByBufferedByteStream() + " mili seconds");
        System.out.println("BufferedCharacterStream copying took " + copyByBufferedCharacterStream() + " mili seconds");
    }
}