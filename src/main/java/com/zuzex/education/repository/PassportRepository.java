package com.zuzex.education.repository;

import com.zuzex.education.model.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PassportRepository extends JpaRepository<Passport, UUID> {
}
