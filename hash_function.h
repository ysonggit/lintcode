class Solution {
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     * overflow 
     * (a + b) % p = (a % p + b % p) % p 
     * (a - b) % p = (a % p - b % p) % p （2）
        (a * b) % p = (a % p * b % p) % p （3）
        a ^ b % p = ((a % p)^b) % p （4）
     */
    public int modMultiply(int ascii, int base, int HASH_SIZE){
        long temp = (long) ascii * base % HASH_SIZE;
        return (int) temp;
    }
    public int hashCode(char[] key,int HASH_SIZE) {
        int sum = 0;
        int n = key.length;
        int base = 1;
        for(int i=n-1; i>=0; i--){
            sum += modMultiply((int)key[i], base, HASH_SIZE);
            sum %= HASH_SIZE;
            base = modMultiply(base, 33, HASH_SIZE);
        }
        int hashcode = sum % HASH_SIZE;
        return hashcode;
    }
};
