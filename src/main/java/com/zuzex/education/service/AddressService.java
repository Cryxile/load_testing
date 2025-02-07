package com.zuzex.education.service;

import com.zuzex.education.model.db.Address;

import java.util.List;
import java.util.UUID;

public interface AddressService {
    List<Address> getAll();

    Address get(UUID id);

    Address create(Address address);

    Address update(Address address);

    void delete(UUID id);
}
