package com.jskno.taskmanagement.sandbox.injectingCollections.set;

import java.util.Set;

public class SetCollectionsBean {

    private Set<String> nameSet;

    public SetCollectionsBean(Set<String> nameSet) {
        this.nameSet = nameSet;
    }

    public void printNameSet() {
        System.out.println(nameSet);
    }
}
