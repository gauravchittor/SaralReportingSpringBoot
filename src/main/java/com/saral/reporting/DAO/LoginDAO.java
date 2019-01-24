package com.saral.reporting.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service 
@Repository
public class LoginDAO {
	

	@PersistenceContext
	private EntityManager manager;
	@Transactional
	public List<Object[]> validateUser(String sign_no, String password) {
		// TODO Auto-generated method stub'
System.out.println("sign _no"+sign_no);
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
System.out.println("sign _no"+sign_no);
		String queryStr = "SELECT loginData.signNo,loginData.userId,loginData.userName,"
				+ " roleAssignment.roleId, roleMaster.roleName, userLocation.departmentLevelName,"
				+ " userLocation.departmentId, userLocationDesignation.designationId, "
				+ " userLocationDesignation.designationName, roleMaster.signRole, loginData.passwd FROM  RoleAssignment roleAssignment ,LoginData loginData,"
				+ " RoleMaster roleMaster, UserLocation userLocation,UserLocationDesignation userLocationDesignation"
				+ " WHERE (loginData.userId = roleAssignment.userId) AND (roleAssignment.roleId =  roleMaster.roleId)"
				+ " AND (loginData.userId = userLocation.userId) AND (userLocation.userLocId = userLocationDesignation.userLocId)"
				+ " AND loginData.signNo ='" + sign_no + "'";

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
	
	
	
	public void testSelectJsonbEntity() {
		/*log.info("... testSelectJsonbEntity ...");*/
		//emf = Persistence.createEntityManagerFactory("my-persistence-unit");
		/*EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		e WHERE e.id='280' AND e.applInfo/-/>'version_no' = '4' */

		//List<ApplInfoJson> results =  (List<ApplInfoJson> ) manager.createNativeQuery("SELECT * FROM saral1.tbl_app_json WHERE appl_info->>'version_no' = '4'", ApplInfoJson.class).getResultList();

		/*Assert.assertNotNull(e.getJsonProperty());
		System.out.println("JSON: stringProp = "+e.getJsonProperty().getStringProp()+"    longProp = "+e.getJsonProperty().getLongProp());
		*/
		//System.out.println("this is my appl info json result" + results);
	
		}



}
