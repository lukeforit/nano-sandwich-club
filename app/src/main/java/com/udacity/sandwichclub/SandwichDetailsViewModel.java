package com.udacity.sandwichclub;

import android.content.Context;

import com.udacity.sandwichclub.model.Sandwich;

import java.util.List;

public class SandwichDetailsViewModel {
    private Context context;
    private Sandwich sandwich;

    public SandwichDetailsViewModel(Context context, Sandwich sandwich) {
        this.context = context;
        this.sandwich = sandwich;
    }

    public String getOrigin() {
        return sandwich.getPlaceOfOrigin();
    }
    public String getDescription() {
        return sandwich.getDescription();
    }
    public String getAlsoKnownAs() {
        return getListAsSingleString(sandwich.getAlsoKnownAs(), ", ");
    }
    public String getIngredients() {
        return getListAsSingleString(sandwich.getIngredients(), ", ");
    }

    private String getListAsSingleString(List<String> list, String separator) {
        if (list == null) {
            return "";
        } else {
            StringBuilder builder = new StringBuilder();
            for (String item : list) {
                builder.append(item).append(separator);
            }
            return builder.substring(0, builder.length()-3);
        }
    }
}
