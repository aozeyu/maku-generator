package net.maku.generator.autoconfigure;

import lombok.AllArgsConstructor;
import net.maku.generator.config.template.GeneratorConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * spring boot starter AutoConfiguration
 *
 * @author 阿沐 babamu@126.com
 */
@Configuration
@AllArgsConstructor
@MapperScan("net.maku.generator.dao")
@ComponentScan(basePackages = {"net.maku.generator"})
@EnableConfigurationProperties(GeneratorProperties.class)
public class GeneratorAutoConfiguration {
    private final GeneratorProperties properties;

    @Bean
    GeneratorConfig generatorConfig() {
        return new GeneratorConfig(properties.getTemplate());
    }

}
