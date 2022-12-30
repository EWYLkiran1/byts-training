class Solution {
public:
    bool isAdditiveNumber(string num) {
        int n=num.length();
        for(int i=0;i<min(17,n);i++){
            if((i>0)&&(num[0]=='0')){
                return false;
            }
            long long num1=stoll(num.substr(0,i+1)),temp1=num1;
            for(int j=i+1;j<min(i+18,n);j++){
                long long num2=stoll(num.substr(i+1,j-i));
                if((j>i+1)&&(num[i+1]=='0')){
                    break;
                }
                int prev=j;
                for(int k=j+1;k<min(prev+18,n);k++){
                    long long num3=stoll(num.substr(prev+1,k-prev));
                    if((k>prev+1)&&(num[prev+1]=='0')){
                        break;
                    }
                    if(num3-num2==num1){
                        num1=num2;
                        num2=num3;
                        prev=k;
                        if(k==n-1){
                            return 1;
                        }
                    }
                }
                num1=temp1;
            }
        }
        return false;
    }
};