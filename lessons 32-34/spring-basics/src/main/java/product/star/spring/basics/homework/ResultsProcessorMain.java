package product.star.spring.basics.homework;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import product.star.spring.basics.homework.config.ResultsProcessorConfig;
import product.star.spring.basics.homework.model.Distance;
import product.star.spring.basics.homework.model.Gender;
import product.star.spring.basics.homework.model.Result;
import product.star.spring.basics.homework.service.ResultParser;
import product.star.spring.basics.homework.service.ResultsProcessor;
import product.star.spring.basics.homework.service.ResultsReader;

public class ResultsProcessorMain {

    public static void main(String[] args) throws IOException {
        var applicationContext = new AnnotationConfigApplicationContext(ResultsProcessorConfig.class);

        var resultsReader = applicationContext.getBean(ResultsReader.class);
        var filePath = new ClassPathResource("results.csv").getFile().toPath();
        var results = resultsReader.readFromFile(filePath);

        var resultsProcessor = new ResultsProcessor(results);
        List<Result> fastestMen = resultsProcessor.getFastest(Gender.MALE, Distance.TEN_KM, 3);

        System.out.println(fastestMen);
    }
}
