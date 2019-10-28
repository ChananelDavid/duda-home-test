package com.duda.home.test.model;

import com.duda.home.test.util.GradeConverter;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import java.util.Objects;

/**
 * Pupil
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-27T23:26:20.212Z")
@Entity
public class Pupil {

    @Id
    @GeneratedValue
    private Long id;

    @JsonProperty("Lat")
    private Double lat = null;

    @JsonProperty("Lon")
    private Double lon = null;

    @JsonProperty("Grades")
    @Convert(converter = GradeConverter.class)
    private Grade grades = null;

    public Long getId() {
        return id;
    }

    public Pupil lat(Double lat) {
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

    public Pupil lon(Double lon) {
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

    public Pupil grades(Grade grades) {
        this.grades = grades;
        return this;
    }

    /**
     * Get grades
     *
     * @return grades
     **/
    @ApiModelProperty(value = "")

    @Valid

    public Grade getGrades() {
        return grades;
    }

    public void setGrades(Grade grades) {
        this.grades = grades;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pupil pupil = (Pupil) o;
        return Objects.equals(this.lat, pupil.lat) &&
                Objects.equals(this.lon, pupil.lon) &&
                Objects.equals(this.grades, pupil.grades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lat, lon, grades);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Pupil {\n");

        sb.append("    lat: ").append(toIndentedString(lat)).append("\n");
        sb.append("    lon: ").append(toIndentedString(lon)).append("\n");
        sb.append("    grades: ").append(toIndentedString(grades)).append("\n");
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
}

