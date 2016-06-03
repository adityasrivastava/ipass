package com.mds.passbook.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface PassbookService {
	
	InputStream createPassbook(String name, String age, String gender, String golf_course, String hole_type, String tee_type, String handicap);
	long getFileSize();
	void generatePass(String absolutePath, List<com.mds.passkit.GolfScore> scores);
	InputStream readPassFile(String relativePath);

}
