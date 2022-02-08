class Bitset {
      private int len;
    private int [] bits;
    private int [] flipBits;
    private int count1;
	
    public Bitset(int size) {
        len=size;
        bits = new int [size];
        count1=0;
        flipBits = new int [size];
        Arrays.fill(flipBits,1);
    }
	
    public void fix(int idx) {
        if(bits[idx]==0){
            count1++;
        }
        bits[idx]=1;
        flipBits[idx]=0;
    }
    
    public void unfix(int idx) {
        if(bits[idx]==1){
            count1--;
        }
        bits[idx]=0;
        flipBits[idx]=1;
    }
    
    public void flip() {
        int [] temp = flipBits;
        flipBits = bits;
        bits=temp;
        count1 = len-count1;
    }
    
    public boolean all() {
        return count1==len;
    }
    
    public boolean one() {
        return count1>0;
    }
    
    public int count() {
        return count1;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<len;i++){
            sb.append(bits[i]);
        }
        return sb.toString();
    }
}

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */