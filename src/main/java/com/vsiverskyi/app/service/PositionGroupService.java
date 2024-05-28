package com.vsiverskyi.app.service;


import com.vsiverskyi.app.model.groups.PositionGroup;
import com.vsiverskyi.app.repository.groups.PositionGroupRepo;
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
