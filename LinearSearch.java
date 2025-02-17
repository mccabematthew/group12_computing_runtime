class LinearSearch {
    public static int linearSearch(int array[], int x) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            if (array[i] == x) {
                return i;
            }
        }
        return -1;
    }
}
