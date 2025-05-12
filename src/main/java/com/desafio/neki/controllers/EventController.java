package com.desafio.neki.controllers;

import com.desafio.neki.dtos.EventDto;
import com.desafio.neki.services.EventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.util.List;

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

        @GetMapping("/list")
        @Operation(summary = "List Events", description = "Endpoint para listar todos os eventos")
        @ApiResponse(responseCode = "200", description = "Eventos listados com sucesso")
        public ResponseEntity<List<EventDto>> listEvents() {
            return ResponseEntity.ok(eventService.listEvents());
    }

        @GetMapping("/{id}")
        @Operation(summary = "Get Event by ID", description = "Endpoint para buscar um evento pelo id")
        @ApiResponse(responseCode = "200", description = "Evento encontrado com sucesso")
        public ResponseEntity<EventDto> getEventById(@PathVariable Integer id) {
            return ResponseEntity.ok(eventService.getEventById(id));
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update Event", description = "Endpoint para atualizar um evento pelo id")
    @ApiResponse(responseCode = "200", description = "Evento atualizado com sucesso")
    public ResponseEntity<EventDto> updateEvent(@PathVariable Integer id, @Valid @RequestBody EventDto eventDto) {
        return ResponseEntity.ok(eventService.updateEvent(id, eventDto));
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete Event", description = "Endpoint para deletar um evento pelo id")
    @ApiResponse(responseCode = "204", description = "Evento deletado com sucesso")
    public ResponseEntity<Void> deleteEvent(@PathVariable Integer id) {
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/upload-image")
    @Operation(summary = "Upload Event Image", description = "Endpoint para enviar a imagem de um evento pelo id")
    @ApiResponse(responseCode = "200", description = "Imagem do evento enviada com sucesso")
    public ResponseEntity<EventDto> uploadEventImage(@PathVariable Integer id, @RequestParam("image") MultipartFile image) {
       try {
        EventDto update = eventService.uploadEventImage(id, image.getBytes());
        return ResponseEntity.ok(update);
    } catch (IOException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    }

    @GetMapping("/{id}/imagem")
    @Operation(summary = "Get Event Image by ID", description = "Endpoint para buscar a imagem de um evento pelo id")
    @ApiResponse(responseCode = "200", description = "Imagem do evento encontrada com sucesso")
    public ResponseEntity<byte[]> getEventImageById(@PathVariable Integer id) {
        byte[] image = eventService.getEventImageById(id);
        MediaType contentType = MediaType.IMAGE_JPEG;
        return ResponseEntity.ok()
                .contentType(contentType)
                .body(image);
    }

    @GetMapping("/admin/{adminId}")
    @Operation(summary = "Get Events by Admin ID", description = "Endpoint para buscar todos os eventos de um admin pelo id")
    @ApiResponse(responseCode = "200", description = "Eventos encontrados com sucesso")
    public ResponseEntity<List<EventDto>> getEventsByAdminId(@PathVariable Integer adminId) {
        return ResponseEntity.ok(eventService.getEventsByAdminId(adminId));
    }
}
