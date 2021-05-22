package com.codesquad.team10.airbnb.repository;

import com.codesquad.team10.airbnb.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class RoomRepository {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public RoomRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public Optional<Room> findById(Long id) {
        List<Room> result = jdbcTemplate.query("SELECT * FROM room WHERE id = ?", roomRowMapper(), id);
        System.out.println("result : " + result);
        return result.stream().findAny();
    }

    private RowMapper<Room> roomRowMapper() {
        return (rs, rowNum) -> {
            Room room = new Room();
            room.setId(rs.getLong("id"));
            room.setLocation(rs.getString("location"));
            room.setTitle(rs.getString("title"));
            room.setxPos(rs.getString("x_pos"));
            room.setyPos(rs.getString("y_pos"));
            room.setRatings(rs.getDouble("ratings"));
            room.setReviews(rs.getInt("reviews"));
            room.setCharge(rs.getInt("charge"));
            room.setCleaningFee(rs.getInt("cleaning_fee"));
            room.setServiceFee(rs.getInt("service_fee"));
            room.setTaxFee(rs.getInt("tax_fee"));
            return room;
        };
    }
}
