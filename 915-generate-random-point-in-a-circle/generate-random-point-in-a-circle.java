class Solution {
    Random random;
    double x,xC;
    double y,yC,radius;
    
    public Solution(double radius, double x_center, double y_center) {
        this.random = new Random();
        this.xC = x_center;
        this.yC = y_center;
        this.radius = radius;
    }
    
    public double[] randPoint() {
        double x0 = xC-radius;
        double y0 = yC-radius;
        double[] res = new double[2];
        while(true){
            double xG = x0+Math.random()*radius*2;
            double yG = y0+Math.random()*radius*2;
            if(Math.sqrt(Math.pow(xG-xC,2)+Math.pow(yG-yC,2))<=radius) return new double[]{xG,yG};
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */