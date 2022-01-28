package com.jskno.taskmanagement.sandbox.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Profile("dev")
@Repository
public class DevProjectRepository implements IProfileProjectRepository {

    @Override
    public void findById(Long id) {
        System.out.println("DEV");
    }
}
