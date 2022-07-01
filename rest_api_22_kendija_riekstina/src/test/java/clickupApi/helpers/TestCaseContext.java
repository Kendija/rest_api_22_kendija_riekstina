package clickupApi.helpers;

import clickupApi.domain.Folder;
import clickupApi.domain.List;
import clickupApi.domain.Task;
import io.cucumber.java.Scenario;

import static clickupApi.clients.ClickupClient.deleteFolder;

public class TestCaseContext {
    private static Folder testFolder;
    private static List testList;
    private static Task testTask;
    private static Scenario scenario;
    public static void setFolder(Folder testFolder){
        TestCaseContext.testFolder = testFolder;
    }
    public static Folder getFolder(){
        return  testFolder;
    }
    public static void setList(List testList){
        TestCaseContext.testList = testList;
    }
    public static List getList(){
        return  testList;
    }
    public static void setTask(Task testTask){
        TestCaseContext.testTask = testTask;
    }
    public static Task getTask(){
        return testTask;
    }
    public static void setScenario(Scenario scenario){
        TestCaseContext.scenario = scenario;
    }
    public static Scenario getScenario(){
        return scenario;
    }
}
