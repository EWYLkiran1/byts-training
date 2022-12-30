class Solution {
    public int compareVersion(String version1, String version2) {
        int len1 = version1.length();
        int len2 = version2.length();
        for (int i1 = 0, i2 = 0; i1 < len1 || i2 < len2; ++i1, ++i2) {
            int curr1 = 0;
            // if has digit for current reivion, get revision number
            // if no reivison number, treat as 0
            while (i1 < len1 && version1.charAt(i1) != '.') {
                curr1 = curr1 * 10 + version1.charAt(i1) - '0';
                ++i1;
            }
            int curr2 = 0;
            while (i2 < len2 && version2.charAt(i2) != '.') {
                curr2 = curr2 * 10 + version2.charAt(i2) - '0';
                ++i2;
            }
            if (curr1 != curr2) {
                return Integer.compare(curr1, curr2);
            }
        }
        return 0;
    }
}