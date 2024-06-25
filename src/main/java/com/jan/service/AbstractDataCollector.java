package com.jan.service;

import java.util.List;

public abstract class AbstractDataCollector<T> implements DataCollector<T>{
    public abstract List<T> getData();
}
