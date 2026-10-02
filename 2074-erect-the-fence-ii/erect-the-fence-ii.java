import java.util.*;

class Solution {
    private static class Circle {
        double x, y, r;
        Circle(double x, double y, double r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
        boolean contains(int[] p) {
            double dx = p[0] - x;
            double dy = p[1] - y;
            return dx*dx + dy*dy <= r*r + 1e-9;
        }
    }

    public double[] outerTrees(int[][] trees) {
        // Перемешиваем точки для рандомизации
        List<int[]> points = new ArrayList<>();
        for (int[] tree : trees) {
            points.add(tree);
        }
        Collections.shuffle(points, new Random());
        
        // Начинаем с пустой окружности
        Circle c = null;
        for (int i = 0; i < points.size(); i++) {
            if (c == null || !c.contains(points.get(i))) {
                c = makeCircleFrom(points, i);
            }
        }
        
        return new double[]{c.x, c.y, c.r};
    }

    private Circle makeCircleFrom(List<int[]> points, int i) {
        // Окружность из одной точки
        Circle c = new Circle(points.get(i)[0], points.get(i)[1], 0);
        
        for (int j = 0; j < i; j++) {
            if (!c.contains(points.get(j))) {
                c = makeCircleFromTwo(points, i, j);
            }
        }
        return c;
    }

    private Circle makeCircleFromTwo(List<int[]> points, int i, int j) {
        int[] p1 = points.get(i);
        int[] p2 = points.get(j);
        Circle c = circleFromDiameter(p1, p2);
        
        for (int k = 0; k < j; k++) {
            if (!c.contains(points.get(k))) {
                c = circleFromThree(p1, p2, points.get(k));
            }
        }
        return c;
    }

    private Circle circleFromDiameter(int[] a, int[] b) {
        double cx = (a[0] + b[0]) / 2.0;
        double cy = (a[1] + b[1]) / 2.0;
        double r = Math.hypot(a[0] - b[0], a[1] - b[1]) / 2.0;
        return new Circle(cx, cy, r);
    }

    private Circle circleFromThree(int[] a, int[] b, int[] c) {
        double ax = a[0], ay = a[1];
        double bx = b[0], by = b[1];
        double cx = c[0], cy = c[1];

        // Проверка на коллинеарность
        double d = 2 * (ax * (by - cy) + bx * (cy - ay) + cx * (ay - by));
        
        if (Math.abs(d) < 1e-9) {
            // Точки коллинеарны - ищем диаметр с максимальным расстоянием
            double dAB = Math.hypot(ax - bx, ay - by);
            double dAC = Math.hypot(ax - cx, ay - cy);
            double dBC = Math.hypot(bx - cx, by - cy);
            
            if (dAB >= dAC && dAB >= dBC) {
                return circleFromDiameter(a, b);
            } else if (dAC >= dAB && dAC >= dBC) {
                return circleFromDiameter(a, c);
            } else {
                return circleFromDiameter(b, c);
            }
        }

        // Формула для центра описанной окружности треугольника
        double ux = ((ax*ax + ay*ay) * (by - cy) + 
                     (bx*bx + by*by) * (cy - ay) + 
                     (cx*cx + cy*cy) * (ay - by)) / d;
        
        double uy = ((ax*ax + ay*ay) * (cx - bx) + 
                     (bx*bx + by*by) * (ax - cx) + 
                     (cx*cx + cy*cy) * (bx - ax)) / d;
        
        double r = Math.hypot(ux - ax, uy - ay);
        return new Circle(ux, uy, r);
    }
}