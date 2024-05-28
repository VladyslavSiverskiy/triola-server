package com.vsiverskyi.app.controller;

import com.vsiverskyi.app.dto.PositionDto;
import com.vsiverskyi.app.dto.PositionGroupDto;
import com.vsiverskyi.app.model.Position;
import com.vsiverskyi.app.model.groups.PositionGroup;
import com.vsiverskyi.app.service.PositionGroupService;
import com.vsiverskyi.app.service.PositionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
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

    @PostMapping // Процедура, що буде виконана при надсиланні POST HTTP запиту на визначену адресу
    public ResponseEntity<Boolean> updatePosition(@RequestBody PositionDto positionDto) { // вхідний JSON
        log.info("Оновлення посади з кодом"
                 + positionDto.getCode()); // логування інформації про оновлення запису
        positionService.saveOrUpdate(positionDto); // використання сервісного рівня для оновлення посади
        log.info("Посаду з кодом " + positionDto.getCode() + " було оновлено");
        return ResponseEntity.ok(true); // повернути клієнту відповідь про оновлення
    }

    @GetMapping("/{nposCode}/delete")
    public ResponseEntity<Boolean> deletePosition(@PathVariable String nposCode) {
        positionService.deletePosition(nposCode);
        return ResponseEntity.ok(true);
    }

}
