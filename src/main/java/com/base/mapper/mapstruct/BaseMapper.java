package com.base.mapper.mapstruct;

import com.base.dto.BaseDto;
import com.base.entity.BaseEntity;

import java.util.List;

/**
 * BaseMapper
 * @param <DTO>
 * @param <ENTITY>
 */
public interface BaseMapper<DTO extends BaseDto, ENTITY extends BaseEntity> {
    /**
     * Convert entity to dto
     * @param entity
     * @return
     */
    DTO toDTO(ENTITY entity);

    /**
     * Convert dto to entity
     * @param dto
     * @return
     */
    ENTITY toEntity(DTO dto);

    /**
     * Convert list entity to list dto
     * @param entityList
     * @return
     */
    List<DTO> toListDTO(List<ENTITY> entityList);

    /**
     * Convert list dto to list entity
     * @param dtoList
     * @return
     */
    List<ENTITY> toListEntity(List<DTO> dtoList);
}
