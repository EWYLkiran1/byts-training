class Solution {
    public NestedInteger deserialize(String s) {
        // 栈 + 对象
        Deque<NestedInteger> stack = new LinkedList<>();
        NestedInteger tmpNi = new NestedInteger();
        Integer tmpInt = null;
        int sign = 1;
        for (char c : s.toCharArray()) {
            if (c == '-') {
                sign = -1;
            }
            if (c == '[') {
                stack.push(tmpNi);
                tmpNi = new NestedInteger();
            }
            if (c == ',') {
                if (tmpInt != null) tmpNi.add(new NestedInteger(tmpInt * sign));
                tmpInt = null;
                sign = 1;
            }
            if (c == ']') {
                if (tmpInt != null) {
                    tmpNi.add(new NestedInteger(tmpInt * sign));
                    tmpInt = null;
                    sign = 1;
                }
                stack.peek().add(tmpNi);
                tmpNi = stack.pop();
            }
            if (Character.isDigit(c)) {
                if (tmpInt == null) tmpInt = c - '0';
                else tmpInt = tmpInt * 10 + (c - '0');
            }
        }
        if (tmpInt != null) return new NestedInteger(tmpInt * sign);
        
        return tmpNi.getList().get(0);
    }
}
