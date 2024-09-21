class Solution {
    public List<Integer> lexicalOrderOlogN(int n) {
        List<Integer> li = new ArrayList<>();
        for(int i=1;i<=n;i++){
            li.add(i);
        }
        Collections.sort(li, new Comparator<Integer>(){
            @Override
            public int compare(Integer a,Integer b){
                return (a+"").compareTo(b+"");
            }
        });
        return li;
    }

    public List<Integer> lexicalOrderDFS(int n) {
        List<Integer> li = new ArrayList<>();
        for(int i=1;i<10;i++){
            generateLexicalNumbers(i,n,li);
        }
        return li;
    }

    public void generateLexicalNumbers(int start, int n, List<Integer> li){
        if(start>n) return;
        li.add(start);
        for(int i=0;i<10;i++){
            int nextNumber = start*10+i;
            if(nextNumber<=n){
                generateLexicalNumbers(nextNumber,n,li);
            }else{
                break;
            }
        }
    }


    public List<Integer> lexicalOrder(int n){
        List<Integer> li = new ArrayList<>();
        int num=1;

        for(int i=0;i<n;i++){
            li.add(num);
            if(num*10<=n){
                num = num*10;
            }else{
                while(num%10==9 || num>=n){
                    num/=10;
                }
                num+=1;
            }
        } 
        return li;
    }
}
