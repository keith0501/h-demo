package ie.keithmurphy.hertzassignment.controllers;



import ie.keithmurphy.hertzassignment.beans.UberDrivesBean;
import ie.keithmurphy.hertzassignment.dao.UberDrivesDaoImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class main {



    @Resource
    UberDrivesDaoImpl impl;

    @GetMapping("/")
    public String main(Model model){

        List<UberDrivesBean> beans = impl.findAll();
        System.out.println(beans.size());
        model.addAttribute("beans", beans);
        return "main";
    }


    @GetMapping("/update/{beanId}")
    public String updateForm(@PathVariable(value="beanId") String beanId, Model model) {

        List<UberDrivesBean> beans = impl.getById(Integer.parseInt(beanId));
        model.addAttribute("bean", beans.get(0));

        return "update-uber-drive";

    }




    @PostMapping("/update")
    public ModelAndView updateUberDriveBean(@ModelAttribute("bean") UberDrivesBean bean){
        boolean updated;
        String path;
        boolean success = false;
        boolean failure = false;


      updated = impl.updateUberDrive(bean);

      if(!updated) {
          failure = true;
      }else{
          success = true;
      }

       // model.addAttribute("bean", bean);

        if (!failure){
            return  new ModelAndView("redirect:/");
        }else{
            return  new ModelAndView("/new-tpp", "failure", failure );
        }
    }


}
