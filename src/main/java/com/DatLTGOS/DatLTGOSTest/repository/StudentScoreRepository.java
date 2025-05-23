package com.DatLTGOS.DatLTGOSTest.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.DatLTGOS.DatLTGOSTest.DTO.GroupAResponse;
import com.DatLTGOS.DatLTGOSTest.entity.StudentScore;

@Repository

public interface StudentScoreRepository extends JpaRepository<StudentScore, String> {

  // Toan
  @Query("select count(s) from StudentScore s where s.toan >= 8.0")
  int countToanGreaterThanEqual8();

  @Query("SELECT COUNT(s) FROM StudentScore s WHERE s.toan >= 6.0 AND s.toan < 8.0")
  int countToanBetween6And8();

  @Query("SELECT COUNT(s) FROM StudentScore s WHERE s.toan >= 4.0 AND s.toan < 6.0")
  int countToanBetween4And6();

  @Query("SELECT COUNT(s) FROM StudentScore s WHERE s.toan < 4.0")
  int countToanLessThan4();

  // Van
  @Query("select count(s) from StudentScore s where s.nguVan >= 8.0")
  int countVanGreaterThanEqual8();

  @Query("SELECT COUNT(s) FROM StudentScore s WHERE s.nguVan >= 6.0 AND s.nguVan < 8.0")
  int countVanBetween6And8();

  @Query("SELECT COUNT(s) FROM StudentScore s WHERE s.nguVan >= 4.0 AND s.nguVan < 6.0")
  int countVanBetween4And6();

  @Query("SELECT COUNT(s) FROM StudentScore s WHERE s.nguVan < 4.0")
  int countVanLessThan4();

  // Ngoai ngu
  @Query("select count(s) from StudentScore s where s.ngoaiNgu >= 8.0")
  int countNgoaiNguGreaterThanEqual8();

  @Query("SELECT COUNT(s) FROM StudentScore s WHERE s.ngoaiNgu >= 6.0 AND s.ngoaiNgu < 8.0")
  int countNgoaiNguBetween6And8();

  @Query("SELECT COUNT(s) FROM StudentScore s WHERE s.ngoaiNgu >= 4.0 AND s.ngoaiNgu < 6.0")
  int countNgoaiNguBetween4And6();

  @Query("SELECT COUNT(s) FROM StudentScore s WHERE s.ngoaiNgu < 4.0")
  int countNgoaiNguLessThan4();

  // Vat li
  @Query("select count(s) from StudentScore s where s.vatLi >= 8.0")
  int countVatLiGreaterThanEqual8();

  @Query("SELECT COUNT(s) FROM StudentScore s WHERE s.vatLi >= 6.0 AND s.vatLi < 8.0")
  int countVatLiBetween6And8();

  @Query("SELECT COUNT(s) FROM StudentScore s WHERE s.vatLi >= 4.0 AND s.vatLi < 6.0")
  int countVatLiBetween4And6();

  @Query("SELECT COUNT(s) FROM StudentScore s WHERE s.vatLi < 4.0")
  int countVatLiLessThan4();

  // Hoa hoc
  @Query("select count(s) from StudentScore s where s.hoaHoc >= 8.0")
  int countHoaHocGreaterThanEqual8();

  @Query("SELECT COUNT(s) FROM StudentScore s WHERE s.hoaHoc >= 6.0 AND s.hoaHoc < 8.0")
  int countHoaHocBetween6And8();

  @Query("SELECT COUNT(s) FROM StudentScore s WHERE s.hoaHoc >= 4.0 AND s.hoaHoc < 6.0")
  int countHoaHocBetween4And6();

  @Query("SELECT COUNT(s) FROM StudentScore s WHERE s.hoaHoc < 4.0")
  int countHoaHocLessThan4();

  // Sinh hoc
  @Query("select count(s) from StudentScore s where s.sinhHoc >= 8.0")
  int countSinhHocGreaterThanEqual8();

  @Query("SELECT COUNT(s) FROM StudentScore s WHERE s.sinhHoc >= 6.0 AND s.sinhHoc < 8.0")
  int countSinhHocBetween6And8();

  @Query("SELECT COUNT(s) FROM StudentScore s WHERE s.sinhHoc >= 4.0 AND s.sinhHoc < 6.0")
  int countSinhHocBetween4And6();

  @Query("SELECT COUNT(s) FROM StudentScore s WHERE s.sinhHoc < 4.0")
  int countSinhHocLessThan4();

  // Lich su
  @Query("select count(s) from StudentScore s where s.lichSu >= 8.0")
  int countLichSuGreaterThanEqual8();

  @Query("SELECT COUNT(s) FROM StudentScore s WHERE s.lichSu >= 6.0 AND s.lichSu < 8.0")
  int countLichSuBetween6And8();

  @Query("SELECT COUNT(s) FROM StudentScore s WHERE s.lichSu >= 4.0 AND s.lichSu < 6.0")
  int countLichSuBetween4And6();

  @Query("SELECT COUNT(s) FROM StudentScore s WHERE s.lichSu < 4.0")
  int countLichSuLessThan4();

  // Dia li
  @Query("select count(s) from StudentScore s where s.diaLi >= 8.0")
  int countDiaLiGreaterThanEqual8();

  @Query("SELECT COUNT(s) FROM StudentScore s WHERE s.diaLi >= 6.0 AND s.diaLi < 8.0")
  int countDiaLiBetween6And8();

  @Query("SELECT COUNT(s) FROM StudentScore s WHERE s.diaLi >= 4.0 AND s.diaLi < 6.0")
  int countDiaLiBetween4And6();

  @Query("SELECT COUNT(s) FROM StudentScore s WHERE s.diaLi < 4.0")
  int countDiaLiLessThan4();

  // GDCD
  @Query("select count(s) from StudentScore s where s.gdcd >= 8.0")
  int countGDCDGreaterThanEqual8();

  @Query("SELECT COUNT(s) FROM StudentScore s WHERE s.gdcd >= 6.0 AND s.gdcd < 8.0")
  int countGDCDBetween6And8();

  @Query("SELECT COUNT(s) FROM StudentScore s WHERE s.gdcd >= 4.0 AND s.gdcd < 6.0")
  int countGDCDBetween4And6();

  @Query("SELECT COUNT(s) FROM StudentScore s WHERE s.gdcd < 4.0")
  int countGDCDLessThan4();

  // Top 10 students of group A
  @Cacheable(value = "topStudentsCache", key = "'top10GroupA'")
  @Query(value = """
      SELECT s.sbd, s.toan, s.vat_li, s.hoa_hoc, (s.toan + s.vat_li + s.hoa_hoc) AS total_score
      FROM student_score s
      JOIN (
          SELECT DISTINCT (toan + vat_li + hoa_hoc) AS score
          FROM student_score
          ORDER BY score DESC
          LIMIT 10
      ) AS top_scores ON (s.toan + s.vat_li + s.hoa_hoc) = top_scores.score
      ORDER BY total_score DESC""", nativeQuery = true)
  List<GroupAResponse> findTop10ByTotalScore();

}
