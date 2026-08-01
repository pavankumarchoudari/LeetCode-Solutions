class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int[] temp = new int[flowerbed.length + 2];

        for (int i = 0; i < flowerbed.length; i++) {
            temp[i + 1] = flowerbed[i];
        }

        int count = 0;

        for (int i = 1; i <= flowerbed.length; i++) {

            if (temp[i - 1] == 0 && temp[i] == 0 && temp[i + 1] == 0) {
                temp[i] = 1;
                count++;
            }
        }

        return count >= n;
    }
}