package com.skitbet.zephyr.utils;

import com.sun.jndi.toolkit.url.Uri;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class JSONUtils {

    public static JSONObject readJsonFromUrl(URL url) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(new InputStreamReader(url.openStream()));
        return json;
    }

}
