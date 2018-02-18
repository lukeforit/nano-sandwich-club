package com.udacity.sandwichclub.utils;

import android.text.TextUtils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    private static final String KEY_NAME = "name";
    private static final String KEY_MAIN_NAME = "mainName";
    private static final String KEY_ALSO_KNOWN_AS = "alsoKnownAs";
    private static final String KEY_PLACE_OF_ORIGIN = "placeOfOrigin";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_IMAGE = "image";
    private static final String KEY_INGREDIENTS = "ingredients";

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();
        if (!TextUtils.isEmpty(json)) {
            JSONObject rootJson;
            try {
                rootJson = new JSONObject(json);
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
            JSONObject nameNode = rootJson.optJSONObject(KEY_NAME);
            if (nameNode != null) {
                sandwich.setMainName(nameNode.optString(KEY_MAIN_NAME));
                sandwich.setAlsoKnownAs(
                        jsonArrayToListOfStrings(KEY_ALSO_KNOWN_AS, nameNode));
            }
            sandwich.setDescription(rootJson.optString(KEY_DESCRIPTION));
            sandwich.setImage(rootJson.optString(KEY_IMAGE));
            sandwich.setPlaceOfOrigin(rootJson.optString(KEY_PLACE_OF_ORIGIN));
            sandwich.setIngredients(jsonArrayToListOfStrings(KEY_INGREDIENTS, rootJson));

        }
        return sandwich;
    }

    private static List<String> jsonArrayToListOfStrings(String key, JSONObject node) {
        JSONArray alsoKnownAsArray = node.optJSONArray(key);
        List<String> alsoKnownAsList = new ArrayList<>();
        if (alsoKnownAsArray != null) {
            for (int i = 0; i < alsoKnownAsArray.length(); i++) {
                alsoKnownAsList.add(alsoKnownAsArray.optString(i));
            }
        }
        return alsoKnownAsList;
    }
}
