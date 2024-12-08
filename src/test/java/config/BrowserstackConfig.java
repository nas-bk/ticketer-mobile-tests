package config;

import org.aeonbits.owner.Config;

@BrowserstackConfig.LoadPolicy(BrowserstackConfig.LoadType.MERGE)
@Config.Sources({
        "classpath:browserstack.properties",
        "system:properties"
})
public interface BrowserstackConfig extends Config {

    @Key("userName")
    String getUserName();

    @Key("key")
    String getKey();

    @Key("remoteUrl")
    String getRemoteUrl();

    @Key("projectName")
    String getProjectName();

    @Key("buildName")
    String getBuildName();

    @Key("deviceName")
    String getDeviceName();

    @Key("platformVersion")
    String getPlatformVersion();

    @Key("app")
    String getApp();
}
