package com.desafio.neki.services;

import com.desafio.neki.dtos.EventDto;
import com.desafio.neki.exception.ResourceNotFoundException;
import com.desafio.neki.models.Admin;
import com.desafio.neki.models.Event;
import com.desafio.neki.repositories.AdminRepository;
import com.desafio.neki.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private AdminRepository adminRepository;

    public EventDto createEvent(EventDto eventDto) {

        Admin admin = adminRepository.findById(eventDto.adminId())
                .orElseThrow(() -> new ResourceNotFoundException("Admin nao encontrado","Admin not found"));
        Event event = eventDto.toEntity(admin);
        return EventDto.toDto(eventRepository.save(event));
    }

    public List<EventDto> listEvents() {
        return eventRepository.findAll().stream()
                .map(EventDto::toDto)
                .collect(Collectors.toList());
    }

    public EventDto getEventById(Integer id) {
        Event event = eventRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new ResourceNotFoundException("Evento nao encontrado","Event not found"));
        return EventDto.toDto(event);
    }

    public EventDto updateEvent(Integer id, EventDto eventDto) {
        Event event = eventRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new ResourceNotFoundException("Evento nao encontrado","Event not found"));
        event.setNome(eventDto.name());
        event.setDescription(eventDto.description());
        event.setData(eventDto.data());
        event.setLocalizacao(eventDto.localizacao());
        event.setImagem(eventDto.imagem());
        return EventDto.toDto(eventRepository.save(event));
    }

    public void deleteEvent(Integer id) {
        if(!eventRepository.existsById(Long.valueOf(id))) {
            throw new ResourceNotFoundException("Evento nao encontrado","Event not found");
        }
        eventRepository.deleteById(Long.valueOf(id));
    }


    public EventDto uploadEventImage(Integer id, byte[] image) {
        Event event = eventRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new ResourceNotFoundException("Evento nao encontrado","Event not found"));
        event.setImagem(image);
        return EventDto.toDto(eventRepository.save(event));
    }


    public byte[] getEventImageById(Integer id) {
        Event event = eventRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new ResourceNotFoundException("Evento nao encontrado","Event not found"));
        return event.getImagem();
    }

    public List<EventDto> getEventsByAdminId(Integer adminId) {
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new ResourceNotFoundException("Admin nao encontrado","Admin not found"));

        return eventRepository.findAll().stream()
                .filter(event -> event.getAdminId().equals(admin.getId()))
                .map(EventDto::toDto)
                .collect(Collectors.toList());
    }
}
