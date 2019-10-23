import java.util.Objects;

public class HashObject<T> {

    private int duplicateCount = 0;
    private int probeCount = 0;
    private T key;
    private int loadFactor;

    public HashObject(T key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashObject<?> that = (HashObject<?>) o;
        return Objects.equals(key, that.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    public String toString() {
        return String.format("%s %d %d", key.toString(), duplicateCount, probeCount);
    }

    public T getKey() {
        return this.key;
    }

    public void incDuplicateCount() {
        duplicateCount++;
    }

    public int getDuplicateCount() {
        return duplicateCount;
    }

    public void incProbeCount() {
        probeCount++;
    }

    public int getProbeCount() {
        return probeCount;
    }

}