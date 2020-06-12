package com.malek.exam.mabaya.online_sponsored_ads.services;

import com.malek.exam.mabaya.online_sponsored_ads.helpers.JsonHelper;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TranslationService {
    private final String resourceFileUri = "src/main/resources/appResource.json";
    private JSONObject translationObj;

    public TranslationService() throws IOException, ParseException {
        translationObj = JsonHelper.readJson(resourceFileUri);
    }

    public String translate(String key) {
        return translationObj.get(key).toString();
    }

}
