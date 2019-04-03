package ie.keithmurphy.hertzassignment.dao;

import ie.keithmurphy.hertzassignment.beans.UberDrivesBean;

import java.util.List;

public interface UberDriveDao {

    List<UberDrivesBean> findAll();

    boolean updateUberDrive(UberDrivesBean bean);

    List<UberDrivesBean> getById(int id);

}
