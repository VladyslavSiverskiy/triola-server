package com.vsiverskyi.app.mappers;

import com.vsiverskyi.app.dto.PositionDto;
import com.vsiverskyi.dataimport.model.Position;
import com.vsiverskyi.dataimport.model.groups.PositionGroup;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

@Component
public class NposMapper extends AbstractConverter<PositionDto, Position> {

    @Override
    protected Position convert(PositionDto positionDto) {
        return Position.builder()
                .code(positionDto.getCode())
                .kror(positionDto.getKror())
                .dbaz(positionDto.getDbaz())
                .sokl(positionDto.getSokl())
                .qokl(positionDto.getQokl())
                .code(positionDto.getCode())
                .title(positionDto.getTitle())
                .positionGroup(positionDto.getPositionGroup() == null ? null : PositionGroup.builder()
                        .code(positionDto.getPositionGroup().getCode())
                        .title(positionDto.getPositionGroup().getTitle())
                        .build())
                .titleMax(positionDto.getTitleMax())
                .codeKP(positionDto.getCodeKP())
                .codeZKPTTR(positionDto.getCodeZKPTTR())
                .namePRO(positionDto.getNamePRO())
                .qpre(positionDto.getQpre())
                .qpre22(positionDto.getQpre22())
                .build();
    }
}