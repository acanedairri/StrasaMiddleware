package org.strasa.middleware.factory;
 
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.strasa.middleware.mapper.StudyDataMapper;
import org.strasa.middleware.mapper.StudyMapper;
 
public class ConnectionFactory {
 


    private static SqlSessionFactory sqlSessionFactory;
 
    
    
    public ConnectionFactory(){
    
    
            String resource = "SqlMapConfig.xml";
            Reader reader;
			try {
				reader = Resources.getResourceAsReader(resource);
				 if (sqlSessionFactory == null) {
		                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		                sqlSessionFactory.getConfiguration().addMapper(StudyMapper.class);
		                sqlSessionFactory.getConfiguration().addMapper(StudyDataMapper.class);
//		                sqlSessionFactory.getConfiguration().addMapper();
		            
		            }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 
           
    }
 
    public SqlSessionFactory getSqlSessionFactory() {
 
        return sqlSessionFactory;
    }
    /**
     * Returns a DataSource object.
     *
     * @return a DataSource.
     */
   
}