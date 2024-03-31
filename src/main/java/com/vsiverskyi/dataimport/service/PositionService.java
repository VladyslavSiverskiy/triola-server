package com.vsiverskyi.dataimport.service;

import com.vsiverskyi.app.dto.PositionDto;
import com.vsiverskyi.dataimport.model.Position;
import com.vsiverskyi.dataimport.repository.PositionRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PositionService {

    private final ModelMapper modelMapper;
    private final PositionRepo positionRepo;

    public List<Position> getAll() {
        return positionRepo.findAll();
    }

    public Position saveOrUpdate(PositionDto positionDto) {
        System.out.println(positionDto);
        Position position = modelMapper.map(positionDto, Position.class);
        System.out.println(position);
        return positionRepo.save(position);
    }

    public Boolean updateCode(PositionDto positionDto, String newCode) {
        positionRepo.updateByCode(positionDto.getCode(), newCode);
        return true;
    }

    public Boolean deletePosition(String nposCode) {
        positionRepo.deleteById(nposCode);
        return true;
    }
}
