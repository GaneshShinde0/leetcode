/**
 * Definition for a street.
 * class Street {
 *     public Street(int[] doors);
 *     public void closeDoor();
 *     public boolean isDoorOpen();
 *     public void moveRight();
 * }
 */
class Solution {
    public int houseCount(Street street, int k) {
        // No. of steps to reach the first open door
        int xFirst = 0;

        // No. of steps from the current open door to the first open door.
        int distFromFirst = 0;

        // No. of steps in our traversal.
        int x = 0;

        // If we have found (and skipped) the first open door
        boolean findFirst = false;

        while (x <= 2 * k) {
            // If the door is open
            if (street.isDoorOpen()) {
                // If we have skipped the first door, update distFromFirst
                // and close the open door.
                if (findFirst) {
                    distFromFirst = x - xFirst;
                    street.closeDoor();
                }
                // Otherwise, we skip this open door and record its index as xFirst = x.
                else {
                    xFirst = x;
                    findFirst = true;
                }
            }

            // Move to the next house on the right, and increase x by 1.
            street.moveRight();
            x++;
        }

        return distFromFirst;
    }
}