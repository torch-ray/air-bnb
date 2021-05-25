package com.codesquad.team10.airbnb.service;

import com.codesquad.team10.airbnb.dto.request.WishListAddDto;
import com.codesquad.team10.airbnb.model.WishList;
import com.codesquad.team10.airbnb.repository.WishListRepository;
import org.springframework.stereotype.Service;

@Service
public class WishListService {
    private final WishListRepository wishListRepository;

    public WishListService(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    public void add(WishListAddDto wishListAddDto) {
        WishList wishList = wishListAddDto.toEntity();
        wishListRepository.add(wishList);
    }
}
