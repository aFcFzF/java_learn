import java.util.*;

class Main {
	public static void main(String[] args) {
        int[] a = {3, 1, 2};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

        int[] arr = {2, 1, 2, 1, 0, 0, 1};
        new Main().maxProfit(arr);
    }

    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int min = prices[0];
        int maxSale = 0;

        for (int num: prices) {
            if (num < min) {
                min = num;
                continue;
            }

            int sale = num - min;
            if (sale > maxSale) {
                maxSale = sale;
            }
        }

        return maxSale;
    }
}