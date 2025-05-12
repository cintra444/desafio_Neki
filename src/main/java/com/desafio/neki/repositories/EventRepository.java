package com.desafio.neki.repositories;

import com.desafio.neki.models.Admin;
import com.desafio.neki.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    public Event findByAdminId(Admin admin);
}
