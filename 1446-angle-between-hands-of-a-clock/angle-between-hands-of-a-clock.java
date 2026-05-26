class Solution {
    public double angleClock(int hour, int minutes) {
        double hourAngle = hour*30+(minutes)*0.5;
        double minAngle = minutes*6;
        double angle = Math.abs(hourAngle-minAngle);
        return Math.min(360-angle,angle);
    }
}