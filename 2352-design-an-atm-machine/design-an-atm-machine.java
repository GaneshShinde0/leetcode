class ATM {
    int[] countOfNotes;
    int[] denominations = {500,200,100,50,20};
    public ATM() {
        this.countOfNotes = new int[5];
    }
    
    public void deposit(int[] banknotesCount) {
        for(int i=0;i<5;i++){
            countOfNotes[i]+=banknotesCount[i];
        }
    }
    
    public int[] withdraw(int amount) {
        int[] withdrawnNotes = new int[5];
        for(int i=0;i<5;i++){
            if(amount>=denominations[i]){
                int notes = Math.min(countOfNotes[4-i] ,amount/denominations[i]);
                amount -= notes*denominations[i];
                withdrawnNotes[4-i]=notes;
                this.countOfNotes[4-i]-=notes;
            }
        }
        if(amount!=0){
            for(int i=0;i<5;i++){
                this.countOfNotes[i]+=withdrawnNotes[i];
            }
            return new int[]{-1};
        }
        return withdrawnNotes;
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */