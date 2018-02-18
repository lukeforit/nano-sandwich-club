package com.udacity.sandwichclub;

import android.text.TextUtils;
import android.view.View;

import com.udacity.sandwichclub.model.Sandwich;

public class SandwichDetailsViewModel {
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
        return TextUtils.join(", ", sandwich.getAlsoKnownAs());
    }
    public String getIngredients() {
        return TextUtils.join(", ", sandwich.getIngredients());
    }

    public int getOriginVisibility() {
        return TextUtils.isEmpty(sandwich.getPlaceOfOrigin()) ? View.GONE : View.VISIBLE;
    }

    public int getAlsoKnownAsVisibility() {
        return sandwich.getAlsoKnownAs() == null || sandwich.getAlsoKnownAs().isEmpty() ? View.GONE
                : View.VISIBLE;
    }
}
