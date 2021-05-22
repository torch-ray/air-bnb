package com.codesquad.team10.airbnb.repository;

import com.codesquad.team10.airbnb.model.Room;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class RoomRepositoryTest {
    private final Logger logger = LoggerFactory.getLogger(RoomRepositoryTest.class);

    @Autowired
    private RoomRepository roomRepository;

    @Test
    void test_findById() {
        Room room = roomRepository
                .findById(1L)
                .orElseThrow(IllegalArgumentException::new);
        logger.info("Found room by id : {}", room);
        assertThat(1L).isEqualTo(room.getId());
    }
}
