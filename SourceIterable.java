class SourceIterable<T> implements Iterable<T> {

    private final Supplier<Source<T>> sourceSupplier;

    public SourceIterable<T>(Supplier<Source<T>> sourceSupplier) {
        this.sourceSupplier = sourceSupplier;
    }

    @Override
    public Iterator<T> iterator() {
        return sourceSupplier.get();
    }
}