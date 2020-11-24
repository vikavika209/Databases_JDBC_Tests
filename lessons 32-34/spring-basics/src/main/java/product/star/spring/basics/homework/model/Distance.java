package product.star.spring.basics.homework.model;

import java.util.Objects;
import java.util.stream.Stream;

public enum Distance {
    FIVE_KM("5 km"),
    TEN_KM("10 km");

    private final String code;

    Distance(String code) {
        this.code = code;
    }

    /**
     * Вернуть дистанцию по коду из протокола.
     * </p>
     * 5 km ->
     */
    public static Distance of(String code) {
        return Stream.of(values())
                .filter(d -> Objects.equals(d.code, code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown distance: " + code));
    }
}
