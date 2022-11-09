package crudemployees.controller;

import crudemployees.entity.Department;
import crudemployees.entity.Employee;
import crudemployees.entity.Language;
import crudemployees.service.DepartmentService;
import crudemployees.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import crudemployees.service.EmployeeService;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private LanguageService languageService;
    @Autowired
    private DepartmentService departmentService;

    @ModelAttribute
    public void addAttributes(Model model) {
        List<Language> languages = languageService.getAllLanguages();
        model.addAttribute("languages", languages);
        List<Department> departments = departmentService.getAllDepartments();
        model.addAttribute("departments", departments);
    }

    @RequestMapping("/")
    public String showAllEmployees(Model model) {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmps", allEmployees);
        return "all-employees";
    }

    @RequestMapping("/add-new-employee")
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee-info";
    }

    @RequestMapping("/save-employee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @RequestMapping("/update-info")
    public String updateEmployee(@RequestParam(name = "empId") int id, Model model) {
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);
        return "employee-info";
    }

    @RequestMapping("/delete-employee")
    public String deleteEmployee(@RequestParam(name = "empId") int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }

    @RequestMapping("/languages-data")
    public String showLanguagesData() {
        return "languages-data";
    }

    @RequestMapping("/add-new-language")
    public String addNewLanguage(Model model) {
        Language language = new Language();
        model.addAttribute("language", language);
        return "language-info";
    }

    @RequestMapping("/save-language")
    public String saveLanguage(@ModelAttribute("language") Language language) {
        languageService.saveLanguage(language);
        return "redirect:languages-data";
    }

    @RequestMapping("/delete-language")
    public String deleteLanguage(@RequestParam(name = "langId") int id) {
        languageService.deleteLanguage(id);
        return "redirect:languages-data";
    }

    @RequestMapping("/departments-data")
    public String showDepartmentsData() {
        return "departments-data";
    }

    @RequestMapping("/add-new-department")
    public String addNewDepartment(Model model) {
        Department department = new Department();
        model.addAttribute("department", department);
        return "department-info";
    }

    @RequestMapping("/save-department")
    public String saveDepartment(@ModelAttribute("department") Department department) {
        departmentService.saveDepartment(department);
        return "redirect:departments-data";
    }

    @RequestMapping("/delete-department")
    public String deleteDepartment(@RequestParam(name = "deptId") int id) {
        departmentService.deleteDepartment(id);
        return "redirect:departments-data";
    }

    @RequestMapping("/to-main-page")
    public String toMainPage() {
        return "redirect:/";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(List.class, "languages", new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                String[] ids = text.split(",");
                List<Language> availableLangs = languageService.getAllLanguages();
                List<Language> empLanguages = new ArrayList<>();
                for (String id : ids) {
                    Language lang = availableLangs.get(
                            availableLangs.indexOf(
                                    new Language(Integer.parseInt(id))));
                    empLanguages.add(lang);
                }
                setValue(empLanguages);
            }
        });

        binder.registerCustomEditor(Department.class, "department", new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                List<Department> departments = departmentService.getAllDepartments();
                for (Department dept : departments) {
                    if (dept.getId() == Integer.parseInt(text)) {
                        setValue(dept);
                        return;
                    }
                }
            }
        });
    }
}
