package spring.generated.dataexchange.aggregatereporting.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.generated.forms.TestUsageConfigurationForm;
import spring.mine.common.controller.BaseController;
import spring.mine.common.form.BaseForm;
import spring.mine.common.validator.BaseErrors;

@Controller
public class TestUsageConfigurationController extends BaseController {
  @RequestMapping(
      value = "/TestUsageConfiguration",
      method = RequestMethod.GET
  )
  public ModelAndView showTestUsageConfiguration(HttpServletRequest request,
      @ModelAttribute("form") TestUsageConfigurationForm form) {
    String forward = FWD_SUCCESS;
    if (form == null) {
    	form = new TestUsageConfigurationForm();
    }
        form.setFormAction("");
    Errors errors = new BaseErrors();
    

    return findForward(forward, form);}

  protected ModelAndView findLocalForward(String forward, BaseForm form) {
    if ("success".equals(forward)) {
      return new ModelAndView("testUsageConfigurationDefinition", "form", form);
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
