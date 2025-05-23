package com.DatLTGOS.DatLTGOSTest.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

import com.DatLTGOS.DatLTGOSTest.DTO.GroupAResponse;
import com.DatLTGOS.DatLTGOSTest.entity.StudentScore;
import com.DatLTGOS.DatLTGOSTest.exception.AppException;
import com.DatLTGOS.DatLTGOSTest.exception.ErrorCode;
import com.DatLTGOS.DatLTGOSTest.repository.StudentScoreRepository;

@Service
@EnableCaching
public class StudentScoreService {
        @Autowired
        private StudentScoreRepository studentScoreRepository;

        public StudentScore FindScoreBySbd(String sbd) {
                return this.studentScoreRepository.findById(sbd)
                                .orElseThrow(() -> new AppException(ErrorCode.STUDENT_SCORE_NOT_FOUND));
        }

        @Cacheable("scoreReports")
        public Map<String, Map<String, Integer>> ScoreReport() {
                Map<String, Map<String, Integer>> report = new LinkedHashMap<>();

                report.put("toan", Map.of(
                                ">=8", studentScoreRepository.countToanGreaterThanEqual8(),
                                "6-8", studentScoreRepository.countToanBetween6And8(),
                                "4-6", studentScoreRepository.countToanBetween4And6(),
                                "<4", studentScoreRepository.countToanLessThan4()));

                report.put("nguVan", Map.of(
                                ">=8", studentScoreRepository.countVanGreaterThanEqual8(),
                                "6-8", studentScoreRepository.countVanBetween6And8(),
                                "4-6", studentScoreRepository.countVanBetween4And6(),
                                "<4", studentScoreRepository.countVanLessThan4()));

                report.put("ngoaiNgu", Map.of(
                                ">=8", studentScoreRepository.countNgoaiNguGreaterThanEqual8(),
                                "6-8", studentScoreRepository.countNgoaiNguBetween6And8(),
                                "4-6", studentScoreRepository.countNgoaiNguBetween4And6(),
                                "<4", studentScoreRepository.countNgoaiNguLessThan4()));

                report.put("vatLi", Map.of(
                                ">=8", studentScoreRepository.countVatLiGreaterThanEqual8(),
                                "6-8", studentScoreRepository.countVatLiBetween6And8(),
                                "4-6", studentScoreRepository.countVatLiBetween4And6(),
                                "<4", studentScoreRepository.countVatLiLessThan4()));

                report.put("hoaHoc", Map.of(
                                ">=8", studentScoreRepository.countHoaHocGreaterThanEqual8(),
                                "6-8", studentScoreRepository.countHoaHocBetween6And8(),
                                "4-6", studentScoreRepository.countHoaHocBetween4And6(),
                                "<4", studentScoreRepository.countHoaHocLessThan4()));

                report.put("sinhHoc", Map.of(
                                ">=8", studentScoreRepository.countSinhHocGreaterThanEqual8(),
                                "6-8", studentScoreRepository.countSinhHocBetween6And8(),
                                "4-6", studentScoreRepository.countSinhHocBetween4And6(),
                                "<4", studentScoreRepository.countSinhHocLessThan4()));

                report.put("lichSu", Map.of(
                                ">=8", studentScoreRepository.countLichSuGreaterThanEqual8(),
                                "6-8", studentScoreRepository.countLichSuBetween6And8(),
                                "4-6", studentScoreRepository.countLichSuBetween4And6(),
                                "<4", studentScoreRepository.countLichSuLessThan4()));

                report.put("diaLi", Map.of(
                                ">=8", studentScoreRepository.countDiaLiGreaterThanEqual8(),
                                "6-8", studentScoreRepository.countDiaLiBetween6And8(),
                                "4-6", studentScoreRepository.countDiaLiBetween4And6(),
                                "<4", studentScoreRepository.countDiaLiLessThan4()));

                report.put("gdcd", Map.of(
                                ">=8", studentScoreRepository.countGDCDGreaterThanEqual8(),
                                "6-8", studentScoreRepository.countGDCDBetween6And8(),
                                "4-6", studentScoreRepository.countGDCDBetween4And6(),
                                "<4", studentScoreRepository.countGDCDLessThan4()));
                return report;
        }

        public List<GroupAResponse> findTop10GroupA() {
                List<GroupAResponse> responses = studentScoreRepository.findTop10ByTotalScore();
                if (responses == null)
                        throw new AppException(ErrorCode.GROUPA_SCORE_NOT_FOUND);
                return responses;
        }

}
