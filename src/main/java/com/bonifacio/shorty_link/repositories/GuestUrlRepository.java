package com.bonifacio.shorty_link.repositories;

import com.bonifacio.shorty_link.entities.GuestUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GuestUrlRepository extends JpaRepository<GuestUrl, UUID> {
    GuestUrl findBySlug(String slug);

}
