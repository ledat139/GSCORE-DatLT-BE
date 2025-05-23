package com.DatLTGOS.DatLTGOSTest.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class APIResponse<T> {
  private String message;
  private T data;
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }
  public T getData() {
    return data;
  }
  public void setData(T data) {
    this.data = data;
  }
  
}
