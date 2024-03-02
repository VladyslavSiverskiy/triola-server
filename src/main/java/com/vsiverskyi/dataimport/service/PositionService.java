package com.vsiverskyi.dataimport.service;

import com.vsiverskyi.app.dto.PositionDto;
import com.vsiverskyi.dataimport.model.Position;
import com.vsiverskyi.dataimport.repository.PositionRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionService {

    private final ModelMapper modelMapper;
    private final PositionRepo positionRepo;

    public List<Position> getAll() {
        return positionRepo.findAll();
    }

    public Position saveOrUpdate(PositionDto positionDto) {
        return positionRepo.save(modelMapper.map(positionDto, Position.class));
    }

    public Boolean updateCode(PositionDto positionDto, String newCode) {
        positionRepo.updateByCode(positionDto.getCode(), newCode);
        return true;
    }
}
