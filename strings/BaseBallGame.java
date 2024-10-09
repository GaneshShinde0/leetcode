import java.util.ArrayList;
import java.util.List;

class Solution {
    public int calPoints8ms(String[] operations) {
        List<Integer> li = new ArrayList<>();
        for (String str : operations) {
            try {
                // Try to parse the string as an integer
                int value = Integer.parseInt(str);
                li.add(value);
            } catch (NumberFormatException e) {
                // Handle other operations if parsing fails
                if (str.equals("+") && li.size() >= 2) {
                    li.add(li.get(li.size() - 1) + li.get(li.size() - 2));
                } else if (str.equals("D") && li.size() >= 1) {
                    li.add(li.get(li.size() - 1) * 2);
                } else if (str.equals("C") && li.size() >= 1) {
                    li.remove(li.size() - 1);
                }
            }
        }

        int sum = 0;
        for (int score : li) {
            sum += score;
        }
        return sum;
    }

    public int calPoints(String[] operations) {
        int[] scores = new int[operations.length];
        int index = 0;

        for (String s : operations) {
            switch (s) {
                case "C":
                    index--;
                    break;
                case "D":
                    scores[index] = scores[index - 1] * 2;
                    index++;
                    break;
                case "+":
                    scores[index] = scores[index - 1] + scores[index - 2];
                    index++;
                    break;
                default:
                    scores[index] = Integer.parseInt(s);
                    index++;
                    break;
            }
        }

        int sum = 0;
        for (int i = 0; i < index; i++) {
            sum += scores[i];
        }

        return sum;
    }
}
