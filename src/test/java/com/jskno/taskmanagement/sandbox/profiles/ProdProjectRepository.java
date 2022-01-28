package com.jskno.taskmanagement.sandbox.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Profile("prod")
@Repository
public class ProdProjectRepository implements IProfileProjectRepository {

    @Override
    public void findById(Long id) {
        System.out.println("PROD");
    }
}
