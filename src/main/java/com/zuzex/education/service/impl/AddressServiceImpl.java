package com.zuzex.education.service.impl;

import com.zuzex.education.exception.AddressNotFoundException;
import com.zuzex.education.model.db.Address;
import com.zuzex.education.repository.AddressRepository;
import com.zuzex.education.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address get(UUID id) {
        return addressRepository.findById(id).orElseThrow(() -> new AddressNotFoundException(id));
    }

    @Override
    public Address create(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address update(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void delete(UUID id) {
        addressRepository.deleteById(id);
    }
}
