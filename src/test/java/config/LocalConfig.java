package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:local_driver.properties"})
public interface LocalConfig extends Config {
    @Key("device")
    String getDeviceName();

    @Key("os_version")
    String getPlatformVersion();

    @Key("localServerUrl")
    String getServerUrl();
}
