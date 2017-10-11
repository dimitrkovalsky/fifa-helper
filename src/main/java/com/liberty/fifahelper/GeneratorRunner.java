package com.liberty.fifahelper;

import com.liberty.fifahelper.crawler.CrawlerService;
import com.liberty.fifahelper.model.BuyPlayerInfo;
import com.liberty.fifahelper.service.BuyPlayerService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class GeneratorRunner {
    private static BuyPlayerService service;

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(GeneratorRunner.class).run(args);
        service = context.getBean(BuyPlayerService.class);
        addPlayers();
        System.exit(0);
    }

    private static void addPlayers() {
        add("213135", 1200);
        add("200641", 1000);
    }

    private static void add(String playerId, long buyNowPrice) {
        BuyPlayerInfo info = new BuyPlayerInfo();
        info.setPlayerId(playerId);
        info.setBuyNow(buyNowPrice);
        service.addPlayerForBuy("ADMIN", info);
    }

}
