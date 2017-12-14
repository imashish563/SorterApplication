package com.tcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.jpa.model.AppData;



@Transactional
@Repository
public interface AppDataRepository extends JpaRepository<AppData, String> {

}
