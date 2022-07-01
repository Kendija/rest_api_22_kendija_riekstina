package clickupApi.stepdefinitions;

import clickupApi.domain.Folder;
import clickupApi.domain.List;
import clickupApi.domain.Space;
import clickupApi.domain.Task;
import clickupApi.helpers.TestCaseContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.json.simple.JSONObject;
import org.junit.Test;

import static clickupApi.clients.ClickupClient.*;

public class ClickupSteps {
    @Given("We have a space to use")
    public void GetSpace(){
        Response resp = getSpace();
        Space defaultSpace = resp.as(Space.class);
        System.out.println("Space id: " + defaultSpace.getId());
        System.out.println("Space name: " + defaultSpace.getName());
    }
    @When("Create folder {string}, save folders data and check that the name is correct")
    public void CreateFolderAndCheckInfo(String name){
        JSONObject obj = new JSONObject();
        obj.put("name", name);
        Response resp = CreateFolder(name, obj);
        Folder defaultFolder = resp.as(Folder.class);
        Assertions.assertThat(defaultFolder.getName())
                .as("Checking if the folders name is correct")
                .isEqualTo(name);

        TestCaseContext.setFolder(defaultFolder);
    }
    @Then("Create list with name {string} in the folder")
    public void CreateListInFolder(String name){
        JSONObject obj = new JSONObject();
        obj.put("name", name);
        Response resp = CreateList(name, obj);
        List defaultList = resp.as(List.class);
        TestCaseContext.setList(defaultList);
    }
    @And("Check that list name is {string} and check that it is inside {string}")
    public void CheckListInfo(String listName, String folderName){
        List testList = TestCaseContext.getList();
        Folder testFolder = TestCaseContext.getFolder();
        Assertions.assertThat(testList.getName())
                .as("Checking if list name is correct")
                .isEqualTo(listName);
        Assertions.assertThat(testFolder.getName())
                .as("Checking if list is in the correct folder")
                .isEqualTo(folderName);
    }
    @Then("Create task {string} in the list")
    public void CreateTask(String name){
        JSONObject obj = new JSONObject();
        obj.put("name", name);
        Response resp = createTaskInList(name, obj);
        Task defaultTask = resp.as(Task.class);
        TestCaseContext.setTask(defaultTask);
    }
    @And("Check that tasks name is {string}")
    public void CheckTaskInfo(String taskName){
        Task testTask = TestCaseContext.getTask();
        Assertions.assertThat(testTask.getName())
                .as("Checking if task name is correct")
                .isEqualTo(taskName);
    }
    @When("Remove {string} from the list")
    public void RemoveTask(String name){
        JSONObject obj = new JSONObject();
        obj.put("name", name);
        deleteTask(name, obj);
    }
    @Then("Check that task is removed from the list")
    public void CheckIfTaskExists(){
        List testList = TestCaseContext.getList();
        Assertions.assertThat(testList.getTaskCount())
                .as("Checking if the task is removed")
                .isEqualTo(null);
    }
}
