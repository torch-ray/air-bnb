package com.codesquad.team10.airbnb.controller;

import com.codesquad.team10.airbnb.dto.ChargeGroupDto;
import com.codesquad.team10.airbnb.dto.ChargeRangeDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

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

}
