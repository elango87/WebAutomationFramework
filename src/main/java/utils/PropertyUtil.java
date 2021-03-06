package utils;

import constants.WAFConstants;
import enums.ConfigProperties;
import exceptions.PropertyReaderException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class PropertyUtil {

    private static final Map<String, String> PROPERTY_MAP = new HashMap<>();

    private PropertyUtil() {
    }

    private static void readConfig() {
        String configFilePath = WAFConstants.getConfigFilePath();
        var properties = new Properties();
        try (FileInputStream fis = new FileInputStream(configFilePath)) {
            properties.load(fis);
            for (String key : properties.stringPropertyNames()) {
                PROPERTY_MAP.put(key, properties.getProperty(key).trim());
            }
        } catch (FileNotFoundException e) {
            throw new PropertyReaderException("File not found in {" + configFilePath + "}");
        } catch (IOException e) {
            throw new PropertyReaderException("Unable to read file {" + configFilePath + "}");
        }
    }

    public static String getProperty(ConfigProperties key) {
        if (PROPERTY_MAP.size() < 1) {
            readConfig();
        }
        if ((null == key.getConfig()) ||
                (null == (PROPERTY_MAP.get(key.getConfig()))) ||
                (PROPERTY_MAP.get(key.getConfig()).isEmpty())) {
            throw new PropertyReaderException("Key {" + key + "} does not exist in {config.properties} file. Please check!");
        }
        return PROPERTY_MAP.get(key.getConfig());
    }

    public static void setProperty(ConfigProperties key, String value) {
        if (PROPERTY_MAP.size() < 1) {
            readConfig();
        }
        if ((null == key.getConfig()) ||
                (null == (PROPERTY_MAP.get(key.getConfig()))) ||
                (PROPERTY_MAP.get(key.getConfig()).isEmpty())) {
            throw new PropertyReaderException("Key {" + key + "} does not exist in {config.properties} file. Please check!");
        }
        PROPERTY_MAP.put(key.getConfig(), value);
    }
}