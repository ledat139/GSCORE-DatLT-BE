package com.DatLTGOS.DatLTGOSTest.exception;

public enum ErrorCode {
  STUDENT_SCORE_NOT_FOUND("Không tìm thấy."),
  SERVER_ERROR("Lỗi hệ thống."),
  INVALID_SBD("SBD phải có đúng 8 ký tự."),
  GROUPA_SCORE_NOT_FOUND("Không tìm thấy.");

  private String message;

  private ErrorCode(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
