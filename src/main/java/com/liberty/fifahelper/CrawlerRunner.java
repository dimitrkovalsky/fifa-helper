package com.liberty.fifahelper;

import com.liberty.fifahelper.crawler.CrawlerService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class CrawlerRunner {

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(CrawlerRunner.class).run(args);
        CrawlerService service = context.getBean(CrawlerService.class);
        service.fetchAllPlayers();
        System.exit(0);
    }
}
