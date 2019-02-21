package spring.mine.datasubmission.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.mine.common.controller.BaseController;
import spring.mine.common.form.BaseForm;
import spring.mine.common.validator.BaseErrors;
import spring.mine.datasubmission.form.DataSubmissionForm;

@Controller
public class DataSubmissionController extends BaseController {
  @RequestMapping(
      value = "/DataSubmission",
      method = RequestMethod.GET
  )
  public ModelAndView showDataSubmission(HttpServletRequest request,
      @ModelAttribute("form") DataSubmissionForm form) {
    String forward = FWD_SUCCESS;
    if (form == null) {
    	form = new DataSubmissionForm();
    }
        form.setFormAction("");
    Errors errors = new BaseErrors();
    

    return findForward(forward, form);}

  protected ModelAndView findLocalForward(String forward, BaseForm form) {
    if ("success".equals(forward)) {
      return new ModelAndView("dataSubmissionDefinition", "form", form);
    } else {
      return new ModelAndView("PageNotFound");
    }
  }

  protected String getPageTitleKey() {
    return null;
  }

  protected String getPageSubtitleKey() {
    return null;
  }
}
