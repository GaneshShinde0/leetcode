/**
 * Definition for a category handler.
 * class CategoryHandler {
 *     public CategoryHandler(int[] categories);
 *     public boolean haveSameCategory(int a, int b);
 * };
 */
class Solution {
	public int numberOfCategories(int n, CategoryHandler categoryHandler) {
    	int[] freq = new int[100];
        int res = 0;
        int temp = n;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(categoryHandler.haveSameCategory(i,j)){
                    if(freq[i]==0) res++;
                    freq[i]++;
                    temp--;
                    break;
                }else{
                    freq[i]++;
                    freq[j]++;
                    if(freq[i]==0) res++;
                    if(freq[j]==0) res++;
                }
            }
        }
        return temp;
	}
}