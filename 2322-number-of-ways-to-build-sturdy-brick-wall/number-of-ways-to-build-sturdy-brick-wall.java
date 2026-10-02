class Solution {
    public int buildWall(int height, int width, int[] bricks) {
        int mod = 1000000007;
        
        ArrayList<Integer> buildLayer = waysOfBuildLayerRecursive(width, bricks);
        if (height == 1) {
            return buildLayer.size();
        }

        ArrayList<ArrayList<Integer>> nexts = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < buildLayer.size(); i++) {
            int split = buildLayer.get(i);
            ArrayList<Integer> next = new ArrayList<Integer>();
            for (int j = 0; j < buildLayer.size(); j++) {
                int nextSplit = buildLayer.get(j);
                if ((split & nextSplit) == 0) {
                    next.add(j);
                }
            }
            nexts.add(next);
        }

        int[] thisLayer = new int[buildLayer.size()];
        Arrays.fill(thisLayer, 1);
        
        for (int i = 1; i < height; i++) {
            int[] nextLayer = new int[buildLayer.size()];
            for (int j = 0; j < thisLayer.length; j++) {
                ArrayList<Integer> next = nexts.get(j);
                for (int nextSplit : next) {
                    nextLayer[nextSplit] = (nextLayer[nextSplit] + thisLayer[j]) % mod;
                }
            }
            thisLayer = nextLayer;
        }
        int result = 0;
        for (int num : thisLayer) {
            result = (result + num) % mod;
        }
        return result;
    }
    
    private ArrayList<Integer> waysOfBuildLayerRecursive(int width, int[] bricks) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        waysOfBuildLayerRecursive(new Stack<Integer>(), width, bricks, result);
        return result;
    }
    
    private void waysOfBuildLayerRecursive(Stack<Integer> stack, int width, int[] bricks, ArrayList<Integer> result) {
        if (width == 0) {
            result.add(stack2int(stack));
            return;
        }
        for (int brick : bricks) {
            if (brick <= width) {
                stack.push(brick);
                waysOfBuildLayerRecursive(stack, width - brick, bricks, result);
                stack.pop();
            }
        }
        return;
    }
    
    private int stack2int(Stack<Integer> stack) {
        int result = -1;
        for (int brick : stack) {
            result++;
            result = result << (brick);
        }
        return result;
    }
}