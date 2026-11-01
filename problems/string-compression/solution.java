class Solution {
    public int compress(char[] chars) {
        int n = chars.length;

        if (n == 1)
            return n;

        int read = 0;
        int write = 0;
        int count = 0;

        while (read < n) {
            char current = chars[read];

            while (read < n && chars[read] == current) {
                count++;
                read++;
            }

            chars[write++] = current;

            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
            count = 0;
        }

        return write;
    }
}