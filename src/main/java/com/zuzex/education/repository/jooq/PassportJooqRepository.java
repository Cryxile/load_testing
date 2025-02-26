package com.zuzex.education.repository.jooq;

import com.zuzex.education.model.db.Passport;
import com.zuzex.education.repository.PassportRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.generated.tables.Passports;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Profile("jooq")
@Repository
@RequiredArgsConstructor
public class PassportJooqRepository implements PassportRepository {
    private final DSLContext dslContext;

    @Override
    public List<Passport> findAll() {
        return dslContext.selectFrom(Passports.PASSPORTS)
                .fetchInto(Passport.class);
    }

    @Override
    public List<Passport> findAllMaleByLastNameFirstCharacter(Character firstCharacter) {
        return dslContext.selectFrom(Passports.PASSPORTS)
                .where(Passports.PASSPORTS.GENDER.eq("Male")
                        .and(Passports.PASSPORTS.LAST_NAME.likeIgnoreCase(firstCharacter + "%")))
                .fetchInto(Passport.class);
    }

    @Override
    public Optional<Passport> findById(UUID id) {
        return dslContext.selectFrom(Passports.PASSPORTS)
                .where(Passports.PASSPORTS.ID.eq(id))
                .fetchOptionalInto(Passport.class);
    }

    @Override
    public Passport save(Passport passport) {
        return dslContext.insertInto(Passports.PASSPORTS)
                .set(dslContext.newRecord(Passports.PASSPORTS, passport))
                .onConflict(Passports.PASSPORTS.ID)
                .doUpdate()
                .set(Passports.PASSPORTS.FIRST_NAME, passport.getFirstName())
                .set(Passports.PASSPORTS.LAST_NAME, passport.getLastName())
                .set(Passports.PASSPORTS.ADDRESS_ID, passport.getResidentAddressId())
                .returning()
                .fetchOneInto(Passport.class);
    }

    @Override
    public void deleteById(UUID id) {
        dslContext.deleteFrom(Passports.PASSPORTS)
                .where(Passports.PASSPORTS.ID.eq(id))
                .execute();
    }

    @Override
    public void deleteByOwner(UUID id) {
        dslContext.deleteFrom(Passports.PASSPORTS)
                .where(Passports.PASSPORTS.OWNER_ID.eq(id))
                .execute();
    }
}
