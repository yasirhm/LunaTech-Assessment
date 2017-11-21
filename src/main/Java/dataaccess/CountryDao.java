package dataaccess;

import model.Country;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Yasi on 11/16/2017.
 */
public class CountryDao {
//    final static Logger logger = Logger.getLogger(CountryDao.class);
    public void add(Country country){}
    public void update(Country country){}
    private Query createFindQuery(Object sample , Session session){
        Class<?> aClass = sample.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        List<Field> constrains = new ArrayList<Field>();
        StringBuilder queryString = new StringBuilder("from "+aClass.getName() +" d ");
        for (Field field : declaredFields) {
            try {

                field.setAccessible(true);
                Object value = field.get(sample);
                if(!ValueUtil.IsDefault(value) && !(field.getName().equals("id") && value.toString().equals("0")))
                    constrains.add(field);
            }catch (IllegalAccessException e){
                continue;
            }
        }
        /*if (constrains.size() == 1){
            String name = constrains.get(0).getName();
            queryString.append(" Where ");
            queryString.append( "d.").append(name).append(" like ").append(name).append('%');
        }
        else */
            if(constrains.size() > 0){
            queryString.append(" Where 1= 1 ");
            for (Field constrain : constrains) {
                String name = constrain.getName();
                queryString.append( " and d.").append(name).append(" =:").append(name);
            }
        }
        Query query = session.createQuery(queryString.toString());
        try {
            for (Field constrain : constrains) {
                constrain.setAccessible(true);
                Object value = constrain.get(sample);
                String name = constrain.getName();
                query.setParameter(name , value);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return query;
    }

    public Collection<Country> Find(Country country){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            Query query = createFindQuery(country, session);
            return query.list();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
//            logger.error(e.getMessage());
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        finally {
            session.close();
        }
    }

    public List<Object> getAirportsCount(){
        String queryStr = "SELECT co.name, COUNT(*) as airport_count " +
                "FROM Country co JOIN co.airports airport " +
                "group by co.name " +
                "order by 2";
        return load(queryStr);
    }

    public List<Object> countriesRunwaysType(){
        String queryStr = "SELECT distinct co.name as name, run.surface as type FROM Country co Join co.airports as airport Join airport.runways as run " +
                "  order by name";
        return load(queryStr);
    }

    public List<Object> commonRunwaysLeIdent(){
        String queryStr = "SELECT run.leIdent, COUNT(run.leIdent) As leCount FROM Runway AS run " +
                "GROUP BY run.leIdent order by leCount";
        return load(queryStr);
    }

    private List<Object> load(String queryStr){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery(queryStr);
            return query.list();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        finally {
            session.close();
        }
    }
}
