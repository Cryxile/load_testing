package com.zuzex.education.controller.impl;

import com.zuzex.education.controller.PassportController;
import com.zuzex.education.dto.passport.PassportDTO;
import com.zuzex.education.dto.passport.FindPassportsRs;
import com.zuzex.education.dto.passport.UpdatePassportRq;
import com.zuzex.education.dto.passport.UpdatePassportRs;
import com.zuzex.education.mapper.PassportMapper;
import com.zuzex.education.service.PassportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PassportControllerImpl implements PassportController {
    private final PassportService passportService;
    private final PassportMapper passportMapper;

    @Override
    public FindPassportsRs findAll() {
        return passportMapper.map(passportService.findAll());
    }

    @Override
    public FindPassportsRs findAllByMaleLastNameFirstCharacter(Character firstCharacter) {
        return passportMapper.map(
                passportService.findAllByMaleLastNameFirstCharacter(firstCharacter)
        );
    }

    @Override
    public PassportDTO get(UUID id) {
        return passportMapper.map(passportService.get(id));
    }

    @Override
    public UpdatePassportRs update(UpdatePassportRq passport) {
        return passportMapper.mapRs(
                passportService.update(
                        passportMapper.map(passport)
                )
        );
    }
}
