package zen;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

import com.google.gson.JsonElement;

/**
 * StandardResponseTest
 */
public class StandardResponseTest {

    private static StandardResponse standardResponse;

    // before
    @BeforeAll
    static void buildUp() {        
        standardResponse = new StandardResponse(StatusResponseEnum.SUCCESS, "");
    }

    // tests functions
    @DisplayName("getStatus function should return the 'status' value")
    @Test
    public void getCurrentStatus() {
        Assertions.assertEquals(StatusResponseEnum.SUCCESS, standardResponse.getStatus());
    }

    @DisplayName("getCurrentMessage function should return the 'message' value")
    @Test
    public void getCurrentMessage() {
        Assertions.assertEquals("message", standardResponse.getMessage());
    }

    @DisplayName("getData function should return the 'data' value")
    @Test
    public void getCurrentData() {
        JsonElement jsonElementMock = mock(JsonElement.class);
        standardResponse = new StandardResponse(StatusResponseEnum.SUCCESS, jsonElementMock);
        Assertions.assertEquals(jsonElementMock, standardResponse.getData());
    }

    @DisplayName("setStatus function should set the 'status' value")
    @Test
    public void setCurrentStatus() {
        standardResponse.setStatus(StatusResponseEnum.ERROR);
        Assertions.assertEquals(StatusResponseEnum.ERROR, standardResponse.getStatus());
    }

    @DisplayName("setMessage function should set the 'message' value")
    @Test
    public void setCurrentMessage() {
        standardResponse.setMessage("message");
        Assertions.assertEquals("message", standardResponse.getMessage());
    }

    @DisplayName("setData function should set the 'data' value")
    @Test
    public void setCurrentData() {
        JsonElement jsonElementMock = mock(JsonElement.class);
        standardResponse.setData(jsonElementMock);
        Assertions.assertEquals(jsonElementMock, standardResponse.getData());
    }

    // after
    @AfterAll
    static void finish() {
        System.out.println("Unit Test are finished!");
    }
}