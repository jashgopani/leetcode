class Solution {
    public String addBinary(String a, String b) {
        int len = Math.max(a.length(),b.length())-1;
        int ia = a.length()-1;
        int ib = b.length()-1;
        int s = 0, c=0;
        StringBuilder sb = new StringBuilder(len+2);

        while(len>=0){
            int sum=c;
            if(ia>=0){
                sum+= (a.charAt(ia)- '0');
                ia--;
            }
            if(ib>=0){
                sum+= (b.charAt(ib) - '0');
                ib--;
            }
            // print("len:",len,"sum:",sum);
            len--;
            switch(sum){
                case 1:
                    sb.insert(0,1);
                    c=0;
                    break;
                case 2:
                    sb.insert(0,0);
                    c=1;
                    break;
                case 3:
                    sb.insert(0,1);
                    c=1;
                    break;
                default://case 0
                    c = 0;
                    sb.insert(0,0);
            }
        }
        if(c==1 || sb.length()==0)
            sb.insert(0,c);
        
        return sb.toString();

    }

    public static void print(Object... args){
        for(Object o:args){
            System.out.printf(o+" ");
        }
        System.out.println();
    }

}