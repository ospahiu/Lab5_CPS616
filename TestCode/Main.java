import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Created in IntelliJ IDEA.
 * User: Olsi Spahiu
 * Date: 2016-03-13
 * Time: 1:14 AM
 */
public class Main {

    //Main method
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        InputParser inputParser = new InputParser(sc);
        //Start program
        inputParser.getInput();
    }
}
