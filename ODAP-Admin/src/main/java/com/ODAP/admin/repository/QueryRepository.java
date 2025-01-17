package com.ODAP.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ODAP.admin.entity.Query;

@Repository
public interface QueryRepository extends JpaRepository<Query, Long> {

}
