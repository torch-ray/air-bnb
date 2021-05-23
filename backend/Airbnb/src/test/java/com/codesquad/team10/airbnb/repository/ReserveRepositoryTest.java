package com.codesquad.team10.airbnb.repository;

import com.codesquad.team10.airbnb.model.Reserve;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class ReserveRepositoryTest {
    private final Logger logger = LoggerFactory.getLogger(ReserveRepositoryTest.class);

    @Autowired
    private ReserveRepository reserveRepository;

    @Test
    void test_findById() {
        Reserve reserve = reserveRepository
                .findById(1L)
                .orElseThrow(IllegalArgumentException::new);
        logger.info("Found reserve by id : {}", reserve);
        assertThat(1L).isEqualTo(reserve.getId());
    }

    @Test
    void test_add() {
        Reserve reserve = new Reserve(5L, "august", 1L, "2021-08-10", "2021-08-17", 6);
        reserveRepository.add(reserve);

        Reserve insertedReserve = reserveRepository
                .findById(5L)
                .orElseThrow(IllegalArgumentException::new);
        logger.info("Inserted reserve : {}", insertedReserve);
        assertThat("august").isEqualTo(insertedReserve.getUserId());
    }
}
