package com.cityjokes.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * The JSON Conversion utility
 *
 * @author lilit
 */
public class GsonConverter {

    private static String getDateFormat() {
        return "yyyy-MM-dd'T'HH:mm:ss.SSS";
    }


    public static <T> T fromJson(String json, Class<T> classType) {

        return new GsonBuilder().setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, (JsonDeserializer<LocalDate>) (json1, type, jsonDeserializationContext) -> LocalDate.parse(json1.getAsJsonPrimitive().
                getAsString())).registerTypeAdapter(LocalTime.class, (JsonDeserializer<LocalTime>) (json12, type, jsonDeserializationContext) -> LocalTime.parse(json12.getAsJsonPrimitive().getAsString())).
                registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json13, type, jsonDeserializationContext)  -> LocalDateTime.parse(json13.getAsJsonPrimitive().getAsString()))
                .enableComplexMapKeySerialization().serializeNulls().create().fromJson(json, classType);

    }

    /**
     * A fast adapter method to change types with exact same schema
     *
     * @param <From> The source type
     * @param <To> The target type
     * @param object The object
     * @param targetType The target type
     * @return
     */
//    public static <From, To> To adapt(From object, Class<To> targetType) {
//        return fromJson(toJson(object), targetType);
//    }
    public static Gson fromWithDateTime() {
        return new GsonBuilder().registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, type, jsonDeserializationContext) -> {
            Instant instant = Instant.parse(json.getAsString());
            return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        }).create();
    }

//    public static Gson fromWithZoneDateTime() {
//        Gson gson = new GsonBuilder().registerTypeAdapter(ZonedDateTime.class, (JsonDeserializer<ZonedDateTime>) (json, type, jsonDeserializationContext) -> ZonedDateTime.parse(json.getAsJsonPrimitive().getAsString())).create();
//
//        return gson;
//    }
}
