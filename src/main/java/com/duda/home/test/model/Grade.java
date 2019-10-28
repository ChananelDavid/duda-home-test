package com.duda.home.test.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Grade
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-27T23:26:20.212Z")

public class Grade   {
  @JsonProperty("couseName")
  private String couseName = null;

  @JsonProperty("grade")
  private Integer grade = null;

  public Grade couseName(String couseName) {
    this.couseName = couseName;
    return this;
  }

  /**
   * Get couseName
   * @return couseName
  **/
  @ApiModelProperty(value = "")


  public String getCouseName() {
    return couseName;
  }

  public void setCouseName(String couseName) {
    this.couseName = couseName;
  }

  public Grade grade(Integer grade) {
    this.grade = grade;
    return this;
  }

  /**
   * Get grade
   * @return grade
  **/
  @ApiModelProperty(value = "")


  public Integer getGrade() {
    return grade;
  }

  public void setGrade(Integer grade) {
    this.grade = grade;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Grade grade = (Grade) o;
    return Objects.equals(this.couseName, grade.couseName) &&
        Objects.equals(this.grade, grade.grade);
  }

  @Override
  public int hashCode() {
    return Objects.hash(couseName, grade);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Grade {\n");
    
    sb.append("    couseName: ").append(toIndentedString(couseName)).append("\n");
    sb.append("    grade: ").append(toIndentedString(grade)).append("\n");
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

