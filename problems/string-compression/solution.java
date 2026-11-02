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
                int divisor = 1;
                while(divisor <= count / 10){
                    divisor *= 10;
                }
                while(divisor > 0){
                    chars[write++] = (char)('0' + count / divisor);
                    count %= divisor;
                    divisor /= 10;
                }
            }
            count = 0;
        }

        return write;
    }
}