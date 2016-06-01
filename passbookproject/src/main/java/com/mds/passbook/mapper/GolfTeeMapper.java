package com.mds.passbook.mapper;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.mds.passbook.bean.GolfCourse;
import com.mds.passbook.bean.GolfTee;
import com.mds.passbook.repo.dao.GolfCourseDao;
import com.mds.passbook.repo.dao.GolfTeeDao;

public class GolfTeeMapper {

	private static Mapper mapper = new DozerBeanMapper();

	public static GolfTee DAOtoDTO(GolfTeeDao teeDao) {

		return mapper.map(teeDao, GolfTee.class);

	}

	public static GolfTeeDao DTOtoDAO(GolfTee tee) {

		return mapper.map(tee, GolfTeeDao.class);
	}

}
