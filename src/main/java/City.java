public class City {
    private String cityName;
    private int cityId;

    public City(String city_name, int city_id) {
        this.cityName = city_name;
        this.cityId = city_id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}
