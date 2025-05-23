package com.DatLTGOS.DatLTGOSTest.controller;

import org.springframework.web.bind.annotation.RestController;

import com.DatLTGOS.DatLTGOSTest.DTO.APIResponse;
import com.DatLTGOS.DatLTGOSTest.DTO.GroupAResponse;
import com.DatLTGOS.DatLTGOSTest.entity.StudentScore;
import com.DatLTGOS.DatLTGOSTest.exception.AppException;
import com.DatLTGOS.DatLTGOSTest.exception.ErrorCode;
import com.DatLTGOS.DatLTGOSTest.service.StudentScoreService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class StudentScoreController {

  @Autowired
  private StudentScoreService studentScoreService;

  @GetMapping("/student-score/{sbd}")
  public APIResponse<StudentScore> postMethodName(
      @PathVariable String sbd) {
    if (sbd.length() < 8)
      throw new AppException(ErrorCode.INVALID_SBD);
    APIResponse<StudentScore> apiResponse = new APIResponse<>();
    apiResponse.setMessage("Thành công");
    apiResponse.setData(studentScoreService.FindScoreBySbd(sbd));
    return apiResponse;
  }

  @GetMapping("/student-score/report")
  public APIResponse<Map<String, Map<String, Integer>>> report() {
    APIResponse<Map<String, Map<String, Integer>>> apiResponse = new APIResponse<>();
    apiResponse.setMessage("Thành công.");
    apiResponse.setData(studentScoreService.ScoreReport());
    return apiResponse;
  }

  @GetMapping("/student-score/top10groupA")
  public APIResponse<List<GroupAResponse>> findTop10GroupA() {
    APIResponse<List<GroupAResponse>> apiResponse = new APIResponse<>();
    apiResponse.setMessage("Thành công.");
    apiResponse.setData(studentScoreService.findTop10GroupA());
    return apiResponse;
  }

}
