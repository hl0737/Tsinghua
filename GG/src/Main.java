public class Main {
    public static void main(String[] args) {
        double totalMoney = 0;
        int totalLength = 0;
        double[][] a = {
                {},
                {},
                {},
                {},
        };
        for (int i = 0; i < a.length; i++) {
            double rowSum = 0;
            int length = 0;
            for (int j = 0; j < a[i].length; j++) {
                rowSum += a[i][j];
                length++;
            }
            totalMoney += rowSum;
            totalLength += length;
            System.out.println("第" + (i+1) + "行: " + rowSum + ", length = " + length);
        }
        System.out.println("总金额：" + totalMoney + " , 总张数：" + totalLength);
    }
}
