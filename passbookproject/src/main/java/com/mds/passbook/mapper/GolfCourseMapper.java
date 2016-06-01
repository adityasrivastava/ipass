package com.mds.passbook.mapper;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.mds.passbook.bean.GolfCourse;
import com.mds.passbook.repo.dao.GolfCourseDao;

public class GolfCourseMapper {

	private static Mapper mapper = new DozerBeanMapper();

	public static GolfCourse DAOtoDTO(GolfCourseDao courseDao) {

		return mapper.map(courseDao, GolfCourse.class);

	}

	public static GolfCourseDao DTOtoDAO(GolfCourse course) {

		return mapper.map(course, GolfCourseDao.class);
	}

}
