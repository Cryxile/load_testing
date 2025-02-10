package com.zuzex.education.controller;

import com.zuzex.education.dto.passport.PassportDTO;
import com.zuzex.education.dto.passport.GetPassportListRs;
import com.zuzex.education.dto.passport.UpdatePassportRq;
import com.zuzex.education.dto.passport.UpdatePassportRs;
import com.zuzex.education.validator.Char;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

import static com.zuzex.education.constants.ResourceConstants.PASSPORTS_RESOURCE;
import static com.zuzex.education.constants.ResourceConstants.RESOURCE_VERSION_V1;

public interface PassportController {
    @GetMapping(RESOURCE_VERSION_V1 + PASSPORTS_RESOURCE)
    GetPassportListRs getAll();

    @GetMapping(RESOURCE_VERSION_V1 + PASSPORTS_RESOURCE + "/male/last-name/initial/{firstCharacter}")
    GetPassportListRs getAllByMaleLastNameFirstCharacter(@Valid @PathVariable @Char(regexp = "[a-zA-Zа-яА-Я]") Character firstCharacter);

    @GetMapping(RESOURCE_VERSION_V1 + PASSPORTS_RESOURCE + "/{id}")
    PassportDTO get(@PathVariable @NotNull UUID id);

    @PutMapping(RESOURCE_VERSION_V1 + PASSPORTS_RESOURCE)
    UpdatePassportRs update(@Valid @RequestBody UpdatePassportRq passport);

}
