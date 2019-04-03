package ie.keithmurphy.hertzassignment.dao;

import ie.keithmurphy.hertzassignment.beans.UberDrivesBean;
import ie.keithmurphy.hertzassignment.mapper.UberDrivesRowMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UberDrivesDaoImpl implements UberDriveDao {

    NamedParameterJdbcTemplate template;
    boolean updated;
    public UberDrivesDaoImpl(NamedParameterJdbcTemplate template){
        this.template = template;
    }

    @Override
    public List<UberDrivesBean> findAll(){
        return template.query("select * from uber_drives order by id", new UberDrivesRowMapper());
    }


    @Override
    public List<UberDrivesBean> getById(int id){
        //final String sql = "select * from uber_drives where id = :id";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", id);
    return template.query("select * from uber_drives where id = :id", param, new UberDrivesRowMapper());

    }

    @Override
    public boolean updateUberDrive(UberDrivesBean bean){
       updated = false;
       String sql = "update uber_drives set  category=:category, start=:start, stop=:stop, miles=:miles, purpose=:purpose where id =:id";
       Map<String, Object> map = new HashMap<String, Object>();
       map.put("category", bean.getCategory());
       map.put("start", bean.getStart());
       map.put("stop", bean.getStop());
       map.put("miles", bean.getMiles());
       map.put("purpose", bean.getPurpose());
       map.put("id", bean.getId());


       template.execute(sql,map,new PreparedStatementCallback<Object>(){
           @Override
           public Object doInPreparedStatement(PreparedStatement ps)
                    {
                        int val = 0;
                        try{
                           val =  ps.executeUpdate();
                           updated = true;
                        }catch (SQLException e){
                            e.printStackTrace();
                        }
                return val;
           }
       });
        return updated;
    }


}
