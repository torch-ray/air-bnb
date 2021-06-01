package com.codesquad.team10.airbnb.controller;

import com.codesquad.team10.airbnb.dto.request.ReserveDto;
import com.codesquad.team10.airbnb.dto.request.SearchDto;
import com.codesquad.team10.airbnb.dto.request.WishListAddDto;
import com.codesquad.team10.airbnb.dto.response.*;
import com.codesquad.team10.airbnb.service.ReserveService;
import com.codesquad.team10.airbnb.service.RoomService;
import com.codesquad.team10.airbnb.service.WishListService;
import com.codesquad.team10.airbnb.util.HttpSessionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    private final Logger logger = LoggerFactory.getLogger(RoomController.class);

    private final ReserveService reserveService;
    private final WishListService wishListService;
    private final RoomService roomService;

    @Autowired
    public RoomController(ReserveService reserveService, WishListService wishListService, RoomService roomService) {
        this.reserveService = reserveService;
        this.wishListService = wishListService;
        this.roomService = roomService;
    }

    @GetMapping("/charges")
    public ChargeRangeDto getChargeRange(@RequestParam("check-in") String checkIn, @RequestParam("check-out") String checkOut) {
        List<ChargeGroupDto> chargeGroups = new ArrayList<>();
        chargeGroups.add(new ChargeGroupDto(10000, 5));
        chargeGroups.add(new ChargeGroupDto(11000, 11));
        chargeGroups.add(new ChargeGroupDto(12000, 15));
        chargeGroups.add(new ChargeGroupDto(13000, 7));
        chargeGroups.add(new ChargeGroupDto(14000, 2));

        return new ChargeRangeDto(165556, chargeGroups);
    }

    @GetMapping
    public SearchResultDto getSearchResult(@RequestParam(required = false) String location, @RequestParam(name = "check-in", required = false) String checkIn, @RequestParam(name = "check-out", required = false) String checkOut,
                                           @RequestParam(required = false) Integer min, @RequestParam(required = false) Integer max, @RequestParam(required = false) Integer guests) {
        logger.debug(location + " " + checkIn + " " + checkOut + " " + min + " " + max + " " + guests);

        SearchDto searchDto = new SearchDto(location, checkIn, checkOut, min, max, guests);
        logger.debug(searchDto.toString());

        return roomService.findByFilter(searchDto);
    }

    @GetMapping("/{id}/charges")
    public ChargeDetailDto getChargeDetail(@PathVariable Long id, @RequestParam String location, @RequestParam("check-in") String checkIn, @RequestParam("check-out") String checkOut, @RequestParam Integer guests) {
        logger.debug(location + " " + checkIn + " " + checkOut + " " + guests);
        return new ChargeDetailDto(1322395, 55948, 25996, 1822468, 18247, 67006);
    }

    @PostMapping("/reserve")
    @ResponseStatus(HttpStatus.CREATED)
    public void reserveRoom(@RequestBody ReserveDto reserveDto, HttpSession session) {
        if (!HttpSessionUtils.isLoginUser(session)) {
            logger.debug("User is not logged in.");
            return;
        }

        reserveDto.setUserId(HttpSessionUtils.getUserFromSession(session).getId());

        logger.debug(reserveDto.toString());
        reserveService.add(reserveDto);
    }

    @PostMapping("/wishlists")
    @ResponseStatus(HttpStatus.CREATED)
    public void addToWishList(@RequestBody WishListAddDto wishListAddDto, HttpSession session) {
        if (!HttpSessionUtils.isLoginUser(session)) {
            logger.debug("User is not logged in.");
            return;
        }

        wishListAddDto.setUserId(HttpSessionUtils.getUserFromSession(session).getId());

        logger.debug(wishListAddDto.toString());
        wishListService.add(wishListAddDto);
    }
}
