package com.DatLTGOS.DatLTGOSTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import com.DatLTGOS.DatLTGOSTest.entity.StudentScore;
import com.DatLTGOS.DatLTGOSTest.repository.StudentScoreRepository;

@SpringBootApplication
@EnableCaching
public class DatLtgosTestApplication {

	@Autowired
	private StudentScoreRepository studentScoreRepository;
	public static void main(String[] args) {
		SpringApplication.run(DatLtgosTestApplication.class, args);
	}

	@Bean
	CommandLineRunner seedDatabase() {
		return args -> {
			if (studentScoreRepository.count() > 0) {
				System.out.println("Student scores already seeded");
				return;
			}
			String path = "src/main/resources/static/diem_thi_thpt_2024.csv";
			BufferedReader reader = new BufferedReader(new FileReader(path));

			String line;
			List<StudentScore> batch = new ArrayList<>();
			int batchSize = 50000;

			reader.readLine(); 

			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");

				StudentScore s = new StudentScore();
				s.setSbd(parts[0]);
				s.setToan(parts.length > 1 ? safeParseDouble(parts[1]) : null);
				s.setNguVan(parts.length > 2 ? safeParseDouble(parts[2]) : null);
				s.setNgoaiNgu(parts.length > 3 ? safeParseDouble(parts[3]) : null);
				s.setVatLi(parts.length > 4 ? safeParseDouble(parts[4]) : null);
				s.setHoaHoc(parts.length > 5 ? safeParseDouble(parts[5]) : null);
				s.setSinhHoc(parts.length > 6 ? safeParseDouble(parts[6]) : null);
				s.setLichSu(parts.length > 7 ? safeParseDouble(parts[7]) : null);
				s.setDiaLi(parts.length > 8 ? safeParseDouble(parts[8]) : null);
				s.setGdcd(parts.length > 9 ? safeParseDouble(parts[9]) : null);
				s.setMaNgoaiNgu(parts.length > 10 ? parts[10].trim() : null);

				batch.add(s);

				if (batch.size() >= batchSize) {
					studentScoreRepository.saveAll(batch);
					batch.clear();
				}
			}

			if (!batch.isEmpty()) {
				studentScoreRepository.saveAll(batch);
			}

			reader.close();
		};
	}

	private Double safeParseDouble(String str) {
		try {
			if (str == null || str.isBlank()) return null;
			return Double.parseDouble(str.trim());
		} catch (Exception e) {
			return null;
		}
	}

}
