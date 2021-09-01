package com.capfer;

import com.capfer.deepcopy.CopyUtils;
import com.capfer.deepcopy.Man;
import com.sun.tools.javac.util.List;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

public class DeepCopyTest
{
    @Test
    public void testDeepCopy () throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException
    {
        Man man = new Man();
        Man man1 = CopyUtils.deepCopy(man);

        assertNotNull(man);
        assertNotNull(man1);

        assertEquals(man, man1);

        Man man3 = createMan("Carlos", 34, List.of("Cay S. Horstmann Core Java Volume I", "Kousen, Ken Modern Java Recipes"));
        Man man4 = CopyUtils.deepCopy(man3);

        assertNotEquals(man3, man1);
        assertEquals(man3, man4);

        System.out.println(man3 + " and \n" + man4 + " are same objects.");

        Man man5 = createMan("Ilya", 40, List.of("Java 8 in action", "Junit 5 in Action"));
        Man man6 = CopyUtils.deepCopy(man4);

        assertNotEquals(man5, man6);

    }

    private Man createMan (String name, int age, List<String> favoriteBooks)
    {
        return new Man(name, age, favoriteBooks);
    }

}
