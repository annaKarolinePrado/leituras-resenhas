package com.leiturasresenhas.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@FacesConverter(value = "localDateTimeConverter")
public class LocalDateTimeConverter implements Converter {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        try {
            return LocalDateTime.parse(value, formatter);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid date format", e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        try {
            LocalDateTime localDateTime = (LocalDateTime) value;
            return localDateTime.format(formatter);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid LocalDateTime object", e);
        }
    }
}
