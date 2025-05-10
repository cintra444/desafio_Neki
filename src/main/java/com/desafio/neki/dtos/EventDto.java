package com.desafio.neki.dtos;

import com.desafio.neki.models.Event;

import java.time.LocalDate;

public record EventDto(
    Integer id,
    String name,
    String description,
    LocalDate data,
    String localizacao,
    byte[] imagem,
    Integer adminId
) {
    public Event toEntity() {
        Event event = new Event();
        event.setId(id);
        event.setNome(name);
        event.setDescription(description);
        event.setData(data);
        event.setLocalizacao(localizacao);
        event.setImagem(imagem);

        return event;
    }
    public static EventDto toDto(Event event) {
        return new EventDto(
            event.getId(),
            event.getNome(),
            event.getDescription(),
            event.getData(),
            event.getLocalizacao(),
            event.getImagem(),
            event.getAdminId().getId()
        );
    }
}
