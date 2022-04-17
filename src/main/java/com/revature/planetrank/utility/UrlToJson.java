package com.revature.planetrank.utility;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlToJson {

    String jsonUrl;

    public UrlToJson(String jsonUrl) {
        this.jsonUrl = jsonUrl;
    }

    public JSONObject getJsonObject() throws IOException, ParseException {
        InputStream inputStream = new URL(jsonUrl).openStream();
        JSONParser jsonParser = new JSONParser();
        return (JSONObject)jsonParser.parse(new InputStreamReader(inputStream, "UTF-8"));

    }


}
