package com.mds.passbook.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.mds.passbook.bean.Golf;
import com.mds.passbook.bean.GolfCourse;
import com.mds.passbook.bean.GolfHoles;
import com.mds.passbook.bean.GolfPass;
import com.mds.passbook.bean.GolfScore;
import com.mds.passbook.bean.GolfTee;
import com.mds.passbook.bean.GolfTeeDetails;
import com.mds.passbook.bean.GolfUser;
import com.mds.passbook.bean.PassRegistrations;
import com.mds.passbook.repo.dao.GolfCourseDao;
import com.mds.passbook.repo.dao.GolfDao;
import com.mds.passbook.repo.dao.GolfHolesDao;
import com.mds.passbook.repo.dao.GolfPassDao;
import com.mds.passbook.repo.dao.GolfScoreDao;
import com.mds.passbook.repo.dao.GolfTeeDao;
import com.mds.passbook.repo.dao.GolfTeeDetailsDao;
import com.mds.passbook.repo.dao.GolfUserDao;
import com.mds.passbook.repo.dao.PassRegistrationsDao;

@Mapper
public interface GolfMapperInterface {
	
	GolfMapperInterface INSTANCE = Mappers.getMapper(GolfMapperInterface.class);
	
	@Mappings({
		@Mapping(source="golfCourseId", target="golfCourseId"),
		@Mapping(source="courseName", target="courseName"),
	})
	GolfCourse daoToDto(GolfCourseDao courseDao);
	
	@Mappings({
		@Mapping(source="golfCourseId", target="golfCourseId"),
		@Mapping(source="courseName", target="courseName"),
	})
	GolfCourseDao dtoToDao(GolfCourse course);
	
	@Mappings({
	@Mapping(source="golfCoursesId", target="golfCoursesId"),
	@Mapping(source="scoresId", target = "scoresId"),
	@Mapping(source="teeTypesId", target="teeTypesId"),
	@Mapping(source="holeTypesId", target="holeTypesId"),
	@Mapping(source="usersId", target="usersId")
	})
	Golf daoToDto(GolfDao golf);

	@Mappings({
		@Mapping(source="golfCoursesId", target="golfCoursesId"),
		@Mapping(source="scoresId", target = "scoresId"),
		@Mapping(source="teeTypesId", target="teeTypesId"),
		@Mapping(source="holeTypesId", target="holeTypesId"),
		@Mapping(source="usersId", target="usersId")
	})
	GolfDao daoToDto(Golf golf);
	
	@Mappings({
		@Mapping(source="scoreId", target="scoreId"),
		@Mapping(source="score", target="score"),
		@Mapping(source="holeNumber", target="holeNumber"),
		@Mapping(source="golfTeeDetailsId", target="golfTeeDetailsId", ignore=true),
		@Mapping(source="golf", target="golf", ignore=true)
	})
	GolfScore daoToDto(GolfScoreDao score);
	
	@Mappings({
		@Mapping(source="scoreId", target="scoreId"),
		@Mapping(source="score", target="score"),
		@Mapping(source="holeNumber", target="holeNumber"),
		@Mapping(source="golfTeeDetailsId", target="golfTeeDetailsId", ignore=true),
		@Mapping(source="golf", target="golf", ignore=true)
	})
	GolfScoreDao dtoToDao(GolfScore score);
	
	@Mappings({
		@Mapping(source="userId", target="userId"),
		@Mapping(source="name", target="name"),
		@Mapping(source="age", target="age"),
		@Mapping(source="gender", target="gender"),
		@Mapping(source="handicap", target="handicap"),
		@Mapping(source="pass", target="pass"),
		@Mapping(source="golf", target="golf", ignore=true)
	})
	GolfUser daoToDto(GolfUserDao user);
	
	@Mappings({
		@Mapping(source="userId", target="userId"),
		@Mapping(source="name", target="name"),
		@Mapping(source="age", target="age"),
		@Mapping(source="gender", target="gender"),
		@Mapping(source="handicap", target="handicap"),
		@Mapping(source="pass", target="pass"),
		@Mapping(source="golf", target="golf")
	})
	GolfUserDao dtoToDao(GolfUser user);
	
	@Mappings({
		@Mapping(source="passId", target="passId"),
		@Mapping(source="token", target="token"),
		@Mapping(source="deviceId", target="deviceId"),
		@Mapping(source="passAdded", target="passAdded"),
		@Mapping(source="registeredPass", target="registeredPass")
	})
	GolfPass daoToDto(GolfPassDao pass);
	
	@Mappings({
		@Mapping(source="passId", target="passId"),
		@Mapping(source="token", target="token"),
		@Mapping(source="deviceId", target="deviceId"),
		@Mapping(source="passAdded", target="passAdded"),
		@Mapping(source="registeredPass", target="registeredPass")
	})
	GolfPassDao dtoToDao(GolfPass pass);
	
	@Mappings({
		@Mapping(source="registerPassId", target="registerPassId"),
		@Mapping(source="passTypeId", target="passTypeId"),
		@Mapping(source="serialNumber", target="serialNumber"),
		@Mapping(source="pass", target="pass", ignore=true)
	})
	PassRegistrations daoToDto(PassRegistrationsDao passRegistrations);
	
	@Mappings({
		@Mapping(source="registerPassId", target="registerPassId"),
		@Mapping(source="passTypeId", target="passTypeId"),
		@Mapping(source="serialNumber", target="serialNumber"),
		@Mapping(source="pass", target="pass")
	})
	PassRegistrationsDao dtoToDao(PassRegistrations passRegistrations);
	
	@Mappings({
		@Mapping(source="holeTypeId", target="holeTypeId"),
		@Mapping(source="holes", target="holes"),
		@Mapping(source="golf", target="golf", ignore=true)
	})
	GolfHoles daoToDto(GolfHolesDao holes);
	
	@Mappings({
		@Mapping(source="holeTypeId", target="holeTypeId"),
		@Mapping(source="holes", target="holes"),
		@Mapping(source="golf", target="golf")
	})
	GolfHolesDao dtoToDao(GolfHoles holes);
	
	@Mappings({
		@Mapping(source="teeId", target="teeId"),
		@Mapping(source="color", target="color"),
		@Mapping(source="teeDetails", target="teeDetails")
	})
	GolfTee daoToDto(GolfTeeDao tee);
	

	@Mappings({
		@Mapping(source="teeId", target="teeId"),
		@Mapping(source="color", target="color"),
		@Mapping(source="teeDetails", target="teeDetails")
	})
	GolfTeeDao dtoToDao(GolfTee tee);
	
	
	@Mappings({
		@Mapping(source="teeTypeId", target="teeTypeId"),
		@Mapping(source="holeNumber", target="holeNumber"),
		@Mapping(source="yards", target="yards"),
		@Mapping(source="par", target="par"),
		@Mapping(source="stroke", target="stroke"),
		@Mapping(source="golfTee", target="golfTee", ignore=true)
	})
	GolfTeeDetails daoToDto(GolfTeeDetailsDao teeDetails);
	
	
	@Mappings({
		@Mapping(source="teeTypeId", target="teeTypeId"),
		@Mapping(source="holeNumber", target="holeNumber"),
		@Mapping(source="yards", target="yards"),
		@Mapping(source="par", target="par"),
		@Mapping(source="stroke", target="stroke"),
		@Mapping(source="golfTee", target="golfTee")
	})
	GolfTeeDetailsDao dtoToDao(GolfTeeDetails teeDetails);

}
