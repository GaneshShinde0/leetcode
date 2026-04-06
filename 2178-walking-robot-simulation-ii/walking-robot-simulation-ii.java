class Robot{
    private boolean moved = false;
    private int idx = 0;
    private List<int[]> pos = new ArrayList<>();
    private List<Integer> dir = new ArrayList<>();
    private Map<Integer, String> toDir = new HashMap<>();

    public Robot(int width, int height){
        toDir.put(0,"East");
        toDir.put(1,"North");
        toDir.put(2,"West");
        toDir.put(3,"South");

        for(int i=0;i<width;i++){
            pos.add(new int[]{i,0});
            dir.add(0);
        }
        for(int i=1;i<height;i++){
            pos.add(new int[]{width-1,i});
            dir.add(1);
        }
        for(int i=width-2;i>=0;i--){
            pos.add(new int[]{i,height-1});
            dir.add(2);
        }
        for(int i= height-2;i>0;--i){
            pos.add(new int[]{0,i});
            dir.add(3);
        }
        dir.set(0,3);
    }

    public void step(int num){
        moved = true;
        idx = (idx+num)%pos.size();
    }
    public int[] getPos(){
        return pos.get(idx);
    }
    public String getDir(){
        if(!moved) return "East";
        return toDir.get(dir.get(idx));
    }
}

class RobotInitial {
    int x;
    int y;
    int width;
    int height;
    int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    int d;
    int perimeter;
    HashMap<Integer,String> dirMap = new HashMap<>();
    public RobotInitial(int width, int height) {
        this.d = 0;
        this.x = 0;
        this.y = 0;
        this.width = width;
        this.height = height;
        dirMap.put(0,"East");
        dirMap.put(1,"North");
        dirMap.put(2,"West");
        dirMap.put(3,"South");
        this.perimeter = 2*width+2*height-4;
    }
    public void step(int num) {
        // 1. Efficiency: A full lap returns the robot to the same spot.
        // However, we must distinguish between step(0) and step(perimeter).
        if (num == 0) return;
        num %= perimeter;
        if (num == 0) num = perimeter; 

        while (num > 0) {
            // 2. Calculate steps possible in current direction
            int stepsToBoundary = 0;
            if (d == 0) stepsToBoundary = (width - 1) - x;      // East
            else if (d == 1) stepsToBoundary = (height - 1) - y; // North
            else if (d == 2) stepsToBoundary = x;               // West
            else if (d == 3) stepsToBoundary = y;               // South

            // 3. If we are at a corner and blocked, turn immediately
            if (stepsToBoundary == 0) {
                d = (d + 1) % 4;
                continue;
            }

            // 4. Move as much as possible
            int move = Math.min(num, stepsToBoundary);
            x += dirs[d][0] * move;
            y += dirs[d][1] * move;
            num -= move;

            // 5. If we hit the boundary and still have steps, we MUST turn
            if (num > 0) {
                d = (d + 1) % 4;
            }
        }
    }

    public void stepInitial(int num) {
        while(num>0){
            int xPlus = dirs[d][0],yPlus = dirs[d][1];
            if((x+xPlus)<0 || (y+yPlus)<0 || (y+yPlus)>=height || (x+xPlus)>=width){
                d=(d+1)%4;
            }else{
                if(xPlus==-1){
                    int oldX = x;
                    x=Math.max(x-num,0);
                    num-=oldX-x;
                }else if(xPlus==1){
                    int oldX = x;
                    x=Math.min(x+num,width-1);
                    num-=x-oldX;
                }else if(yPlus == -1){
                    int oldY = y;
                    y=Math.max(y-num,0);
                    num-=oldY-y;
                }else if(yPlus == 1){
                    int oldY = y;
                    y=Math.min(y+num,height-1);
                    num-=y-oldY;
                }
            }
        }
    }
    
    public int[] getPos() {
        return new int[]{x,y};
    }
    
    public String getDir() {
        return dirMap.get(this.d);
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */