class Solution 
{
public:
    string countAndSay(int n) 
    {
        // [1] only 3 repetitions of any digit is possible, thus,
        //     we can list all possible boundaries between blocks
        map<string,string> sep = {{"12", "1|2"}, {"21", "2|1"}, {"13", "1|3"},
                                  {"31", "3|1"}, {"23", "2|3"}, {"32", "3|2"}};
        
        string say = "1";
        string block;
        
        // [2] on each iteration:
        //     - first, place separators between blocks
        //     - second, split using separators and build new saying
        for (int i = 0; i < n-1; ++i)
        {
            for(auto [src, dst]: sep) 
                say = regex_replace(say, regex(src), dst);
            
            istringstream ss(say);
            string new_say = "";
            new_say.reserve(4500);
            while(getline(ss, block, '|')) 
                new_say += to_string(block.size()) + block[0];
            say = new_say;
        }
        
        return say;
    }
};