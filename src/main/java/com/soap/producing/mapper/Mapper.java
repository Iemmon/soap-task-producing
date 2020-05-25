package com.soap.producing.mapper;

public interface Mapper<E, D> {
    E toEntity(D item);

    D fromEntity(E entity);
}
