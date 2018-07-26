package com.dashboard.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dashboard.beans.ProfileBean;
import com.dashboard.beans.SkillBean;
import com.dashboard.beans.StudentSkillBean;

@Repository("daoClass")
public class DaoClass {
	
	@Autowired
	SessionFactory sessionFactory;
	public void addSkill(SkillBean skillBean) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.save(skillBean);
		
		
	}

	public ArrayList<SkillBean> displaySkill(){
		
		String hql="from SkillBean";
		Session session = sessionFactory.getCurrentSession();
		Query q = session
				.createQuery(hql);
		
		ArrayList<SkillBean> ssb=(ArrayList<SkillBean>) q.list();
		
		return ssb;
	}

	/**
	 * @param skills
	 */
	public TreeMap<String, Integer> getStudentList(String skills) {
		
		System.out.println("Inside Skills of Dao"+skills);
		Session session = sessionFactory.getCurrentSession();
		 
		
		TreeMap<String,ArrayList<String>> skillStudentName = new TreeMap<String, ArrayList<String>>() ;
		
		String aiseHe[]=skills.split(",");
		
		for(String s: aiseHe){
			ArrayList<String> arr = new ArrayList<String>();
			ArrayList<String> arrayOfStudId = new ArrayList<String>();
			try {
				
				String sql = "select name from test.db_profile where pId in (select studentId from test.db_studskill where skillId = (select skillId from test.db_skill where skillName=?))";
				String sql1 ="select studentId from test.db_studskill where skillId = (select skillId from test.db_skill where skillName=?)";
				
				Query q = session.createSQLQuery(sql);
				q.setString(0, s);
			//	q.addEntity(ProfileBean.class);
				
				arr=(ArrayList<String>) q.list();
				
				Query q1=session.createSQLQuery(sql1);
				q1.setString(0, s);
				//q1.addEntity(StudentSkillBean.class);
				arrayOfStudId=(ArrayList<String>) q1.list();
				
				System.out.println("The array List ofstudents"+arr);
				System.out.println("The skill set for which "+s);
				System.out.println("Array of student Id:"+arrayOfStudId);
				skillStudentName.put(s, arr);
				
				ArrayList<String> testList=skillStudentName.get(s);
				ArrayList<String> studList=new ArrayList<String>();
				
				//////////////////Loop for finding common students
				Set keySkillStudentName=skillStudentName.keySet();
				
				
			
				


			
				
				
			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
				System.out.println(skillStudentName);
			}
			
			
		}
		
			//////////////////Loop for finding common students
		
		ArrayList<String> testList=skillStudentName.get(aiseHe[0]);
		System.out.println(testList);
		ArrayList<String> studList=new ArrayList<String>();
		
		for(int i=0;i<testList.size();i++)
		{
			
			if(skillStudentName.get(aiseHe[1]).contains(testList.get(i))&&skillStudentName.get(aiseHe[2]).contains(testList.get(i)))
				studList.add(testList.get(i));
			
		}
		
		System.out.println("Final List is"+studList);
		
		////////Calculating Marks.
		TreeMap<String, Integer> studMarksMap=new TreeMap<String, Integer>();
		for(int i=0;i<studList.size();i++){
			
			String sql="Select skillPoints from test.db_profile where name=?";
			Query sql1=session.createSQLQuery(sql);
			sql1.setString(0, studList.get(i));
			studMarksMap.put(studList.get(i), (Integer) sql1.list().get(0));
			
		}
		
		ArrayList<ProfileBean> pBeanList=new ArrayList<ProfileBean>();
		for(int i=0;i<studList.size();i++){
		String bigHql="from ProfileBean where name=?";
		Query hql=session.createQuery(bigHql);
		hql.setString(0, studList.get(i));
		ProfileBean profileBean=(ProfileBean) hql.list().get(0);
		System.out.println("The profile bean object name is"+profileBean.getEmailId());
		pBeanList.add(profileBean);
		}
		
		
		System.out.println(studMarksMap);
		System.out.println("Outside DAO");
		 return studMarksMap;
	}

	public ArrayList<String> getPidList(String[] arr) {
		
		ArrayList<String> al=new ArrayList<String>();
		System.out.println("In Dao for Interview Process");
		for(int i=0;i<arr.length;i++){
			
			String sql="select pId from test.db_profile where name=?";
			Session session = sessionFactory.getCurrentSession();
			Query q=session.createSQLQuery(sql);
			q.setString(0, arr[i]);
			al.add(i, (String) q.list().get(0));
			
			
		
			
			/*List<Map.Entry<String, Integer>> list = 
					new LinkedList<Map.Entry<String, Integer>>;*/
		
			
		}
		
		System.out.println(al);
		return al;

	}
	
	
}
