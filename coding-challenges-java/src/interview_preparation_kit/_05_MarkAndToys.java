package interview_preparation_kit;

import java.util.*;
import java.util.stream.Collectors;

/*
Mark and Jane are very happy after having their first child. Their son loves toys, so Mark wants to buy some. There are
a number of different toys lying in front of him, tagged with their prices. Mark has only a certain amount to spend,
and he wants to maximize the number of toys he buys with this money. Given a list of toy prices and an amount to spend,
determine the maximum number of gifts he can buy. Each toy can be purchased only once.

Input:
 - the amount Mark has to spend
 - prices of the toys
Return:
 - the maximum number of toys Mark can buy

- given:
50
1 12 5 111 200 1000 10
- the function should return:
4

- given:
7
1 2 3 4
- the function should return:
3

- given:
22
12 3 1 4 7 10 1000 2
- the function should return:
5

 */

public class _05_MarkAndToys {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Give me the budget!");
        String inputBudget = scanner.nextLine();
        int budget = Integer.parseInt(inputBudget);
        System.out.println("Give me the prices of the toys!");
        String inputPrices = scanner.nextLine();
        List<Integer> prices = Arrays.stream(inputPrices.split(" "))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println(maximumToys(prices, budget));

        scanner.close();

    }
    public static int maximumToys(List<Integer> prices, int budget) {
        int maxToys = 0;

        while (budget > 0) {
            int cheapest = Collections.min(prices);
            if (budget >= cheapest) {
                budget -= cheapest;
                prices.remove(Integer.valueOf(cheapest));
                maxToys++;
            } else {
                break;
            }
        }

        return maxToys;

    }

}
