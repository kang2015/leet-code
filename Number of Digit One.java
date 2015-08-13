public class Solution {
    public int countDigitOne(int n) {
        int iFactor = 1;
        int iCount = 0;
        int iLowerNum = 0;
        int iCurrNum = 0;
        int iHigherNum = 0;
        while(n/iFactor>=10){// "10" not "1" to prevent overflow
            iLowerNum = n - (n/iFactor)*iFactor;
            iCurrNum = n/iFactor%10;
            iHigherNum = n/(iFactor*10);
            switch(iCurrNum){
                case 0:
                    iCount += iHigherNum*iFactor;
                    break;
                case 1:
                    iCount += iHigherNum*iFactor + iLowerNum +1;
                    break;
                default:
                    iCount += (iHigherNum+1)*iFactor;
                    break;
            }
            iFactor *= 10;
        }
        iCurrNum = n/iFactor;
        if(iCurrNum<=0) return iCount;
        iCount += iCurrNum==1?(n%iFactor+1):iFactor;
        return iCount;
    }
}
