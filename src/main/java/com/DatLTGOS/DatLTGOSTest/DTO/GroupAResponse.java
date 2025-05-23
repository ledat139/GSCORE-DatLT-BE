package com.DatLTGOS.DatLTGOSTest.DTO;

public class GroupAResponse {
  private String sbd;
  private Double toan;
  private Double vatLi;
  private Double hoaHoc;
  private Double totalScore;

  public GroupAResponse(String sbd, Double toan, Double vatLi, Double hoaHoc, Double totalScore) {
    this.sbd = sbd;
    this.toan = toan;
    this.vatLi = vatLi;
    this.hoaHoc = hoaHoc;
    this.totalScore = totalScore;
  }

  public String getSbd() {
    return sbd;
  }

  public void setSbd(String sbd) {
    this.sbd = sbd;
  }

  public Double getToan() {
    return toan;
  }

  public void setToan(Double toan) {
    this.toan = toan;
  }

  public Double getVatLi() {
    return vatLi;
  }

  public void setVatLi(Double vatLi) {
    this.vatLi = vatLi;
  }

  public Double getHoaHoc() {
    return hoaHoc;
  }

  public void setHoaHoc(Double hoaHoc) {
    this.hoaHoc = hoaHoc;
  }

  public Double getTotalScore() {
    return totalScore;
  }

  public void setTotalScore(Double totalScore) {
    this.totalScore = totalScore;
  }

}
