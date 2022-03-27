package trelloApi.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import trelloApi.helpers.TestCaseContext;

import static trelloApi.Clients.TrelloClient.changeBoardName;
import static trelloApi.Clients.TrelloClient.deleteList;

public class Hooks {
    @Before
    public void beforeEveryScenario(Scenario scenario){
        TestCaseContext.init();
        TestCaseContext.setScenario(scenario);
        System.out.println("THE SCENARIO IS BEGINING THE EXECUTION!");
    }

    @After
    public void afterEveryScenario(){
        changeBoardName("Default");
        deleteList();
        System.out.println("THE SCENARIO IS FINISHED!");
    }

}
