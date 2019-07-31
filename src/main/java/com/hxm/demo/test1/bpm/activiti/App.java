package com.hxm.demo.test1.bpm.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App {

    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:spring/spring-activiti.xml");

        RepositoryService repositoryService = (RepositoryService) applicationContext.getBean("repositoryService");

        String deplyId = repositoryService.createDeployment().addClasspathResource("bpmn/process1.bpmn").deploy().getId();

        System.out.println("deply id = "+ deplyId);

        RuntimeService runtimeService = (RuntimeService) applicationContext.getBean("runtimeService");

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("PROCESS_1");

        System.out.println(processInstance.getProcessDefinitionId()+ "is started....");

        TaskService taskService = (TaskService) applicationContext.getBean("taskService");

        List<Task> tasks = taskService.createTaskQuery().taskAssignee("shawn").list();

        System.out.println("task number for shawn is " + tasks.size());

        for(Task task: tasks){
            taskService.complete(task.getId());
            System.out.println("task id " + task.getId().toString()+ "completed...");
        }


    }
}
