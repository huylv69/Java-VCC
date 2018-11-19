package problem4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * @author huylv
 */
public class Solve {

    public static void main(String[] args) throws IOException {
        Solve solve = new Solve();
        HashSet<Point> set1 = new HashSet<Point>();
        HashSet<Point> set2 = new HashSet<Point>();
        HashSet<Point> set3 = new HashSet<Point>();

        int size1 = 8000;
        while (set1.size() < size1) {
            set1.add(solve.generate(new Point(800, 800), 400, set1));
        }
        HashSet<Point> setSum = set1;

        int size2 = 10000;
        while (set2.size() < size2) {
            Point point = solve.generate(new Point(4000, 800), 500, setSum);
            set2.add(point);
            setSum.add(point);
        }

        int size3 = 12000;
        while (set3.size() < size3) {
            Point point = solve.generate(new Point(2400, 2400), 600, setSum);
            set3.add(point);
            setSum.add(point);
        }
        List<Point> listPoints = new ArrayList<Point>(setSum);
        Collections.shuffle(listPoints);

        // Write File Result
        FileWriter writer = new FileWriter("output4.txt");
        for (Point point : listPoints) {
            writer.write(point.getX() + " " + point.getY() + "\n");
        }
        writer.close();
    }


    public Point generate(Point pointCheck, int thresHold, HashSet<Point> set) {
        Point point;
        do {
            Random position = new Random();
            point = new Point(position.nextInt(2 * thresHold) + pointCheck.getX() - thresHold, position.nextInt(2 * thresHold) + pointCheck.getY() - thresHold);
        }
        while ((point.distance(pointCheck) > thresHold) || checkInSet(point, set));
        return point;
    }

    // Check exist Point
    public boolean checkInSet(Point point, HashSet<Point> set) {
        boolean result = false;
        for (Point o : set) {
            if (o.equals(point)) {
                result = true;
                break;
            }
        }
        return result;
    }

}
