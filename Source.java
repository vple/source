public abstract class Source<T> implements Iterator<T> {

    protected abstract Iterator<T> iterator();
    protected abstract boolean complete();

    protected abstract void loadInitial();
    protected abstract void load();

    public Iterable<T> toIterable() {
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return Source.this;
            }
        }
    }

    @Override
    public final boolean hasNext() {
        if (iterator().hasNext()) {
            return true;
        } else {
            return !complete();
        }
    }

    @Override
    public final T next() {
        if (iterator().hasNext()) {
            return iterator().next();
        } else if (!complete()) {
            load();
            return next();
        } else {
            throw new NoSuchElementException();
        }
    }

}