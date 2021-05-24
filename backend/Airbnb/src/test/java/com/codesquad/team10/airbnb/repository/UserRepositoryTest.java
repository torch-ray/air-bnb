package com.codesquad.team10.airbnb.repository;

import com.codesquad.team10.airbnb.model.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class UserRepositoryTest {
    private final Logger logger = LoggerFactory.getLogger(UserRepositoryTest.class);

    @Autowired
    private UserRepository userRepository;

    @Test
    void test_findById() {
        User user = userRepository
                .findById("august")
                .orElseThrow(IllegalArgumentException::new);
        logger.info("Found user by id : {}", user);
        assertThat("august").isEqualTo(user.getId());
    }

    @Test
    void test_add() {
        User user = new User("test", "1234", "testing", "test@test.com");
        userRepository.add(user);

        User insertedUser = userRepository
                .findById("test")
                .orElseThrow(IllegalArgumentException::new);
        logger.info("Inserted user : {}", insertedUser);
        assertThat("test").isEqualTo(insertedUser.getId());
    }
}
