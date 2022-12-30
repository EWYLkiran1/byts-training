class Solution {
public:
    string fractionToDecimal(int numerator, int denominator) {
        
        long long quotient, remainder;

        long long num = numerator;
        long long den = denominator;

        bool neg = (num < 0 && den > 0) || (num > 0 && den < 0);

        num = abs(num);
        den = abs(den);

        // divide all until only remainder left
        quotient = num / den;
        remainder = num % den;

        string ret = (neg) ? "-" : "";

        ret += to_string(quotient);

        if (!remainder) {
            return ret;
        }

        ret += ".";

        unordered_map<long long,int> rmap;

        int strpos = ret.size();

        while (remainder != 0 && rmap.count(remainder) == 0){
            rmap[remainder] = strpos++;

            remainder *= 10;
            quotient = remainder / den; // will be zero if den > remainder.

            remainder -= den * quotient;
            ret.push_back('0' + quotient); // int to char.
        }

        // either remainder went to zero or we found a duplicate
        if (remainder) {
            // then there was a duplicate:
            ret.insert(rmap[remainder], "(");
            ret.push_back(')');
        }

        return ret;
    }
};