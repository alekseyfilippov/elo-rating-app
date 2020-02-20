package org.exapmle.eloapp.webapp;

import org.exapmle.eloapp.algorithm.GamePair;
import org.exapmle.eloapp.algorithm.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages="org.exapmle.eloapp.webapp.domain")
public class Application extends SpringBootServletInitializer{

        @Bean
        Match match() {
            return new Match(gamePair());
        }

        @Bean
        GamePair gamePair() {
            return new GamePair();
        }

        @Autowired
        GamePair gamePair;
        @Autowired
        Match play;

        public static void main(String[] args) {
            ApplicationContext ctx = SpringApplication.run(Application.class, args);
            Match match = ctx.getBean(Match.class);
            match.start();
        }
}