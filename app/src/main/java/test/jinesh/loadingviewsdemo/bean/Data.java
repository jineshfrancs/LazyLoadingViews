package test.jinesh.loadingviewsdemo.bean;

import android.graphics.drawable.Drawable;

/**
 * Created by Jinesh on 03-03-2017.
 */

public class Data {
    private String cityName;
    private String stateName;
    private String countryName;
    private Drawable cityImage;
    private boolean isLoading;

    public Data(String cityName, String stateName, String countryName, Drawable cityImage, boolean isLoading) {
        this.cityName = cityName;
        this.stateName = stateName;
        this.countryName = countryName;
        this.cityImage = cityImage;
        this.isLoading = isLoading;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Drawable getCityImage() {
        return cityImage;
    }

    public void setCityImage(Drawable cityImage) {
        this.cityImage = cityImage;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public boolean isLoading() {
        return isLoading;
    }

    public void setLoading(boolean loading) {
        isLoading = loading;
    }
}
