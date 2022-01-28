package com.jskno.taskmanagement.sandbox.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Profile("default")
@Repository
public class DefaultProjectRepository implements IProfileProjectRepository {

    @Override
    public void findById(Long id) {
        System.out.println("DEFAULT PROFILE WHEN NO PROFILE IS SET ");
    }
}
