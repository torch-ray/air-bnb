package com.codesquad.team10.airbnb.repository;

import com.codesquad.team10.airbnb.model.WishList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class WishListRepository {
    private final Logger logger = LoggerFactory.getLogger(WishListRepository.class);
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public WishListRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public Optional<WishList> findById(Long id) {
        List<WishList> result = jdbcTemplate.query("SELECT * FROM wishlist WHERE id = ?", wishListRowMapper(), id);
        logger.debug("Found wishlist by id : {}", result);
        return result.stream().findAny();
    }

    private RowMapper<WishList> wishListRowMapper() {
        return (rs, rowNum) -> {
            WishList wishList = new WishList();
            wishList.setId(rs.getLong("id"));
            wishList.setUserId(rs.getString("user_id"));
            wishList.setRoomId(rs.getLong("room_id"));
            return wishList;
        };
    }
}