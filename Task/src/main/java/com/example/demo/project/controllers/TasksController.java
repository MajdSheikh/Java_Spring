package com.example.demo.project.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.project.models.User;
import com.example.demo.project.services.TaskService;
import com.example.demo.project.services.UserService;

@Controller
public class TasksController {
    private final TaskService taskService;
    private final UserService userService;
    
    public TasksController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }
    
    // Show all tasks
    @RequestMapping("/tasks")
    public String index(Model model, HttpSession session) {
        List<Task> tasks = taskService.allTasks();
        Long user_id = (Long) session.getAttribute("userId");
        User u = userService.findUserById(user_id);
        model.addAttribute("tasks", tasks);
        model.addAttribute("userName", u.getName());
        return "homePage.jsp";
    }
    
    // Show create page
    @RequestMapping("/tasks/new")
    public String newTask(@ModelAttribute("task") Task task, Model model, HttpSession session) {
    	Long user_id = (Long) session.getAttribute("userId");
        User u = userService.findUserById(user_id);
    	List<User> users = userService.allUsers();
    	session.setAttribute("users", users);
    	model.addAttribute("currentUserName", u.getName());
        return "newTask.jsp";
    }
    
    // Process task creation
    @RequestMapping(value="/tasks", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("task") Task task, BindingResult result) {
        if (result.hasErrors()) {
            return "newTask.jsp";
        } else {
        	taskService.createTask(task);
            return "redirect:/tasks";
        }
    }
    
    // Show a task
    @RequestMapping("tasks/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("task", taskService.findTask(id));
		return "showTask.jsp";
	}
    
    // Show edit page
    @RequestMapping("/tasks/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
    	Long user_id = (Long) session.getAttribute("userId");
        User u = userService.findUserById(user_id);
        com.example.demo.project.models.Task task = taskService.findTask(id);
        List<User> users = userService.allUsers();
        
        model.addAttribute("task", task);
    	session.setAttribute("users", users);
        model.addAttribute("userName", u.getName());
        return "editTask.jsp";
    }
    
    // Process task update
    @RequestMapping(value="/tasks/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("task") com.example.demo.project.models.Task task, BindingResult result) {
        if (result.hasErrors()) {
            return "editTask.jsp";
        } else {
        	taskService.updateTask(task);
            return "redirect:/tasks";
        }
    }
    
    // Delete a task
    @RequestMapping(value="/tasks/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
    	taskService.deleteTask(id);
        return "redirect:/tasks";
    }
}