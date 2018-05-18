package unit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ExampleAPITest {


    @DataProvider(name = "circuitLocations")
    public Object[][] createCircuitTestData() {

        return new String[][] {
                {"adelaide","Australia"},
                {"detroit","USA"},
                {"george","South Africa"}
        };
    }

    @Test(dataProvider = "circuitLocations")
    public void circuitLocationTest(String circuitId, String location) {
        given().
                pathParam("circuitId",circuitId).
                when().
                get("http://ergast.com/api/f1/circuits/{circuitId}.json").
                then().
                assertThat().
                body("MRData.CircuitTable.Circuits[0].Location.country",equalTo(location));
    }
}
