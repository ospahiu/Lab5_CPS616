/**
 * Created in IntelliJ IDEA.
 * User: Olsi Spahiu
 * Date: 2016-03-12
 * Time: 1:32 PM
 */
import java.awt.geom.Point2D;
import java.util.Arrays;

public class ClosestPair {


    public Point2D[] getClosestPair(Point2D[] arr) {

        //Length of array
        int n = arr.length;
        int halfLen = n/2;

        if (n == 0) return null;
        //Return array of size 2
        else if (n == 2) {
            return arr;
        }

        else {
            Point2D p, q;
            //Split array into two sides
            Point2D[] lhs;
            //Handle odd or even length arrays.
            if (n%2 == 0) {lhs = Arrays.copyOfRange(arr, 0, n/2);}//even
            else lhs = Arrays.copyOfRange(arr, 0, (n/2)+1);//odd
            Point2D[] rhs = Arrays.copyOfRange(arr, n/2, n);
            //Recurse through the left side of the array, and right side.
            Point2D[] lhsResult = getClosestPair(lhs);
            Point2D[] rhsResult = getClosestPair(rhs);
            //Set minimum value
            Point2D[] min =  minimum(lhsResult, rhsResult);
            double minDist = Math.sqrt(findDistance(min[0], min[1]));
            Point2D med = arr[halfLen];
            double d; //Set as new distance
            double minDistSq = minDist*minDist;
            //Buffer zone
            for (int i = halfLen-1; i >= 0; i--) {
                p = arr[i];
                if ((med.getX() - p.getX()) > minDist) break;
                for (int j = halfLen; j<n; j++) {
                    q = arr[j];
                    if ((q.getX() - p.getX()) > minDist) break;
                    //min = minimum(min, new Point2D[]{q,p});
                    d = p.distanceSq(q.getX(), q.getY());
                    if (d<minDistSq) {
                        min[0] = p;
                        min[1] = q;
                        minDistSq = d;
                        minDist=Math.sqrt(d);
                    }
                }
            }
            //Assign new closest pair of points
            return new Point2D[]{min[0], min[1]};
        }
    }

    //Find out which pair of points has a smaller distance
    private static Point2D[] minimum(Point2D[] lhs, Point2D[] rhs) {
        if (findDistance(lhs[0], lhs[1]) >  findDistance(rhs[0], rhs[1])) return rhs;
        else return lhs;
    }

    //Find out the distance between two points
    private static double findDistance(Point2D p1, Point2D p2) {
        return p1.distanceSq(p2);
    }

}