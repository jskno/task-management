package com.jskno.taskmanagement.sandbox.diByName;

import org.springframework.stereotype.Component;

@Component(value = "anotherAutowiredField")
public class ArbitraryDependencyImpl2 implements ArbitraryDependency {
}
