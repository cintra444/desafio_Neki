package com.desafio.neki.services;

import com.desafio.neki.dtos.EventDto;
import com.desafio.neki.models.Admin;
import com.desafio.neki.models.Event;
import com.desafio.neki.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public EventDto createEvent(EventDto eventDto) {

        Event event = new Event();
        event.setNome(eventDto.name());
        event.setDescription(eventDto.description());
        event.setData(eventDto.data());
        event.setLocalizacao(eventDto.localizacao());
        event.setImagem(eventDto.imagem());
        event.setAdminId(new Admin(eventDto.adminId()));
        eventRepository.save(event);

        return EventDto.toDto(event);
    }
}
