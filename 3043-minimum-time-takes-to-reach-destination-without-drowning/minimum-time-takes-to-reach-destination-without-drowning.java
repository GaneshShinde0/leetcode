import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    private record Point(int row, int column) {}

    private static final int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final String START = "S";
    private static final String DESTINATION = "D";
    private static final String EMPTY = ".";
    private static final String STONE = "X";
    private static final String FLOODED = "*";
    private static final int IMPOSSIBLE_TO_REACH_DESTINATION = -1;
    private static final int NOT_FLOODED = Integer.MAX_VALUE;
    private static final int VISITED = 0;

    private int rows;
    private int columns;
    private List<List<String>> land;
    private int[][] minTimeToFlood;

    public int minimumSeconds(List<List<String>> land) {
        rows = land.size();
        columns = land.get(0).size();
        this.land = land;
        initializeMatrixMinTimeToFlood();
        return findMinTimeToReachDestination();
    }

    private int findMinTimeToReachDestination() {
        Queue<Point> queueForDestinationTime = new LinkedList<>();
        initializeQueueForDestinationTime(queueForDestinationTime);
        int minTimeToDestination = 0;

        while (!queueForDestinationTime.isEmpty()) {

            for (int i = queueForDestinationTime.size() - 1; i >= 0; --i) {
                Point current = queueForDestinationTime.poll();
                if (land.get(current.row).get(current.column).equals(DESTINATION)) {
                    return minTimeToDestination;
                }

                for (int[] move : moves) {
                    int nextRow = current.row + move[0];
                    int nextColumn = current.column + move[1];
                    if (isValidPointToStep(nextRow, nextColumn, minTimeToDestination + 1)) {
                        queueForDestinationTime.add(new Point(nextRow, nextColumn));
                        minTimeToFlood[nextRow][nextColumn] = VISITED;
                    }
                }
            }

            ++minTimeToDestination;
        }

        return IMPOSSIBLE_TO_REACH_DESTINATION;
    }

    private void initializeMatrixMinTimeToFlood() {
        minTimeToFlood = new int[rows][columns];
        for (int r = 0; r < rows; ++r) {
            Arrays.fill(minTimeToFlood[r], NOT_FLOODED);
        }

        int floodTime = 0;
        Queue<Point> queueForFloodTime = new LinkedList<>();
        initializeQueueForFloodTime(queueForFloodTime, floodTime);

        while (!queueForFloodTime.isEmpty()) {
            ++floodTime;
            for (int i = queueForFloodTime.size() - 1; i >= 0; --i) {
                Point current = queueForFloodTime.poll();

                for (int[] move : moves) {
                    int nextRow = current.row + move[0];
                    int nextColumn = current.column + move[1];
                    if (isValidPointToFlood(nextRow, nextColumn)) {
                        minTimeToFlood[nextRow][nextColumn] = floodTime;
                        queueForFloodTime.add(new Point(nextRow, nextColumn));
                    }
                }
            }
        }
    }

    private void initializeQueueForFloodTime(Queue<Point> queueForFloodTime, int floodTime) {
        for (int r = 0; r < rows; ++r) {
            for (int c = 0; c < columns; ++c) {
                if (land.get(r).get(c).equals(FLOODED)) {
                    queueForFloodTime.add(new Point(r, c));
                    minTimeToFlood[r][c] = floodTime;
                }
            }
        }
    }

    private void initializeQueueForDestinationTime(Queue<Point> queueForDestinationTime) {
        for (int r = 0; r < rows; ++r) {
            for (int c = 0; c < columns; ++c) {
                if (land.get(r).get(c).equals(START)) {
                    queueForDestinationTime.add(new Point(r, c));
                    return;
                }
            }
        }
    }

    private boolean isValidPointToFlood(int row, int column) {
        return isInBoundary(row, column)
                && minTimeToFlood[row][column] == NOT_FLOODED
                && (land.get(row).get(column).equals(EMPTY)
                || land.get(row).get(column).equals(START));
    }

    private boolean isValidPointToStep(int row, int column, int currentTime) {
        return isInBoundary(row, column)
                && ((minTimeToFlood[row][column] > currentTime
                && land.get(row).get(column).equals(EMPTY))
                || land.get(row).get(column).equals(DESTINATION));
    }

    private boolean isInBoundary(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }
}