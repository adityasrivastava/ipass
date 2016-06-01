package com.mds.passbook.mapper;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.mds.passbook.bean.Golf;
import com.mds.passbook.bean.GolfHoles;
import com.mds.passbook.repo.dao.GolfDao;
import com.mds.passbook.repo.dao.GolfHolesDao;

public class GolfMapper {

	private static Mapper mapper = new DozerBeanMapper();

	public static Golf DAOtoDTO(GolfDao golfDao) {

		return mapper.map(golfDao, Golf.class);

	}

	public static GolfDao DTOtoDAO(Golf golf) {

		return mapper.map(golf, GolfDao.class);
	}

}
