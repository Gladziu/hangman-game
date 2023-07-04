package org.example;

import java.util.HashMap;
import java.util.Map;

public class WisielecVisual {
    Map<Integer, String> dictionary = new HashMap<>();

    public String getWisielecVisual(Integer lives) {
        dictionary.put(9, "");
        dictionary.put(8,
                """
                   |
                   |
                   |
                   |
                   |\
                """);
        dictionary.put(7, """
                    ___________
                   | /       \s
                   |/       \s
                   |         \s
                   |         \s
                   |\
                """);
        dictionary.put(6, """
                    ___________
                   | /        |\s
                   |/       \s
                   |         \s
                   |         \s
                   |\
                """);
        dictionary.put(5, """
                    ___________
                   | /        |\s
                   |/        ( )
                   |         \s
                   |         \s
                   |\
                """);
        dictionary.put(4, """
                    ___________
                   | /        |\s
                   |/        ( )
                   |          |
                   |         \s
                   |\
                """);
        dictionary.put(3, """
                    ___________
                   | /        |\s
                   |/        ( )
                   |          |
                   |         /
                   |\
                """);
        dictionary.put(2, """
                    ___________
                   | /        |\s
                   |/        ( )
                   |          |
                   |         / \\
                   |\
                """);
        dictionary.put(1, """
                    ___________
                   | /        |\s
                   |/        ( )
                   |        / |
                   |         / \\
                   |\
                """);
        dictionary.put(0, """
                    ___________
                   | /        |\s
                   |/        ( )
                   |        / | \\\s
                   |         / \\
                   |\
                """);
        return dictionary.get(lives);
    }
}
