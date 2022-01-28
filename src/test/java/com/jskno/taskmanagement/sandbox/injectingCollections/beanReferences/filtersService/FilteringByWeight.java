package com.jskno.taskmanagement.sandbox.injectingCollections.beanReferences.filtersService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(2)
@Qualifier("inclusived")
public class FilteringByWeight implements FilterService {

    @Override
    public void appliedFilter() {

    }
}
