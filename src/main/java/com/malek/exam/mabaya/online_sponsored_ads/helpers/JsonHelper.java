package com.malek.exam.mabaya.online_sponsored_ads.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;


public class JsonHelper {

    public static JSONObject readJson(String pathName) {
        BufferedReader bf = new BufferedReader(new InputStreamReader((JsonHelper.class.getResourceAsStream(pathName))));
        JSONParser parser = new JSONParser();
        try {
            return (JSONObject) parser.parse(bf);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T getJsonObject(String filePath, Class<T> classType) {
        T item = null;
        JSONObject json = (JSONObject) JsonHelper.readJson(filePath);
        try {
            if (json != null) {
                item = new ObjectMapper().readValue(json.toJSONString(), classType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    public static <T> T[] getJsonArray(String filePath, Class<T[]> classType) {
        T[] items = null;
        try {
            JSONObject jsonObj = (JSONObject) JsonHelper.readJson(filePath);
            if (jsonObj != null && jsonObj.get("data") != null) {
                JSONArray json = (JSONArray) jsonObj.get("data");
                items = new ObjectMapper().readValue(json.toJSONString(), classType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }
}