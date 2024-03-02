package com.vsiverskyi.app.controller;

import com.vsiverskyi.app.dto.PositionDto;
import com.vsiverskyi.dataimport.model.Position;
import com.vsiverskyi.dataimport.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/npos")
@RequiredArgsConstructor
public class NposController {

    private final ModelMapper modelMapper;
    private final PositionService positionService;

    @GetMapping
    public ResponseEntity<List<PositionDto>> getPositions() {
        List<Position> positions = positionService.getAll();
        return ResponseEntity.ok(positions.stream()
                .map(position -> modelMapper.map(position, PositionDto.class))
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<Boolean> updatePosition(@RequestBody PositionDto positionDto) {
        positionService.saveOrUpdate(positionDto);
        return ResponseEntity.ok(true);
    }
}
