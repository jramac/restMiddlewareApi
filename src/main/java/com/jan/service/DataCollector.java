package com.jan.service;

import java.util.List;

public interface DataCollector<T> {
    List<T> parseData();
}