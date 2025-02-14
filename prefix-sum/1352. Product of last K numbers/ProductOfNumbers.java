class ProductOfNumbers {

    private ArrayList<Integer> li;
    int n=0;
    public void ProductOfNumbersInitial() {
        li=new ArrayList<>();
    }
    
    public void addInitial(int num) {
        li.add(num);
        n++;
    }
    
    public int getProductInitial(int k) {
        int prod=1;
        for(int i=n-k;i<n;i++){
            prod*=li.get(i);
        }
        return prod;
    }

    private ArrayList<Integer> prefixProd = new ArrayList<>();
    private int size = 0;

    public ProductOfNumbers(){
        this.prefixProd.add(1);
        this.size = 0;
    }

    public void add(int num){
        if(num==0){
            this.prefixProd = new ArrayList<Integer>();
            this.prefixProd.add(1);
            this.size=0;
        }else{
            this.prefixProd.add(this.prefixProd.get(size)*(num));
            this.size++;
        }
    }

    public int getProduct(int k){
        if(k>this.size) return 0;
        return (this.prefixProd.get(this.size)/this.prefixProd.get(this.size-k));
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
