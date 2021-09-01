package com.capfer.deepcopy;

import com.capfer.exceptions.ObjectFieldsCopyException;
import com.capfer.exceptions.ObjectNotFoundException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public final class CopyUtils
{
    @SuppressWarnings("unchecked")
    public static  <T> T deepCopy (final T objToCopy) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException
    {
        if (Objects.isNull(objToCopy)) {
            throw new ObjectNotFoundException("Wrong object provided");
        }

        Class<?> tClass = objToCopy.getClass();
        T newObject = (T) objToCopy.getClass().getDeclaredConstructor().newInstance();

        while (Objects.nonNull(tClass))
        {
            copyObjectFields(objToCopy, newObject, tClass);
            tClass = tClass.getSuperclass();
        }

        return newObject;
    }

    private static <T> void copyObjectFields (final T objToCopy, final T newObject, Class<?> tClass)
    {
        List<Field> fields = new ArrayList<>(Arrays.asList(tClass.getDeclaredFields()));

        fields.forEach(field -> {
            field.setAccessible(true);
            try {
                field.set(newObject, field.get(objToCopy));
            } catch (IllegalAccessException e) {
                throw new ObjectFieldsCopyException("Exception Copying Fields {}" + e.getMessage());
            }
        });

    }
}
