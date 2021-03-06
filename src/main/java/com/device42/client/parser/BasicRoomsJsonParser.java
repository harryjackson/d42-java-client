package com.device42.client.parser;

import com.device42.client.model.Room;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BasicRoomsJsonParser extends AbstractJsonObjectListParser<Room>{
    private BasicRoomJsonParser roomJsonParser = new BasicRoomJsonParser();

    @Override
    public List<Room> parse(JSONObject json) throws JSONException {
        JSONArray jsonArray = json.getJSONArray("rooms");
        storeLimits(json);
        List<Room> res = new ArrayList<>(jsonArray.length());
        for (int i = 0; i < jsonArray.length(); i++) {
            res.add(roomJsonParser.parse(jsonArray.getJSONObject(i)));
        }
        return res;
    }
}
