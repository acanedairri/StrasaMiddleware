package org.strasa.middleware.manager;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.StudyDataMapper;
import org.strasa.middleware.mapper.StudyMapper;
import org.strasa.middleware.model.Study;
import org.strasa.middleware.model.StudyData;

public class StudyManagerImpl {



	private SqlSession session;


	public StudyManagerImpl(){
		ConnectionFactory con = new ConnectionFactory();
		session =con.getSqlSessionFactory().openSession();
	}

	public int addStudy(Study record){
		StudyMapper studyMapper = session.getMapper(StudyMapper.class);
		try{
			studyMapper.insert(record);
			session.commit();
		}
		finally{
			
		}
		return record.getId();
	}


	public void addStudyData(Study study, List<StudyData> studyData){
		StudyDataMapper studyDataMapper = session.getMapper(StudyDataMapper.class);
		StudyMapper studyMapper = session.getMapper(StudyMapper.class);
		try{
			studyMapper.insert(study);
			for(StudyData sdata:studyData){
				sdata.setStudyid(study.getId());
				studyDataMapper.insert(sdata);
			}
			session.commit();
			System.out.println("Hello");
		}finally{
			session.close();
		}

	}



}
