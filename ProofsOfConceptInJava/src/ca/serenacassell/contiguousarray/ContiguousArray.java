package ca.serenacassell.contiguousarray;

public class ContiguousArray {

    /**
     * int[] return largest sum of continuous-numbers
     * Example Array: {-2,1,-3,4,-1,2,1,-5,4}
     */

    private static int[] getLargestSum(int[] inArray) {
        int finalSum = 0, startIdx = 0, endIdx = 0, totalTilNow = 0;
        if (inArray != null && inArray.length > 0) {
            //set to first element in the array as default
            finalSum = inArray[0];
            for (int x = 0; x < inArray.length; x++) {
                if (inArray[x] > finalSum) {
                    //Reset everything
                    startIdx = x;
                    endIdx = x;
                    finalSum = inArray[x];
                    totalTilNow = inArray[x];
                } else {
                    totalTilNow += inArray[x];
                    if (totalTilNow > finalSum) {
                        //Set the updated end details
                        finalSum = totalTilNow;
                        endIdx = x;
                    }
                }
            }
        }
        return new int[]{finalSum, startIdx, endIdx};
    }

    private static String formatResults(int[] inArray, int[] outDetails) {
        int sumAmount = outDetails[0], startIdx = outDetails[1], endIdx = outDetails[2];
        StringBuilder out = new StringBuilder("{"), subArray = new StringBuilder("{");

        for (int x = 0; x < inArray.length; x++) {
            if ("{".equals(out.toString())) {
                out.append(inArray[x]);
            } else {
                out.append(",").append(inArray[x]);
            }

            if (x >= startIdx && x <= endIdx) {
                if ("{".equals(subArray.toString())) {
                    subArray.append(inArray[x]);
                } else {
                    subArray.append(",").append(inArray[x]);
                }
            }
        }
        out.append("}");
        subArray.append("}");
        return "Input: " + out + " Sub-array: " + subArray + " Sum: " + sumAmount;
    }


    private static void doTest(int testNumber, int[] testArray, int[] expected) {
        int[] result = getLargestSum(testArray);

        if (result.length == 3 && result[0] == expected[0] &&
                result[1] == expected[1] && result[2] == expected[2]) {
            System.out.println("doTest-" + testNumber + " passed. " + formatResults(testArray, result));
        }
    }

    private static void performAllTests() {
        doTest(1, new int[]{}, new int[]{0, 0, 0});
        doTest(2, new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, new int[]{6, 3, 6});
        doTest(3, new int[]{-2, -1, -4, -6, -3, -100}, new int[]{-1, 1, 1});
        doTest(4, new int[]{1, 6, 12, 42, -100, 82, 2}, new int[]{84, 5, 6});
        doTest(5, new int[]{12}, new int[]{12, 0, 0});
    }

    public static void main(String[] args) {
        performAllTests();
    }

}

