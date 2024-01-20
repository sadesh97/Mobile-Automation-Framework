import api.endpoints.Routes;
import api.payloads.User;
import api.utilities.RequestUtil;
import api.utilities.ResponseUtil;
import base.DriverBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageEvents.HybridAppEvents;
import pageEvents.NativeCalEvents;
import pageEvents.WebAppEvents;
import utils.Constants;
import utils.FetchElement;

/*
 *1/4/2024 created by Sadesh Maheeshakya
 */
public class TestMobile extends DriverBase {

    @Test
    public static void HybridAppActivity() {
        SoftAssert softAssert = new SoftAssert();

        HybridAppEvents.openHybridApp("com.wdiodemoapp", ".MainActivity");
        FetchElement.addWait(Constants.hybridApp, 10);
        HybridAppEvents.clickWebViewBtn();
        FetchElement.addWait(Constants.hybridApp, 4);
        HybridAppEvents.switchAppToWebViewContext();
        HybridAppEvents.clickMenuBtn();
        HybridAppEvents.clickThemeChangerBtn();
        HybridAppEvents.clickCloseSign();
        HybridAppEvents.switchAppToNativeContext();
        FetchElement.addWait(Constants.hybridApp, 10);
        HybridAppEvents.clickLoginBtn();
        softAssert.assertTrue(HybridAppEvents.isLoginSectionAppears(), "Not switched to native APP correctly");
        softAssert.assertAll();

    }


    @Test
    public static void NativeCalActivity() {
        SoftAssert softAssert = new SoftAssert();

        NativeCalEvents.openNativeCalculatorApp("com.miui.calculator", "com.miui.calculator.cal.CalculatorActivity");
        NativeCalEvents.chooseFrameLayout();
        FetchElement.addWait(Constants.nativeApp, 10);
        NativeCalEvents.clickNumberSeven();
        FetchElement.addWait(Constants.nativeApp, 10);
        NativeCalEvents.clickPlusSign();
        FetchElement.addWait(Constants.nativeApp, 10);
        NativeCalEvents.clickNumberTwo();
        FetchElement.addWait(Constants.nativeApp, 10);
        NativeCalEvents.clickPlusSign();
        FetchElement.addWait(Constants.nativeApp, 10);
        NativeCalEvents.clickNumberOne();
        FetchElement.addWait(Constants.nativeApp, 10);
        NativeCalEvents.clickEqualSign();
        FetchElement.addWait(Constants.nativeApp, 10);
        String results = NativeCalEvents.answerFieldValue();
        softAssert.assertEquals(results.replace("= ", ""), "10", "Wrong results");
        softAssert.assertAll();


        // TEST API
        System.out.println("API used in here-----------------------------------------");
        User user = new User();
        user.setId(1);
        user.setUsername("sadeshM");
        user.setFirstName("Sade");
        user.setLastName("Mana");

        //create
        Response response = RequestUtil.commonPOSTRequest(user, Routes.createUser);
        softAssert.assertEquals(ResponseUtil.getResponseCode(response), "200", "Invalid response code");

        //read
        Response response1 = RequestUtil.commonGETRequest("userName", user.getUsername(), Routes.getUser);
        softAssert.assertEquals(ResponseUtil.getResponseCode(response1), "200", "Invalid response code");
        softAssert.assertEquals(ResponseUtil.getValueFromResponse(response1, "username"), user.getUsername(), "Invalid UserName");


    }


    @Test
    public static void WebAppActivity() {
        SoftAssert softAssert = new SoftAssert();

        WebAppEvents.enterEmail("testuser@cc.com");
        WebAppEvents.enterPassword("1234Qwert");
        //wait
        String errorText = WebAppEvents.getErrorMsg();
        softAssert.assertEquals(errorText, "Need help with finding your account?", "Wrong error Text");
        softAssert.assertAll();
    }

}
