package com.saral.reporting.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.saral.reporting.model.HrOrgUnits;

@Service
@Repository
public class LoginDAO {

	@PersistenceContext
	private EntityManager manager;

	@Transactional
	public List<Object[]> validateUser(String sign_no, String password) {
		// TODO Auto-generated method stub'
		System.out.println("sign _no" + sign_no);
		String queryStr = "SELECT loginData.signNo,loginData.userId,loginData.userName,"
				+ " roleAssignment.roleId, roleMaster.roleName, userLocation.departmentLevelName,"
				+ " userLocation.departmentId, userLocationDesignation.designationId, "
				+ " userLocationDesignation.designationName, roleMaster.signRole,loginData.passwd FROM  RoleAssignment roleAssignment ,LoginData loginData,"
				+ " RoleMaster roleMaster, UserLocation userLocation,UserLocationDesignation userLocationDesignation"
				+ " WHERE (loginData.userId = roleAssignment.userId) AND (roleAssignment.roleId =  roleMaster.roleId)"
				+ " AND (loginData.userId = userLocation.userId) AND (userLocation.userLocId = userLocationDesignation.userLocId)"
				+ " AND loginData.signNo ='" + sign_no + "'  AND loginData.passwd= '" + password + "' ";

		try {

			@SuppressWarnings("unchecked")
			List<Object[]> results = manager.createQuery(queryStr).getResultList();
			manager.close();
			manager.clear();
			return results;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public List<Object[]> getUserInfo(String sign_no) {
		// TODO Auto-generated method stub'
		System.out.println("sign _no" + sign_no);
		String queryStr = "SELECT loginData.signNo,loginData.userId,loginData.userName,"
				+ " roleAssignment.roleId, roleMaster.roleName, userLocation.departmentLevelName,"
				+ " userLocation.departmentId, userLocationDesignation.designationId, "
				+ " userLocationDesignation.designationName, roleMaster.signRole, loginData.passwd, loginData.locationId FROM  RoleAssignment roleAssignment ,LoginData loginData,"
				+ " RoleMaster roleMaster, UserLocation userLocation,UserLocationDesignation userLocationDesignation,HrOrgUnits hrOrgUnits "
				+ " WHERE (loginData.userId = roleAssignment.userId) AND (roleAssignment.roleId =  roleMaster.roleId)"
				+ " AND (loginData.userId = userLocation.userId) AND (userLocation.userLocId = userLocationDesignation.userLocId)"
				+ " AND (loginData.locationId = hrOrgUnits.orgUnitCode)"
				+ " AND loginData.signNo ='" + sign_no + "'" ;

		try {

			@SuppressWarnings("unchecked")
			List<Object[]> results = manager.createQuery(queryStr).getResultList();
			manager.close();
			manager.clear();
			return results;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@SuppressWarnings("unchecked")
	public List<HrOrgUnits> testSelectJsonbEntity(Long location_Id) {

		String Query = "SELECT org_unit_code, org_located_level_code, org_unit_name, "
				+ "entity_lc, entity_type, address1, address2, address3, localaddress1, "
				+ "localaddress2, localaddress3, phoneno, email, isactive, parent_org_unit_code, "
				+ "org_spec_code, pin_code, level, code, headoffice, org_unit_version, "
				+ "org_located_level_version FROM lgd.hr_org_units where org_unit_code='"+ location_Id + "'"
				+ "union all "
				+ "SELECT org_unit_code, org_located_level_code, org_unit_name, entity_lc, "
				+ "entity_type, address1, address2, address3, localaddress1, localaddress2, "
				+ "localaddress3, phoneno, email, isactive, parent_org_unit_code, org_spec_code, "
				+ "pin_code, level, code, headoffice, org_unit_version, org_located_level_version "
				+ "FROM lgd.hr_org_units where parent_org_unit_code='"+ location_Id + "'";

		List<HrOrgUnits> results = (List<HrOrgUnits>) manager.createNativeQuery(Query, HrOrgUnits.class)
				.getResultList();
		System.out.println(results);
		return results;
	}

}
