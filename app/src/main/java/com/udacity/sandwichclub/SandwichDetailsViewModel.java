package com.udacity.sandwichclub;

import android.text.TextUtils;
import android.view.View;

import com.udacity.sandwichclub.model.Sandwich;

import java.util.List;

class SandwichDetailsViewModel {
    private final Sandwich sandwich;

    SandwichDetailsViewModel(Sandwich sandwich) {
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

    public int getOriginVisibility() {
        return TextUtils.isEmpty(sandwich.getPlaceOfOrigin()) ? View.GONE : View.VISIBLE;
    }

    public int getAlsoKnownAsVisibility() {
        return sandwich.getAlsoKnownAs() == null || sandwich.getAlsoKnownAs().isEmpty() ? View.GONE
                : View.VISIBLE;
    }

    @SuppressWarnings("SameParameterValue")
    private String getListAsSingleString(List<String> list, String separator) {
        if (list == null || list.isEmpty()) {
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
