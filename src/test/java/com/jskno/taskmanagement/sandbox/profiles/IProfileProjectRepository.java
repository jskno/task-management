package com.jskno.taskmanagement.sandbox.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Profile("dev")
@Repository
public interface IProfileProjectRepository {

    void findById(Long id);
}
