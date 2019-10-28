package com.duda.home.test.model;

import com.duda.home.test.util.BiMapConverter;
import com.duda.home.test.util.SetConverter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * School
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-27T23:26:20.212Z")
@Entity
public class School {

    @Id
    @GeneratedValue
    private Long id;

    @JsonProperty("Lat")
    private Double lat = null;

    @JsonProperty("Lon")
    private Double lon = null;

    @JsonProperty("minimumGpa")
    private Integer minimumGpa = null;

    @JsonProperty("maxNumberOfPupils")
    private Integer maxNumberOfPupils = null;

    @Convert(converter = BiMapConverter.class)
    private BiMap<Long, Long> friends = HashBiMap.create();

    @Convert(converter = SetConverter.class)
    private Set<Long> pupils = new HashSet<>();


    public Long getId() {
        return id;
    }

    public School lat(Double lat) {
        this.lat = lat;
        return this;
    }

    /**
     * Get lat
     *
     * @return lat
     **/
    @ApiModelProperty(value = "")


    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public School lon(Double lon) {
        this.lon = lon;
        return this;
    }

    /**
     * Get lon
     *
     * @return lon
     **/
    @ApiModelProperty(value = "")


    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public School minimumGpa(Integer minimumGpa) {
        this.minimumGpa = minimumGpa;
        return this;
    }

    /**
     * Get minimumGpa
     *
     * @return minimumGpa
     **/
    @ApiModelProperty(value = "")


    public Integer getMinimumGpa() {
        return minimumGpa;
    }

    public void setMinimumGpa(Integer minimumGpa) {
        this.minimumGpa = minimumGpa;
    }

    public School maxNumberOfPupils(Integer maxNumberOfPupils) {
        this.maxNumberOfPupils = maxNumberOfPupils;
        return this;
    }

    /**
     * Get maxNumberOfPupils
     *
     * @return maxNumberOfPupils
     **/
    @ApiModelProperty(value = "")


    public Integer getMaxNumberOfPupils() {
        return maxNumberOfPupils;
    }

    public void setMaxNumberOfPupils(Integer maxNumberOfPupils) {
        this.maxNumberOfPupils = maxNumberOfPupils;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        School school = (School) o;
        return Objects.equals(this.lat, school.lat) &&
                Objects.equals(this.lon, school.lon) &&
                Objects.equals(this.minimumGpa, school.minimumGpa) &&
                Objects.equals(this.maxNumberOfPupils, school.maxNumberOfPupils);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lat, lon, minimumGpa, maxNumberOfPupils);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class School {\n");

        sb.append("    lat: ").append(toIndentedString(lat)).append("\n");
        sb.append("    lon: ").append(toIndentedString(lon)).append("\n");
        sb.append("    minimumGpa: ").append(toIndentedString(minimumGpa)).append("\n");
        sb.append("    maxNumberOfPupils: ").append(toIndentedString(maxNumberOfPupils)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

    public boolean addFriends(Long first, Long second) {
        if (pupils.contains(first) && pupils.contains(second)) {
            friends.put(first, second);
            return true;
        }
        return false;
    }

    public double getFriendsInSchool() {
        return friends.size();
    }

    public Integer getCurrentNumberOfPupils() {
        return pupils.size();
    }

    public void addPupil(Long pupilId) {
        pupils.add(pupilId);
    }
}

