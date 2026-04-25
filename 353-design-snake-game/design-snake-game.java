class SnakeGame {
    Deque<int[]> queue = new ArrayDeque<>();
    Set<Integer> grid;
    int score;
    int width;
    int height;
    int foodPtr = 0;
    int[][] food;
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.grid = new HashSet<>();
        this.food = food;
        this.score = 0;
        grid.add(0);
        queue.add(new int[]{0,0});
    }
    
    public int move(String direction) {
        if(score==-1) return score;
        int[] pos = queue.peekLast();
        int newY = pos[0];
        int newX = pos[1];
        if(direction.equals("R")){
            newY+=1;
        }else if(direction.equals("L")){
            newY-=1;
        }else if(direction.equals("U")){
            newX-=1;
        }else if(direction.equals("D")){
            newX+=1;
        }
        if(newX<0||newY<0||newY>=width||newX>=height){
            score = -1;
            return score;
        }
        int newPos = newY*10000+newX;
        if(foodPtr<food.length && food[foodPtr][0]==newX &&food[foodPtr][1]==newY){
            foodPtr++;
            score +=1;
        }else{
            int[] tail = queue.pollFirst();
            int tailPos = tail[0]*10000+tail[1];
            grid.remove(tailPos);
        }
        if(grid.contains(newPos)){
            score = -1;
        }else{
            grid.add(newPos);
        }
        queue.add(new int[]{newY,newX});
        return score;
    }
}

class SnakeGameInitial {
    Deque<int[]> queue = new ArrayDeque<>();
    int[][] grid;
    int score;
    int width;
    int height;
    int foodPtr = 0;
    int[][] food;
    public SnakeGameInitial(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.grid = new int[width][height];
        this.food = food;
        this.score = 0;
        grid[0][0] = 1;
        queue.add(new int[]{0,0});
    }
    
    public int move(String direction) {
        if(score==-1) return score;
        int[] pos = queue.peekLast();
        int newY = pos[0];
        int newX = pos[1];
        if(direction.equals("R")){
            newY+=1;
        }else if(direction.equals("L")){
            newY-=1;
        }else if(direction.equals("U")){
            newX-=1;
        }else if(direction.equals("D")){
            newX+=1;
        }
        if(newX<0||newY<0||newY>=width||newX>=height){
            score = -1;
            return score;
        }
        if(foodPtr<food.length && food[foodPtr][0]==newX &&food[foodPtr][1]==newY){
            foodPtr++;
            score +=1;
        }else{
            int[] tail = queue.pollFirst();
            grid[tail[0]][tail[1]] = 0;
        }
        if(grid[newY][newX]==1){
            score = -1;
        }else{
            grid[newY][newX] = 1;
        }
        queue.add(new int[]{newY,newX});
        return score;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */