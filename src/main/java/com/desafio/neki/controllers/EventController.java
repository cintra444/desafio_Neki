package com.desafio.neki.controllers;

import com.desafio.neki.dtos.EventDto;
import com.desafio.neki.services.EventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService eventService;


    @PostMapping("/create")
    @Operation(summary = "Create Event", description = "Endpoint para criar um evento")
    @ApiResponse(responseCode = "200", description = "Evento criado com sucesso")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EventDto> createEvent(@Valid @RequestBody EventDto eventDto) {
        try {
            EventDto event = eventService.createEvent(eventDto);

            return ResponseEntity.status(HttpStatus.CREATED).body(event);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
