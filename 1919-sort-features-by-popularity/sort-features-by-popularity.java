class Solution {
    public String[] sortFeatures(String[] features, String[] responses) {
        Map<String, Integer> count = Arrays.stream(responses)
                .flatMap(r -> Arrays.stream(r.split(" ")).distinct())
                .collect(Collectors.groupingBy(s -> s, Collectors.summingInt(s -> 1)));

        return IntStream.range(0, features.length)
                .boxed()
                .sorted((i, j) -> Integer.compare(count.getOrDefault(features[j], 0), count.getOrDefault(features[i], 0)))
                .map(i -> features[i])
                .toArray(String[]::new);
    }
}