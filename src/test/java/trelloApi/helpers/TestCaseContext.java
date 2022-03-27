package trelloApi.helpers;

import io.cucumber.java.Scenario;
import trelloApi.domain.Board;
import trelloApi.domain.List;

public class TestCaseContext {
        private static Board testBoard;

        private static List testList;

        private static Scenario scenario;

        public static void init(){
            testBoard = null;
            testList = null;
        }

        public static void setBoard(Board testBoard){
            TestCaseContext.testBoard = testBoard;
        }

        public static Board getTestBoard(){
            return testBoard;
        }

        public static void setList(List testList){  /// tuj
            TestCaseContext.testList = testList;
        }

        public static List getList(){ // tuj
            return testList;
        }

    public static void setScenario(Scenario scenario){  /// tuj
        TestCaseContext.scenario = scenario;
    }

    public static Scenario getScenario(){ // tuj
        return scenario;
    }
}
