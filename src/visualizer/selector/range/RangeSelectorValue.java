package visualizer.selector.range;

public class RangeSelectorValue {
    private int from;
    private int to;

    public RangeSelectorValue(int _from, int _to) {
        from = _from;
        to = _to;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public void setValue(int _from, int _to) {
        from = _from;
        to = _to;
    }
}
