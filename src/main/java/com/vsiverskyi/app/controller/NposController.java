package com.vsiverskyi.app.controller;

import com.vsiverskyi.app.dto.PositionDto;
import com.vsiverskyi.app.dto.PositionGroupDto;
import com.vsiverskyi.dataimport.model.Position;
import com.vsiverskyi.dataimport.model.groups.PositionGroup;
import com.vsiverskyi.dataimport.service.PositionGroupService;
import com.vsiverskyi.dataimport.service.PositionService;
import lombok.Getter;
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
    private final PositionGroupService positionGroupService;

    @GetMapping
    public ResponseEntity<List<PositionDto>> getAllPositions() {
        List<Position> positions = positionService.getAll();
        return ResponseEntity.ok(positions.stream()
                .map(position -> modelMapper.map(position, PositionDto.class))
                .collect(Collectors.toList()));
    }

    @GetMapping("/groups")
    public ResponseEntity<List<PositionGroupDto>> getAllPositionGroups() {
        List<PositionGroup> positionGroups = positionGroupService.getAll();
        return ResponseEntity.ok(positionGroups.stream()
                .map(positionGroup -> modelMapper.map(positionGroup, PositionGroupDto.class))
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<Boolean> updatePosition(@RequestBody PositionDto positionDto) {
        System.out.println("UPDATING...");
        positionService.saveOrUpdate(positionDto);
        return ResponseEntity.ok(true);
    }

    @GetMapping("/{nposCode}/delete")
    public ResponseEntity<Boolean> deletePosition(@PathVariable String nposCode) {
        positionService.deletePosition(nposCode);
        return ResponseEntity.ok(true);
    }

}
