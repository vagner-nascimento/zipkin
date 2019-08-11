package com.vagner.sales.implementation.data;

public interface BaseRepository {

    <P> Object get(P param);

    <E> Object save(E entity);
}