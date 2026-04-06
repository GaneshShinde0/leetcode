class UndergroundSystem {
    private static class Pair {
        Integer key;
        Double value;

        Pair(Integer key, Double value) {
            this.key = key;
            this.value = value;
        }

        Integer getKey() {
            return key;
        }

        Double getValue() {
            return value;
        }

        void setKey(int key) {
            this.key = key;
        }

        void setValue(Double value) {
            this.value = value;
        }
    }

    Map<Integer, String> idToCheckIn;
    Map<String, Pair> startEndAvg;

    public UndergroundSystem() {
        this.idToCheckIn = new HashMap<>();
        this.startEndAvg = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        idToCheckIn.put(id, stationName + "-" + t);
    }

    public void checkOut(int id, String stationName, int t) {
        String current = idToCheckIn.get(id);
        String[] checkInStationTime = current.split("-");
        String startStation = checkInStationTime[0];
        int checkInTime = Integer.parseInt(checkInStationTime[1]);
        double travelTime = t - checkInTime;
        String startEnd = startStation + "-" + stationName;
        if (startEndAvg.containsKey(startEnd)) {
            Pair pair = startEndAvg.get(startEnd);
            pair.setValue((pair.getKey() * pair.getValue() + travelTime) / (pair.getKey() + 1));
            pair.setKey(pair.getKey() + 1);
        } else {
            startEndAvg.put(startEnd, new Pair(1, travelTime));
        }

    }

    public double getAverageTime(String startStation, String endStation) {
        return startEndAvg.get(startStation + "-" + endStation).getValue();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */