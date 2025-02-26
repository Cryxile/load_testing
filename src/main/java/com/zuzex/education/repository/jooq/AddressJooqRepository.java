package com.zuzex.education.repository.jooq;

import com.zuzex.education.model.db.Address;
import com.zuzex.education.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.generated.tables.Addresses;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Profile("jooq")
@Repository
@RequiredArgsConstructor
public class AddressJooqRepository implements AddressRepository {
    private final DSLContext dslContext;

    @Override
    public List<Address> findAll() {
        return dslContext.selectFrom(Addresses.ADDRESSES)
                .fetchInto(Address.class);
    }

    @Override
    public Optional<Address> findById(UUID id) {
        return dslContext.selectFrom(Addresses.ADDRESSES)
                .where(Addresses.ADDRESSES.ID.eq(id))
                .fetchOptionalInto(Address.class);
    }

    @Override
    public Address save(Address address) {
        return dslContext.insertInto(Addresses.ADDRESSES)
                .set(dslContext.newRecord(Addresses.ADDRESSES, address))
                .returning()
                .fetchOneInto(Address.class);
    }

    @Override
    public void deleteById(UUID id) {
        dslContext.deleteFrom(Addresses.ADDRESSES)
                .where(Addresses.ADDRESSES.ID.eq(id))
                .execute();
    }
}
