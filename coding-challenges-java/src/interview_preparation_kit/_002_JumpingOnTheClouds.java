package interview_preparation_kit;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
There is a new mobile game that starts with consecutively numbered clouds. Some of the clouds are thunderheads and others
are cumulus. The player can jump on any cumulus cloud having a number that is equal to the number of the current cloud
plus 1 or 2. The player must avoid the thunderheads. Determine the minimum number of jumps it will take to jump from the
starting position to the last cloud. It is always possible to win the game.

For each game, you will get an array of clouds numbered 0 if they are safe or 1 if they must be avoided.

- given:
[0, 0, 1, 0, 0, 1, 0]
- the function should return:
4

- given:
[0, 0, 0, 0, 1, 0]
- the function should return:
3

- given:
[0, 0, 0, 1, 0, 0]
- the function should return:
3

 */

public class _002_JumpingOnTheClouds {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        System.out.println("Give me the clouds!");
        String inputClouds = scanner.nextLine();

        List<Integer> clouds = Arrays.stream(inputClouds.substring(1, inputClouds.length() - 1).split(", "))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();

        System.out.println(jumpingOnClouds(clouds));

        scanner.close();

    }

    public static int jumpingOnClouds(List<Integer> clouds) {

        int counter = 0;

        for (int i = 0; i < clouds.size() - 1; i++) {
            if (i == clouds.size() - 2) counter++;
            else {
                if (clouds.get(i) == 0 && clouds.get(i + 2) == 0) {
                    counter ++;
                    i++;
                } else {
                    counter ++;
                }
            }
        }

        return counter;

    }

}
