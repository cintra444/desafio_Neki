package com.desafio.neki.repositories;

import com.desafio.neki.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

}
