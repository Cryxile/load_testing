package com.zuzex.education.repository.hibernate;

import com.zuzex.education.model.db.Address;
import com.zuzex.education.repository.AddressRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@Profile("hibernate")
public interface AddressHibernateRepository extends JpaRepository<Address, UUID>, AddressRepository {
}
