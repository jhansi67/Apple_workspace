package com.dashboard.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dashboard.beans.AskBean;
import com.dashboard.beans.AutoSeqComment;
import com.dashboard.beans.AutoSeqPost;
import com.dashboard.beans.CommentBean;
import com.dashboard.beans.PhotoBean;
import com.dashboard.beans.TrainerBean;

@Repository("trainerDAO")
public class TrainerDAOImpl implements TrainerDAO{

	@Autowired
	SessionFactory sessionFactory;


	
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public String addEvent(TrainerBean tb) {
	Session s=sessionFactory.getCurrentSession();
	String courseId=(String) s.save(tb);
	if(courseId==null){
		return "failure";
	}
	else{
	return "Success";
	}
	
	}

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public void addPhoto(PhotoBean pb)
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(pb);
	}
	
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
@Override
	public Map<AskBean, ArrayList<AskBean>> askForum() {
		Session s=sessionFactory.getCurrentSession();
		AskBean a = new AskBean();
		
		
		Map<AskBean, ArrayList<AskBean>> m = new HashMap<>();
		Query sql = s.createQuery("from AskBean where postId in (select DISTINCT postId from CommentBean)");
		ArrayList<AskBean> aList = (ArrayList<AskBean>) sql.list();
		System.out.println(aList.get(0).getPostId());
		for(int i=0;i<aList.size();i++){
		AskBean a123 = (AskBean) aList.get(i);
		//select * from test.SeqToPost order by idSeqToPost DESC limit 1 
		
		sql = s.createQuery("from AskBean where postId in (select commentId from CommentBean where postId ='"+a123.getPostId()+"' and commentId !="+ 0+")");
		ArrayList<AskBean> aList1233 = (ArrayList<AskBean>) sql.list();
		System.out.println(a123.getPostId());
		//System.out.println(aList1233.get(0).getPostId());
		m.put(a123, aList1233);
		System.out.println(aList1233);
	//	System.out.println(a123.getPostId()+"      "+aList1233.get(0).getPostId());
		
		}
		
		
		
		return m;
		
	}
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public AskBean addComment(AskBean askbean) {
		int k = askbean.getPostId();
		
		Session session = sessionFactory.getCurrentSession();
		SQLQuery 	sql = session.createSQLQuery("select seqToPost from test.AutoSeqPost order by seqToPost DESC");
		int v = (Integer)(sql.list()).get(0);v++;
		System.out.println(".....postid......."+v);
		AutoSeqPost asp = new AutoSeqPost();
		asp.setSeqToPost(v);
		session.save(asp);
		askbean.setPostId(v);
		session.save(askbean);
		/*SQLQuery 	sql3 = session.createSQLQuery("select seqToComment from test.AutoSeqComment order by seqToComment DESC");
		System.out.println((Integer)(sql3.list()).get(0));
		int v1 = (Integer)(sql3.list()).get(0);v1++;
		AutoSeqComment asp12 = new AutoSeqComment();
		asp12.setSeqToComment(v1);
		session.save(asp12);*/
		//System.out.println("..........commentid......."+v1);
		CommentBean cb =new CommentBean();
		cb.setCommentId(v);
		cb.setPostId(k);
	cb.setAuto(v);
	session.save(cb);
	
		return askbean;
		
	}

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public AskBean addPost(AskBean askbean) {
		System.out.println("i m in DAO post..........");
		int k = askbean.getPostId();
		Session session = sessionFactory.getCurrentSession();
		/*SQLQuery query = session.createSQLQuery( "select generatepost.nextval from dual" );
		int key = ((BigDecimal)query.uniqueResult()).intValue();*/
		SQLQuery 	sql = session.createSQLQuery("select seqToPost from test.AutoSeqPost order by seqToPost DESC");
		int v = (Integer)(sql.list()).get(0);v++;
		System.out.println(".....postid......."+v);
		AutoSeqPost asp = new AutoSeqPost();
		asp.setSeqToPost(v);
		session.save(asp);
		askbean.setPostId(v);
		session.save(askbean);
	
       
		return askbean;
	}
	
	
	
}
