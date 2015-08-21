public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int unoin = (C-A)*(D-B)+(G-E)*(H-F);
        if(G<= A || C<= E || D<= F || H <= B ){
            return unoin;
        }
        int newA = Math.max(A,E), newB = Math.max(B,F),newC = Math.min(C,G), newD = Math.min(D,H);
        return unoin - (newC-newA)*(newD-newB);
    }
}
