package com.zuzex.education.service.impl;

import com.zuzex.education.exception.MalePassportNotFoundException;
import com.zuzex.education.exception.PassportNotFoundException;
import com.zuzex.education.model.db.Passport;
import com.zuzex.education.repository.PassportRepository;
import com.zuzex.education.service.PassportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PassportServiceImpl implements PassportService {
    private final PassportRepository passportRepository;

    @Override
    public List<Passport> findAll() {
        return passportRepository.findAll();
    }

    @Override
    public List<Passport> findAllByMaleLastNameFirstCharacter(Character firstCharacter) {
        List<Passport> passports = passportRepository.findAllMaleByLastNameFirstCharacter(firstCharacter);
        if (passports.isEmpty()) {
            throw new MalePassportNotFoundException(firstCharacter);
        }
        return passportRepository.findAllMaleByLastNameFirstCharacter(firstCharacter);
    }

    @Override
    public Passport get(UUID id) {
        return passportRepository.findById(id).orElseThrow(() -> new PassportNotFoundException(id));
    }

    @Override
    public Passport create(Passport passport) {
        return passportRepository.save(
                Passport.builder()
                        .id(UUID.randomUUID())
                        .firstName(passport.getFirstName())
                        .lastName(passport.getLastName())
                        .birthDate(passport.getBirthDate())
                        .gender(passport.getGender())
                        .ownerId(passport.getOwnerId())
                        .residentAddressId(passport.getResidentAddressId())
                        .build()
        );
    }

    @Override
    public Passport update(Passport passport) {
        return passportRepository.save(passport);
    }

    @Override
    public void delete(UUID id) {
        passportRepository.deleteById(id);
    }

    @Override
    public void deleteByOwner(UUID ownerId) {
        passportRepository.deleteByOwner(ownerId);
    }
}
