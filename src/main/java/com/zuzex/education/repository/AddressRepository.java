package com.zuzex.education.repository;

import com.zuzex.education.model.db.Address;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AddressRepository {
    List<Address> findAll();
    Optional<Address> findById(UUID id);
    Address save(Address address);
    void deleteById(UUID id);
}
