package com.vinilab.ecommerce_api.repositories;

import com.vinilab.ecommerce_api.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
