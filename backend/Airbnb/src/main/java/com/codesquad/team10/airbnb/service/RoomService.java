package com.codesquad.team10.airbnb.service;

import com.codesquad.team10.airbnb.dto.request.SearchDto;
import com.codesquad.team10.airbnb.dto.response.RoomDto;
import com.codesquad.team10.airbnb.dto.response.SearchResultDto;
import com.codesquad.team10.airbnb.model.Room;
import com.codesquad.team10.airbnb.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public SearchResultDto findByFilter(SearchDto searchDto) {
        List<RoomDto> rooms;
        if (searchDto.getLocation() != null && (searchDto.getCheckIn() == null || searchDto.getCheckOut() == null)
                && (searchDto.getMin() == null || searchDto.getMax() == null) && (searchDto.getGuests() == null)) {
            rooms = roomRepository.findByFilter(searchDto.getLocation())
                    .stream()
                    .map(Room::createRoomDto)
                    .collect(Collectors.toList());
        } else if (searchDto.getLocation() != null && (searchDto.getCheckIn() != null && searchDto.getCheckOut() != null)
                && (searchDto.getMin() == null || searchDto.getMax() == null) && (searchDto.getGuests() == null)) {
            rooms = roomRepository.findByFilter(searchDto.getLocation(), searchDto.getCheckIn(), searchDto.getCheckOut())
                    .stream()
                    .map(Room::createRoomDto)
                    .peek(room -> room.setTotalCharge(searchDto.getCheckIn(), searchDto.getCheckOut()))
                    .collect(Collectors.toList());
        } else if (searchDto.getLocation() != null && (searchDto.getCheckIn() != null && searchDto.getCheckOut() != null)
                && (searchDto.getMin() != null && searchDto.getMax() != null) && (searchDto.getGuests() == null)) {
            rooms = roomRepository.findByFilter(searchDto.getLocation(), searchDto.getCheckIn(), searchDto.getCheckOut(), searchDto.getMin(), searchDto.getMax())
                    .stream()
                    .map(Room::createRoomDto)
                    .peek(room -> room.setTotalCharge(searchDto.getCheckIn(), searchDto.getCheckOut()))
                    .collect(Collectors.toList());
        } else if (searchDto.getLocation() != null && (searchDto.getCheckIn() != null && searchDto.getCheckOut() != null)
                && (searchDto.getMin() != null && searchDto.getMax() != null) && (searchDto.getGuests() != null)) {
            rooms = roomRepository.findByFilter(searchDto.getLocation(), searchDto.getCheckIn(), searchDto.getCheckOut(), searchDto.getMin(), searchDto.getMax(), searchDto.getGuests())
                    .stream()
                    .map(Room::createRoomDto)
                    .peek(room -> room.setTotalCharge(searchDto.getCheckIn(), searchDto.getCheckOut()))
                    .collect(Collectors.toList());
        } else {
            rooms = roomRepository.findAll()
                    .stream()
                    .map(Room::createRoomDto)
                    .collect(Collectors.toList());
        }

        return new SearchResultDto(rooms.size(), rooms);
    }
}
