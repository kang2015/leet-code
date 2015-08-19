class Solution {
private:
    stack<int> nums;
    stack<char> ops;
public:
    void calhelper(){
        char op = ops.top();ops.pop();
        int n1 = nums.top();nums.pop();
        int n2 = nums.top();nums.pop();
        if(op == '+') nums.push(n1+n2);
        else if(op == '-') nums.push(n2-n1);
    }
    int calculate(string s) {
        int i=0;
        while(i<s.length()){
            if(s[i] >= '0' && s[i] <= '9'){
                int cur = 0;
                while(i<s.length() && s[i] >= '0' && s[i] <= '9'){
                    cur = cur*10 + s[i] - '0';
                    i++;
                }
                nums.push(cur);
            }else if(s[i] == '('){
                ops.push('(');
                i++;
            }else if(s[i] == ')'){
                while(ops.top() != '('){
                    calhelper();
                }
                ops.pop();
                i++;
            }else if(s[i] == '+' || s[i] == '-' ){
                while(!ops.empty() && ops.top() != '('){
                    calhelper();
                }
                ops.push(s[i]);
                i++;
            }else{//space
                i++;
            }
        }
        while(!ops.empty()){
            calhelper();
        }
        return nums.top();
    }
};
