package com.vsiverskyi.app.service;

import com.vsiverskyi.app.dto.PositionDto;
import com.vsiverskyi.app.model.Position;
import com.vsiverskyi.app.repository.PositionRepo;
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
        Position position = modelMapper.map(positionDto, Position.class); // Формування об'єкту для збереження у БД
        return positionRepo.save(position); // Збереження даних у хмарній SQL-таблиці (Технологія Spring Data JPA)
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
