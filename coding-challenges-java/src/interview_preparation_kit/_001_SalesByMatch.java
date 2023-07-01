package interview_preparation_kit;

import java.util.*;

/*
There is a large pile of socks that must be paired by color. Given an array of integers representing the color of each
sock, determine how many pairs of socks with matching colors there are.

- given:
7
[2, 1, 3, 2, 1, 1, 1]
- the function should return:
3

There are 5 socks in the pile, and we have two matching pairs with colours 2, 1, 1.

 */

public class _001_SalesByMatch {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("How many sock are in the pile?");
        String inputNumberOfSocks = scanner.nextLine();
        int numberOfSock = Integer.parseInt(inputNumberOfSocks);
        System.out.println("What are the sock colours in the pile?");
        String inputSocks = scanner.nextLine();

        List<Integer> socks = Arrays.stream(inputSocks.substring(1, inputSocks.length() - 1).split(", "))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();

        System.out.println(sockMerchant(numberOfSock, socks));

        scanner.close();

    }

    public static int sockMerchant(int numberOfSock, List<Integer> socks) {

        Map<Integer, Integer> colorCounts = new HashMap<>();

        // Count the occurrence of each color
        for (int sock : socks) {
            colorCounts.put(sock, colorCounts.getOrDefault(sock, 0) + 1);
        }

        int pairCount = 0;
        // Count the number of matching pairs
        for (int count : colorCounts.values()) {
            pairCount += count / 2;
        }

        return pairCount;

    }

}