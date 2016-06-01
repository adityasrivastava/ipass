package com.mds.passbook.mapper;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.mds.passbook.bean.GolfCourse;
import com.mds.passbook.bean.GolfHoles;
import com.mds.passbook.repo.dao.GolfCourseDao;
import com.mds.passbook.repo.dao.GolfHolesDao;

public class GolfHolesMapper {

	private static Mapper mapper = new DozerBeanMapper();

	public static GolfHoles DAOtoDTO(GolfHolesDao holesDao) {

		return mapper.map(holesDao, GolfHoles.class);

	}

	public static GolfHolesDao DTOtoDAO(GolfHoles holes) {

		return mapper.map(holes, GolfHolesDao.class);
	}

}
