class Solution {
    public List<List<Integer>> generate1MS(int numRows) {
        List<List<Integer>> pascalsTriangle = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        row.add(1);
        pascalsTriangle.add(row);
        for(int i=1; i<numRows;i++){
            row = new ArrayList<>();
            row.add(1);
            prev = pascalsTriangle.get(i-1);
            for (int j=1;j<i;j++){
                row.add(prev.get(j-1)+prev.get(j));
            }
            row.add(1);
            pascalsTriangle.add(row);
        }
        return pascalsTriangle;
    }
    //Optimized solutio takes 1 ms
    public List<List<Integer>> generate1ms(int numRows) {
        List<List<Integer>> pascalsTriangle = new ArrayList<>();
        if (numRows == 0) return pascalsTriangle;
        
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1); // First and last elements are always 1
                } else {
                    row.add(pascalsTriangle.get(i - 1).get(j - 1) + pascalsTriangle.get(i - 1).get(j));
                }
            }
            pascalsTriangle.add(row);
        }
        
        return pascalsTriangle;
    }





























    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalsTriangle = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0||j==i) row.add(1);
                else{
                    row.add(pascalsTriangle.get(i-1).get(j-1)+pascalsTriangle.get(i-1).get(j));
                }
            }
            pascalsTriangle.add(row);
        }
        return pascalsTriangle;
    }
}

/*
To get element at n'th Row and r'th Column
We can user nCr => n!/((n-r)!*r!)

10 C 3

res = 1;
for(int i=0;i<r;i++){
    res = res *(n-i)
    res = res/(i+1);
}

Time: O(r); from nCr


Find nth Row:

Example 6th Row.

1 5 10 10 5 1

7th Row
1 6 15 20 15 6 1

List<Integer> result = new ArrayList<>();
for(int i=0;i<=n;i++){
    if(i==0||i==n) result.add(1);
    else{
        int ans = result.get(i-1);
        ans = ans*(n-i);
        ans = ans/(i); 
    }
}
*/