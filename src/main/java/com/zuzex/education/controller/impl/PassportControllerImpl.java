package com.zuzex.education.controller.impl;

import com.zuzex.education.controller.PassportController;
import com.zuzex.education.dto.PassportDTO;
import com.zuzex.education.mapper.PassportMapper;
import com.zuzex.education.service.PassportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PassportControllerImpl implements PassportController {

    private final PassportService passportService;
    private final PassportMapper passportMapper;

    @Override
    public List<PassportDTO> getAll() {
        return passportMapper.mapPassportToPassportDTO(passportService.getAll());
    }

    @Override
    public PassportDTO get(UUID id) {
        return passportMapper.mapPassportToPassportDTO(passportService.get(id));
    }

    @Override
    public PassportDTO create(PassportDTO passportDTO) {
        return passportMapper.mapPassportToPassportDTO(
                passportService.create(passportMapper.mapPassportDtoToPassport(passportDTO))
        );
    }

    @Override
    public PassportDTO update(PassportDTO passportDTO) {
        return passportMapper.mapPassportToPassportDTO(
                passportService.update(passportMapper.mapPassportDtoToPassport(passportDTO))
        );
    }

    @Override
    public void delete(UUID id) {
        passportService.delete(id);
    }


}
