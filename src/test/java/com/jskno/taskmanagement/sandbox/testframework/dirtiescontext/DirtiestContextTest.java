package com.jskno.taskmanagement.sandbox.testframework.dirtiescontext;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DirtiesContextConfig.class)
public class DirtiestContextTest {

    @Autowired
    protected UserCache userCache;

    @Test
    @Order(1)
    void addJaneDoeAndPrintCache() {
        Assertions.assertEquals(userCache.getUserList().size(), 0);
        userCache.addUser(new User("Jane", "Done"));
        userCache.printUserList("addJaneDoneAndPrintCache");
        Assertions.assertEquals(userCache.getUserList().size(), 1);
    }

    @Test
    @Order(2)
    void printCache() {
        userCache.printUserList("printCache");
        Assertions.assertEquals(userCache.getUserList().size(), 1);
    }

    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    @Test
    @Order(3)
    void addJohnDoeAndPrintCache() {
        Assertions.assertEquals(userCache.getUserList().size(), 1);
        userCache.addUser(new User("John", "Doe"));
        userCache.printUserList("addJohnDoeAndPrintCache");
        Assertions.assertEquals(userCache.getUserList().size(), 2);
    }

    @Test
    @Order(4)
    void printCacheAgain() {
        userCache.printUserList("printCacheAgain");
        Assertions.assertEquals(userCache.getUserList().size(), 0);
    }
}
