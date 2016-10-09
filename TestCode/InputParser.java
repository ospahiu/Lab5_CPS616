import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created in IntelliJ IDEA.
 * User: Olsi
 * Date: 2016-03-13
 * Time: 1:34 AM
 */
public class InputParser {

    //Class variable
    private BufferedReader sc;

    //InputParser1D constructor
    public InputParser(BufferedReader sc) {
        this.sc = sc;
    }

    //Get input and print final result
    public void getInput() throws IOException {

        while(true) {
            int n = Integer.parseInt(sc.readLine());
            if (n==0) return;
            //Create our array of points.
            Point2D[] arr = new Point2D[n];
            for (int i = 0; i < n; i++) {
                //Read each line, split the input at the space and create a new Point2D for each point.
                String[] split = sc.readLine().split(" ");
                arr[i] = new Point2D.Double(Double.parseDouble(split[0]), Double.parseDouble(split[1]));
            }
            Arrays.sort(arr, sortByX());
            //Find the closest pair.
            ClosestPair cp = new ClosestPair();
            Point2D[] min = cp.getClosestPair(arr);
            //Output the points. Don't worry if the output has a few extra zeroes.
            printPoints(min);
        }
    }

    //Print points
    private static void printPoints(Point2D[] arr) {
        System.out.printf("%f %f %f %f \n",arr[0].getX(),arr[0].getY(),arr[1].getX(),arr[1].getY());
    }

    //Sort points by their x coordinates
    private Comparator<Point2D> sortByX() {
        //We want to start by pre-sorting the points by their X-Coordinate
        Comparator<Point2D> ComparatorByX;
        return ComparatorByX= new Comparator<Point2D>() {
            @Override
            public int compare(Point2D o1, Point2D o2) {
                return Double.compare(o1.getX(), o2.getX());
            }
        };
    }
}
