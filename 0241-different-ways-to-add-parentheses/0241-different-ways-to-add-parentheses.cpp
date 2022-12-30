class Solution {
public:
int evaluate(int a, int b, char op) {
        if (op == '+') return a + b;
        if (op == '-') return a - b;
        return a * b;
}
vector<int> solve(string&s, int i, int j) {
	if (i > j) return vector<int>();
	if (i == j) return vector<int>(1, s[i] - '0');
	bool flag = 0;
	int gulp = 0; 
	for(int i1=i;i1<=j;i1++){
		if(s[i1]>='0'&&s[i1]<='9')
			gulp = gulp*10+s[i1]-'0';
		else{
			flag =1;
			break;
		}
	}
	if(flag==0) return vector<int>(1,gulp);
	vector<int> ans;
	for (int k = i; k < j; k++) {
		if (s[k] == '*' || s[k] == '+' || s[k] == '-') {
			vector<int> l = solve(s, i, k - 1);
			vector<int> r = solve(s, k + 1, j);
			for (auto&it1 : l)
				for (auto&it2 : r)
					ans.push_back(evaluate(it1, it2, s[k]));
		}

	}
	return ans;
}

vector<int> diffWaysToCompute(string expression) {
	return solve(expression,0,expression.size()-1);
}
};