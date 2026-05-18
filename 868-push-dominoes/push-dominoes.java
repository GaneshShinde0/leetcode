class Solution {
    public String pushDominoes(String dominoes) {
        char[] arr = dominoes.toCharArray();
        int i=0, n = dominoes.length(), dots=0;
        StringBuilder sb = new StringBuilder();
        char prev = 'L';
        for(char c:arr){
            if(c=='L'||c=='R'){
                int half = dots/2;
                if(prev=='R' && c=='L'){
                    sb.append("R".repeat(half));
                    if(dots%2==1) sb.append('.');
                    sb.append("L".repeat(half));
                }else if(prev=='L' && c=='R'){
                    sb.append(".".repeat(dots));
                }else if(prev=='R'){
                    sb.append("R".repeat(dots));
                }else if(c=='L'){
                    sb.append("L".repeat(dots));
                }
                sb.append(c);
                dots=0;
                prev = c;
            }else{
                dots++;
            }
        }
        if(dots!=0 && prev == 'R'){
            sb.append("R".repeat(dots));
        }else if(dots!=0 && prev == 'L'){
            sb.append(".".repeat(dots));
        }
        return sb.toString();
    }

    public String pushDominoesDoesNotWork(String dominoes) {
        char[] arr = dominoes.toCharArray();
        int i=0, n = dominoes.length();
        if(n>1 && arr[i]=='R' && arr[i+1]=='.') arr[i+1]= 'P';
        else if(n>1 && arr[i]=='P' && arr[i+1]!='L') arr[i]='R';
        for(i=1;i<arr.length-1;i++){
            if(arr[i]=='L' && arr[i-1]=='P') arr[i-1]= '.';
            else if(arr[i]=='L' && arr[i-1]=='.') arr[i-1]= 'L';
            else if(arr[i]=='R' && arr[i+1]=='.') arr[i+1]= 'P';
            else if(arr[i]=='P' && arr[i+1]!='L') arr[i]='R';
        }
        if(n>1 && arr[n-1]=='L' && arr[n-2]=='P') arr[n-2]= '.';
        else if(n>1 && arr[n-1]=='L' && arr[n-2]=='.') arr[n-2]= 'L';
        else if(n>1 && arr[n-1]=='P') arr[n-1]='R';
        return new String(arr);
    }
}