package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:emulation.properties"
})
public interface LocalMobileConfig extends Config {

    @Key("deviceName")
    String getDeviceName();

    @Key("platformVersion")
    String getPlatformVersion();

    @Key("appPackage")
    String getAppPackage();

    @Key("appActivity")
    String getAppActivity();

    @Key("appPath")
    String getAppPath();

    @Key("appiumServer")
    String getAppiumServer();
}
