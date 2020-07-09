public class HistoryItem {
private int id;
private int mount;
private String operation;
private int total;

    public HistoryItem(int id, int mount, String operation, int total) {
        this.id = id;
        this.mount = mount;
        this.operation = operation;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return mount;
    }

    public String getOperation() {
        return operation;
    }

    public int getTotal() {
        return total;
    }
}

