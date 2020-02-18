package org.exapmle.eloapp;

import javassist.compiler.ast.Pair;
import org.exapmle.eloapp.domain.GamePair;
import org.exapmle.eloapp.domain.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
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
        Match letsFigh;

        public static void main(String[] args) {
            ApplicationContext ctx = SpringApplication.run(Application.class, args);
            Match match = ctx.getBean(Match.class);
            match.go();
        }
}