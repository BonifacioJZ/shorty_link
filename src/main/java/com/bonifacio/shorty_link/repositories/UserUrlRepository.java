package com.bonifacio.shorty_link.repositories;

import com.bonifacio.shorty_link.entities.UserUrl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserUrlRepository extends JpaRepository<UserUrl, UUID> {
}
