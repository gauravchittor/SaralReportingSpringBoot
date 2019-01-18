package com.saral.reporting.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saral.reporting.model.LoginData;

public interface LoginRepository extends JpaRepository<LoginData, String > {
}
