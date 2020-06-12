package com.malek.exam.mabaya.online_sponsored_ads.helpers;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;


public class JsonHelper {

    public static JSONObject readJson(String pathName) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(new FileReader(pathName));
    }
}