package com.vsiverskyi.dataimport.service;


import com.vsiverskyi.dataimport.model.Position;
import com.vsiverskyi.dataimport.model.groups.PositionGroup;
import com.vsiverskyi.dataimport.repository.PositionRepo;
import com.vsiverskyi.dataimport.repository.groups.PositionGroupRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PositionGroupService {


    private final ModelMapper modelMapper;
    private final PositionGroupRepo positionGroupRepo;

    public List<PositionGroup> getAll() {
        return positionGroupRepo.findAll();
    }
}
