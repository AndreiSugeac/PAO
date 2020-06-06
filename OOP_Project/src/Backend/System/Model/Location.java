package Backend.System.Model;

import java.util.Objects;

public class Location {
    private String country;
    private String city;
    private String venue;

    public Location(String country, String city, String venue) {
        this.country = country;
        this.city = city;
        this.venue = venue;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    @Override
    public String toString() {
        return "Location{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", venue='" + venue + '\'' +
                '}';
    }

    public String toStringCsv() {
        return "" + country  +
                "," + city  +
                "," + venue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(country, location.country) &&
                Objects.equals(city, location.city) &&
                Objects.equals(venue, location.venue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city, venue);
    }
}
