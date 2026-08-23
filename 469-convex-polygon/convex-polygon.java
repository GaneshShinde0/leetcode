class Solution {
    public boolean isConvex(List<List<Integer>> points) {
        boolean left = false, right = false;
        int n = points.size();
        for(int i=0;i<n;i++){
            int j = (i+1)%n, k = (i+2)%n;
            int crossProduct = crossProduct(
                points.get(i).get(0), points.get(i).get(1),
                points.get(j).get(0), points.get(j).get(1),
                points.get(k).get(0), points.get(k).get(1)
            );
            if(crossProduct<0) left = true;
            else if(crossProduct>0) right = true;
            if(left&&right) return false;
        }
        return true;
    }

    private int crossProduct(int Ax, int Ay, int Bx, int By, int Cx, int Cy){
        return (Bx-Ax)*(Cy-By)-(By-Ay)*(Cx-Bx);
    }
}