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
            try {
                JSONObject rootJson = new JSONObject(json);
                if (rootJson.has(KEY_NAME)) {
                    JSONObject nameNode = rootJson.getJSONObject(KEY_NAME);
                    if (nameNode.has(KEY_MAIN_NAME)) {
                        sandwich.setMainName(nameNode.getString(KEY_MAIN_NAME));
                    }
                    if (nameNode.has(KEY_ALSO_KNOWN_AS)) {
                        sandwich.setAlsoKnownAs(
                                jsonArrayToListOfStrings(KEY_ALSO_KNOWN_AS, nameNode));
                    }
                }
                if (rootJson.has(KEY_DESCRIPTION)) {
                    sandwich.setDescription(rootJson.getString(KEY_DESCRIPTION));
                }
                if (rootJson.has(KEY_IMAGE)) {
                    sandwich.setImage(rootJson.getString(KEY_IMAGE));
                }
                if (rootJson.has(KEY_PLACE_OF_ORIGIN)) {
                    sandwich.setPlaceOfOrigin(rootJson.getString(KEY_PLACE_OF_ORIGIN));
                }
                if (rootJson.has(KEY_INGREDIENTS)) {
                    sandwich.setIngredients(
                            jsonArrayToListOfStrings(KEY_INGREDIENTS, rootJson));
                }
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return sandwich;
    }

    private static List<String> jsonArrayToListOfStrings(String key, JSONObject node)
            throws JSONException {
        JSONArray alsoKnownAsArray = node.getJSONArray(key);
        List<String> alsoKnownAsList = new ArrayList<>();
        for (int i = 0; i < alsoKnownAsArray.length(); i++) {
            alsoKnownAsList.add(alsoKnownAsArray.getString(i));
        }
        return alsoKnownAsList;
    }
}
