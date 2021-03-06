package com.device42.client.parser;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.device42.client.model.Part;

public class BasicPartsJsonParser extends AbstractJsonObjectListParser<Part> {
    private BasicPartJsonParser partJsonParser = new BasicPartJsonParser();

    @Override
    public List<Part> parse(JSONObject json) throws JSONException {
        JSONArray jsonArray = json.getJSONArray("parts");
        storeLimits(json);
        List<Part> res = new ArrayList<>(jsonArray.length());
        for (int i = 0; i < jsonArray.length(); i++) {
            res.add(partJsonParser.parse(jsonArray.getJSONObject(i)));
        }
        return res;
    }
}
