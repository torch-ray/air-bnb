package com.codesquad.team10.airbnb.repository;

import com.codesquad.team10.airbnb.model.Reserve;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class ReserveRepository implements JdbcRepository<Reserve> {
    private final Logger logger = LoggerFactory.getLogger(ReserveRepository.class);
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ReserveRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public Optional<Reserve> findById(Long id) {
        List<Reserve> result = jdbcTemplate.query("SELECT * FROM reserve WHERE id = ?", reserveRowMapper(), id);
        logger.debug("Found reserve by id : {}", result);
        return result.stream().findAny();
    }

    @Override
    public Optional<Reserve> findById(String id) {
        return Optional.empty();
    }

    @Override
    public List<Reserve> findAll() {
        return null;
    }

    @Override
    public void add(Reserve reserve) {

    }

    @Override
    public void update(Reserve reserve) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(String id) {

    }

    private RowMapper<Reserve> reserveRowMapper() {
        return (rs, rowNum) -> {
            Reserve reserve = new Reserve();
            reserve.setId(rs.getLong("id"));
            reserve.setUserId(rs.getString("user_id"));
            reserve.setRoomId(rs.getLong("room_id"));
            reserve.setCheckIn(rs.getString("check_in"));
            reserve.setCheckOut(rs.getString("check_out"));
            reserve.setGuests(rs.getInt("guests"));
            return reserve;
        };
    }
}
