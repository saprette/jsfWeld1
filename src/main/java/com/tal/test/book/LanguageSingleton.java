package com.tal.test.book;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@ApplicationScoped
public class LanguageSingleton {

    // ======================================
    // =             Attributes             =
    // ======================================

    private Logger logger = Logger.getLogger("org.devoxx.javaee6");

    private Map<String, String> languages;

    // ======================================
    // =          Lifecycle methods         =
    // ======================================

    @PostConstruct
    private void initLanguages() {
        languages = new HashMap<String, String>();
        languages.put("EN", "English");
        languages.put("FR", "French");
        languages.put("DE", "German");
        languages.put("ES", "Spanish");
        languages.put("FI", "Finnish");
        languages.put("IT", "Italian");
        languages.put("RU", "Russian");
        logger.info("Loaded " + languages.size() + " languages !");
    }

    // ======================================
    // =          Business methods          =
    // ======================================

    public String getLanguageValue(String code) {
        return languages.containsKey(code.toUpperCase()) ? languages.get(code.toUpperCase()) : "UNKNOWN";
    }
}