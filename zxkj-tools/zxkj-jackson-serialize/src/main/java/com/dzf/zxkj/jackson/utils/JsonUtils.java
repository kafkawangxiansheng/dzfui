package com.dzf.zxkj.jackson.utils;

import com.dzf.zxkj.common.lang.DZFBoolean;
import com.dzf.zxkj.common.lang.DZFDate;
import com.dzf.zxkj.common.lang.DZFDateTime;
import com.dzf.zxkj.jackson.serializer.DZFBooleanSerializer;
import com.dzf.zxkj.jackson.serializer.DZFDateSerializer;
import com.dzf.zxkj.jackson.serializer.DZFDateTimeSerializer;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.apache.commons.lang3.SerializationException;

import java.text.SimpleDateFormat;

public class JsonUtils {
    public final static ObjectMapper objectMapper = new ObjectMapper();

    private JsonUtils() {
        throw new AssertionError();
    }


    static {
        SimpleModule module = new SimpleModule();
        module.addSerializer(DZFBoolean.class, new DZFBooleanSerializer());
        module.addSerializer(DZFDate.class, new DZFDateSerializer());
        module.addSerializer(DZFDateTime.class, new DZFDateTimeSerializer());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(module);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    public static String serialize(Object obj) throws SerializationException {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Throwable t) {
            throw new SerializationException(t);
        }
    }

    public static <T> T deserialize(String jsonString, Class<T> clazz) throws
            SerializationException {
        try {
            return objectMapper.readValue(jsonString, clazz);
        } catch (Throwable t) {
            throw new SerializationException(t);
        }
    }

    public static <T> T convertValue(Object obj, Class<T> clazz) {
        return objectMapper.convertValue(obj, clazz);
    }

    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

    public static <E> E deserialize(String jsonString, Class<E> collectionClass, Class<?> clazz) throws
            SerializationException {
        try {
            return objectMapper.readValue(jsonString, getCollectionType(collectionClass, clazz));
        } catch (Throwable t) {
            throw new SerializationException(t);
        }
    }


    public static JsonNode readNode(String jsonString) throws SerializationException {
        try {
            return objectMapper.readTree(jsonString);
        } catch (Throwable t) {
            throw new SerializationException(t);
        }
    }
}
