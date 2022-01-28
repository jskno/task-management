package com.jskno.taskmanagement.sandbox.injectingCollections.beanReferences.filtersService;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(Ordered.LOWEST_PRECEDENCE)
public class FilteringByGenre implements FilterService {

    @Override
    public void appliedFilter() {

    }
}
