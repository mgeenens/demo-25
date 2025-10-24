package com.example.demo25.persistence.enums;

import java.util.List;

public interface IndexedEnum<E extends Enum<E>> {

    List<E> valuesList();

    // Default method to get enum by index
    default E getByIndex(int index) {
        List<E> list = valuesList();
        if (index < 0 || index >= list.size()) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for enum " + list);
        }
        return list.get(index);
    }
}
