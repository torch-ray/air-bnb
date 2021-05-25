package com.codesquad.team10.airbnb.service;

import com.codesquad.team10.airbnb.dto.request.ReserveDto;
import com.codesquad.team10.airbnb.model.Reserve;
import com.codesquad.team10.airbnb.repository.ReserveRepository;
import org.springframework.stereotype.Service;

@Service
public class ReserveService {
    private final ReserveRepository reserveRepository;

    public ReserveService(ReserveRepository reserveRepository) {
        this.reserveRepository = reserveRepository;
    }

    public void add(ReserveDto reserveDto) {
        Reserve reserve = reserveDto.toEntity();
        reserveRepository.add(reserve);
    }
}
