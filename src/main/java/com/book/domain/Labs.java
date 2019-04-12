package com.book.domain;

import java.io.Serializable;

public class Labs implements Serializable {

  private int id;
  private String name;
  private int departmentID;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getDepartmentID() {
    return departmentID;
  }

  public void setDepartmentID(int departmentID) {
    this.departmentID = departmentID;
  }


}