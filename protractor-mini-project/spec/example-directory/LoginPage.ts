import { browser } from "protractor";
import { CoreFunctions } from "../CoreFunctions";

export class LoginPage {

    navigateTo() {
        return browser.get('/');
    }

    verifyProductName() {
        CoreFunctions.getElementByClassName("redbus-logo home-redirect").getText().then(function (text) {
            expect(text).toEqual('redbus')
        });
    }

    login(userName: string, userPassword: string) {
        let userNameField = CoreFunctions.getElementById('username');
        let userPassField = CoreFunctions.getElementById('password');
        CoreFunctions.getElementById("i-icon-profile").click();
        userNameField.sendKeys(userName);
        userPassField.sendKeys(userPassword);
        let userLoginBtn = CoreFunctions.getElementById('login-btn');
        userLoginBtn.click(); browser.sleep(2000);
    }

    static logout() {
        browser.sleep(CoreFunctions.waitTwoSeconds).then(function () {
            CoreFunctions.getElementById('nav-username-dd').click().then(function () {
                browser.sleep(CoreFunctions.waitForBrowserResponse).then(function () {
                    CoreFunctions.getElementById('logoutlink').click().then(function () {
                        console.log("Logged out successfully.");
                    });
                });
            });
        });//need to wait for complete the validation 
    }
}