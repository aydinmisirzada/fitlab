package fitlab.Presentation.Controller;

import fitlab.BussinessLogic.Logic.SubjectLogic;
import fitlab.Data.Model.Semester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//The class controls list of subjects
@Controller
public class SubjectListController {

    @Autowired
    SubjectLogic s_repo;

    /**
     * This method is used to show subject list page
     * @param model This is a variable used by the framework
     * @return This returns a subject list page
     */
    @GetMapping("/subjects")
    public String subjectList(Model model) {
        model.addAttribute("subject", s_repo.SearchList());
        return "subjects";
    }

    /**
     *  This method is used to add a subject to the database
     * @param code This is a code of the subject written in text form
     * @param name This is a name of the subject
     * @param semester This is semester
     * @return This returns a subject list page
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/subjects")
    public String add(@RequestParam String code, @RequestParam String name, @RequestParam Semester semester) {
        if(!s_repo.subDuplicate(code,name) || code.isEmpty() || name.isEmpty())
            return "errorpage";
        s_repo.addSubject(code, name, semester);
        return "redirect:/subjects";
    }

    /**
     * This method is used to delete a a subject to the database
     * @param id This is id of the subject
     * @return This returns a subject list page
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(value = "/subjects" , params = "id")
    public String delSubject(@RequestParam int  id) {
        s_repo.delSubject(id);
        return "redirect:/subjects";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(value = "/subjects", params = {"id","code","name","semester"})
    public String editSub(@RequestParam int id, @RequestParam String code, @RequestParam String name, @RequestParam int semester) {
        if(code.isEmpty() || name.isEmpty())
            return "errorpage";
        s_repo.editSubjectDetails(id,code,name, semester);
        return "redirect:/subjects";
    }

}
