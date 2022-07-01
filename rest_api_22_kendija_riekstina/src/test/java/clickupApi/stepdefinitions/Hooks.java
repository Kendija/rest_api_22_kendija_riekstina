package clickupApi.stepdefinitions;

import clickupApi.helpers.TestCaseContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.json.simple.JSONObject;

import static clickupApi.clients.ClickupClient.deleteFolder;

public class Hooks {
    @Before
    public void beforeScenario(Scenario scenario){
        TestCaseContext.setScenario(scenario);
        System.out.println("This scenario is beginning!");
    }
    @After
    public void afterScenario(){
        JSONObject obj = new JSONObject();
        deleteFolder(obj);
        System.out.println("This scenario is done!");
    }
}
