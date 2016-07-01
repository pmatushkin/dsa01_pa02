import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        int n = segments.length;

        // let's find the right boundary of all the segments
        int maxRight = 0;
        for (int i = 0; i < n; i++) {
            int segmentEnd = segments[i].end;
            if (maxRight < segmentEnd) {
                maxRight = segmentEnd;
            }
        }

        // This is the flag value.
        // No segment ends at, or past, this point.
        maxRight = maxRight + 1;

        ArrayList<Integer> pointArray = new ArrayList<>();

        int currentPoint = 0;
        while (true) {
            int currentMinRightPoint = maxRight;

            for (int j = 0; j < n; j++) {
                Segment segment = segments[j];
                if ((segment.start > currentPoint) && (currentMinRightPoint > segment.end)) {
                    currentMinRightPoint = segment.end;
                }
            }

            if (currentMinRightPoint == maxRight) {
                break;
            } else {
                pointArray.add(currentMinRightPoint);
                currentPoint = currentMinRightPoint;
            }
        }

        int pointArraySize = pointArray.size();
        int[] points = new int[pointArraySize];
        for (int i = 0; i < pointArraySize; i++) {
            points[i] = pointArray.get(i);
        }

        return points;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
