package org.strasa.middleware.manager;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.strasa.middleware.model.Study;
import org.strasa.middleware.model.StudyData;

public class TestStudyManagerImpl {

	private static SqlSession session;
	private static StudyManagerImpl studyDataManager;
	private long startTime;

	@BeforeClass
	public static void setUp() throws Exception {

		studyDataManager= new StudyManagerImpl();

	}

	@Before
	public void beforeEachTest() {
		startTime = System.nanoTime();
	}

	@After
	public void afterEachTest() {
		long elapsedTime = System.nanoTime() - startTime;
		System.out.println("##### Elapsed Time = " + elapsedTime + " ns = " + ((double) elapsedTime/1000000000) + " s");
	}


	@Test
	public void TestAddStudy(){

		Study s= new Study();
		s.setStudyname("Drought 2013");

		int id=studyDataManager.addStudy(s);
		System.out.println("id generated :"+id);
	}

	@Test
	public void TestAddStudyData(){

		try{
			Study study= new Study();
			study.setStudyname("Drought 2013");

			ArrayList<StudyData> sdata= new ArrayList<StudyData>();

			StudyData data1= new StudyData();
			data1.setDatarow(1);
			data1.setDatacolumn("SOURCE");
			data1.setDatavalue("IR 64");
			sdata.add(data1);

			StudyData data2= new StudyData();
			data2.setDatarow(2);
			data2.setDatacolumn("SOURCE");
			data2.setDatavalue("IR 38");
			sdata.add(data2);
			studyDataManager.addStudyData(study, sdata);
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}

}
