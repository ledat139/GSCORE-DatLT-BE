package com.DatLTGOS.DatLTGOSTest.DTO;

public class ScoreReport {
  private String subject;
  private int greaterThan8Count;
  private int between6And8Count;
  private int between4And6Count;
  private int lessThan4Count;

  public String getSubject() {
    return subject;
  }
  public void setSubject(String subject) {
    this.subject = subject;
  }
  public int getGreaterThan8Count() {
    return greaterThan8Count;
  }
  public void setGreaterThan8Count(int greaterThan8Count) {
    this.greaterThan8Count = greaterThan8Count;
  }
  public int getBetween6And8Count() {
    return between6And8Count;
  }
  public void setBetween6And8Count(int between6And8Count) {
    this.between6And8Count = between6And8Count;
  }
  public int getBetween4And6Count() {
    return between4And6Count;
  }
  public void setBetween4And6Count(int between4And6Count) {
    this.between4And6Count = between4And6Count;
  }
  public int getLessThan4Count() {
    return lessThan4Count;
  }
  public void setLessThan4Count(int lessThan4Count) {
    this.lessThan4Count = lessThan4Count;
  }
  
}
