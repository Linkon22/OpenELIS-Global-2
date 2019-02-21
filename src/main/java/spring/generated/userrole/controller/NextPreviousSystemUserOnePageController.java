package spring.generated.userrole.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.generated.forms.UserRoleForm;
import spring.mine.common.controller.BaseController;
import spring.mine.common.form.BaseForm;
import spring.mine.common.validator.BaseErrors;

@Controller
public class NextPreviousSystemUserOnePageController extends BaseController {
  @RequestMapping(
      value = "/NextPreviousSystemUserOnePage",
      method = RequestMethod.GET
  )
  public ModelAndView showNextPreviousSystemUserOnePage(HttpServletRequest request,
      @ModelAttribute("form") UserRoleForm form) {
    String forward = FWD_SUCCESS;
    if (form == null) {
    	form = new UserRoleForm();
    }
        form.setFormAction("");
    Errors errors = new BaseErrors();
    

    return findForward(forward, form);}

  protected ModelAndView findLocalForward(String forward, BaseForm form) {
    if ("success".equals(forward)) {
      return new ModelAndView("/UserRole.do", "form", form);
    } else if ("fail".equals(forward)) {
      return new ModelAndView("userRoleDefinition", "form", form);
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
