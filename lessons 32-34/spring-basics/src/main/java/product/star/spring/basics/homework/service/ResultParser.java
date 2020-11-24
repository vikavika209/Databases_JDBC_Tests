package product.star.spring.basics.homework.service;

import java.time.Duration;
import org.springframework.stereotype.Service;
import product.star.spring.basics.homework.model.Distance;
import product.star.spring.basics.homework.model.Gender;
import product.star.spring.basics.homework.model.Person;
import product.star.spring.basics.homework.model.Result;

@Service
public class ResultParser {

    private static final String SEPARATOR = ",";

    /**
     * Распарсить строку из файла в {@link Result}.
     * </p>
     * Результаты хранятся в формате: Иван Иванов, М, 10 км, 55:20
     */
    public Result parseResult(String line) {
        var resultParts = line.split(SEPARATOR);

        var name = resultParts[0];
        var gender = Gender.of(resultParts[1]);
        var distance = Distance.of(resultParts[2]);
        var time = parseTime(resultParts[3]);

        var person = new Person(name, gender);
        return new Result(person, distance, time);
    }

    /**
     * Распарсить строку MM:SS в {@link Duration}.
     * </p>
     * Предполагаем, что все спортсмены уложились в один час в целях упрощения парсинга.
     */
    private Duration parseTime(String time) {
        var timeParts = time.split(":");

        // Минуты умножнаем на 60 и добавляем секунды
        var totalSecond = Integer.valueOf(timeParts[0]) * 60 + Integer.valueOf(timeParts[1]);
        return Duration.ofSeconds(totalSecond);
    }
}
