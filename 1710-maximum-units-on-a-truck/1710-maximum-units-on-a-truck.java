class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {

        // Sort by units per box in descending order
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int totalUnits = 0;

        for (int i = 0; i < boxTypes.length; i++) {

            int numberOfBoxes = boxTypes[i][0];
            int unitsPerBox = boxTypes[i][1];

            // Take all boxes if possible
            if (numberOfBoxes <= truckSize) {
                totalUnits += numberOfBoxes * unitsPerBox;
                truckSize -= numberOfBoxes;
            }
            // Otherwise, take only the remaining boxes that fit
            else {
                totalUnits += truckSize * unitsPerBox;
                break;
            }
        }

        return totalUnits;
    }
}