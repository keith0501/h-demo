package ie.keithmurphy.hertzassignment.mapper;

import ie.keithmurphy.hertzassignment.beans.UberDrivesBean;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UberDrivesRowMapper implements RowMapper<UberDrivesBean> {

    @Override
    public UberDrivesBean mapRow(ResultSet rs, int arg1)  {
        UberDrivesBean bean = new UberDrivesBean();
        try{

            bean.setId(Integer.parseInt(rs.getString("id")));
            bean.setCategory(rs.getString("category"));
            bean.setMiles(Float.parseFloat(rs.getString("miles")));
            bean.setPurpose(rs.getString("purpose"));
            bean.setStart(rs.getString("start"));
            bean.setStop(rs.getString("stop"));
            bean.setEndDate(new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(rs.getString("end_date")));
            bean.setStartDate(new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(rs.getString("start_date")));


        }catch(SQLException e){
            e.printStackTrace();
        }catch(ParseException e){
            e.printStackTrace();
        }
        return bean;
    }
}
