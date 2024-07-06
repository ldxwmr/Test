package com.jr.flowable;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.repository.Deployment;
import org.flowable.spring.boot.app.App;
import org.flowable.task.api.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class FlowableApplicationTests {

    @Autowired
    ProcessEngine processEngine;
    @Autowired
    RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    /**
     * 流程部署操作
     */
    @Test
    void deployFlow() {
//        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deploy = repositoryService.createDeployment()
                // 一次部署操作可以部署多个流程定义
                .addClasspathResource("process/01-基础篇/FirstFlow.bpmn20.xml")
                .name("第二个流程")
                .deploy();// 部署的方法
        System.out.println("deploy.getId() = " + deploy.getId());
    }

    @Test
    void startFlow(){
//        RuntimeService runtimeService = processEngine.getRuntimeService();
        String processId = "FirstFlow:2:6e0b15c9-36b7-11ef-9c90-005056c00008";
        String processKey = "FirstFlow";// 我们创建流程图的时候自定义的。注意保证唯一

        // 1.根据流程定义ID启动流程实例
        runtimeService.startProcessInstanceById(processId);
        // 2.根据流程定义key启动流程实例
//        runtimeService.startProcessInstanceByKey(processKey);

    }

    /**
     * 根据用户查询代办信息
     */
    @Test
    void findFlow(){
        // 任务实例操作我们都是通过TaskService来实现的
//        TaskService taskService = processEngine.getTaskService();
        // 获取到act_ru_task中assignee字段是张三的记录
        List<Task> list = taskService.createTaskQuery()
                .taskAssignee("zhangsan")
                .list();
        for (Task task : list) {
            System.out.println(task.getId());
        }


    }
}
