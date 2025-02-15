package com.comparator;
import java.util.Comparator;
import java.util.function.Function;

public class GenericComparator <T, U extends Comparable> implements Comparator<T>  {

    private final Function<T, U> function;

    public GenericComparator(Function<T, U> function) {
        this.function = function;
    }

    @Override
    public int compare(T o1, T o2) {
        return function.apply(o1).compareTo(function.apply(o2));
    }
}
