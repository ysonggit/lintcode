class Solution {
    /**
     * @return: The same instance of this class every time
     * If the program will always need an instance, then create instance using static initializer.
     * This method has a number of advantages:
     * The static initializer is run when the class is initialized, after class loading but before the class is used by any thread.
     * There is no need to synchronize the getInstance() method, meaning all threads will see the same instance and no (expensive) locking is required.
     * The final keyword means that the instance cannot be redefined, ensuring that one (and only one) instance ever exists.
     */
    private static final Solution INSTANCE = new Solution(); // static initializer
    private Solution(){}
    public static Solution getInstance() {
        return INSTANCE;
    }
};

