package com.ODAP.DRRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ODAP.DREntity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {



}
