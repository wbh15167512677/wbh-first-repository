class Solution {
    public int calPoints(String[] operations) {
        List<Integer> record = new ArrayList<>();

        for (String op : operations) {
            int size = record.size();

            if (op.equals("+")) {
                // Add the sum of the previous two scores
                int newScore = record.get(size - 1) + record.get(size - 2);
                record.add(newScore);
            } else if (op.equals("D")) {
                // Add double the previous score
                int newScore = record.get(size - 1) * 2;
                record.add(newScore);
            } else if (op.equals("C")) {
                // Remove the previous score
                record.remove(size - 1);
            } else {
                // Add a new integer score
                record.add(Integer.parseInt(op));
            }
        }

        int sum = 0;
        for (int score : record) {
            sum += score;
        }

        return sum;
    }
}