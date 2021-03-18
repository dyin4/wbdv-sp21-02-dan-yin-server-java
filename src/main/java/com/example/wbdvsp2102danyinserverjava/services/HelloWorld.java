package com.example.wbdvsp2102danyinserverjava.services;

import java.util.Date;

public class HelloWorld {
  public Integer id;
  public String name;
  public Date today = new Date();


  public HelloWorld(Integer id, String name, Date today) {
    this.id = id;
    this.name = name;
    this.today = today;
  }

  public HelloWorld() {
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }


  public Date getToday() {
    return today;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setToday(Date today) {
    this.today = today;
  }
}
