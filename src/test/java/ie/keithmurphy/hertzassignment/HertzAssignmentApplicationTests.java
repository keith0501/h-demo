package ie.keithmurphy.hertzassignment;

import ie.keithmurphy.hertzassignment.beans.UberDrivesBean;
import ie.keithmurphy.hertzassignment.dao.UberDrivesDaoImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.validation.constraints.AssertTrue;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class HertzAssignmentApplicationTests {

   @Resource
   private UberDrivesDaoImpl uberDrivesDaoimpl;

//
//    @Test
//    public void contextLoads() {
//    }


    @Test
    public void LoadedDatabase(){
        List<UberDrivesBean> beans = uberDrivesDaoimpl.findAll();

        assertEquals(true, beans.size() > 0);

    }


    @Test
    public void LoadSingleField(){
        List<UberDrivesBean> beans = uberDrivesDaoimpl.getById(1);

        assertEquals(true, beans.size() == 1);

    }

}
