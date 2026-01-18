import java.util.*;

class AuctionSystem {

    static class ItemData {
        Map<Integer, Integer> userToBid = new HashMap<>();
        TreeMap<Integer, TreeSet<Integer>> bidToUsers = new TreeMap<>();
    }

    private Map<Integer, ItemData> items;

    public AuctionSystem() {
        items = new HashMap<>();
    }

    public void addBid(int userId, int itemId, int bidAmount) {
        ItemData data = items.computeIfAbsent(itemId, k -> new ItemData());

        // If user already bid, treat as update
        if (data.userToBid.containsKey(userId)) {
            removeInternal(data, userId);
        }
        updateInternal(data, userId, bidAmount);
    }

    public void updateBid(int userId, int itemId, int newAmount) {
        if (!items.containsKey(itemId)) return;
        ItemData data = items.get(itemId);
        if (!data.userToBid.containsKey(userId)) return;

        removeInternal(data, userId);
        updateInternal(data, userId, newAmount);
    }

    public void removeBid(int userId, int itemId) {
        if (!items.containsKey(itemId)) return;

        ItemData data = items.get(itemId);
        if (!data.userToBid.containsKey(userId)) return;

        removeInternal(data, userId);

        if (data.userToBid.isEmpty()) {
            items.remove(itemId);
        }
    }

    public int getHighestBidder(int itemId) {
        if (!items.containsKey(itemId)) return -1;

        ItemData data = items.get(itemId);
        int maxBid = data.bidToUsers.lastKey();
        return data.bidToUsers.get(maxBid).last(); // highest userId on tie
    }

    // ---------- Helpers ----------

    private void updateInternal(ItemData data, int userId, int bidAmount) {
        data.userToBid.put(userId, bidAmount);
        data.bidToUsers
            .computeIfAbsent(bidAmount, k -> new TreeSet<>())
            .add(userId);
    }

    private void removeInternal(ItemData data, int userId) {
        int bid = data.userToBid.remove(userId);
        TreeSet<Integer> users = data.bidToUsers.get(bid);
        users.remove(userId);
        if (users.isEmpty()) {
            data.bidToUsers.remove(bid);
        }
    }
}
