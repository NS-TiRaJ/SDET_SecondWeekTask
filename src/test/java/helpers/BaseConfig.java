package helpers;

import org.aeonbits.owner.Config;

/**
 * Интерфейс с параметрами базовой конфигурации
 */
@Config.Sources({"classpath:config.properties"})
public interface BaseConfig extends Config {
    String url();
}
