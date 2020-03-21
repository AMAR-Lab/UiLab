import {browser, element, by, protractor, ElementFinder } from "protractor";
import * as fs from "fs";
//import { bind } from "@angular/core/src/render3/instructions";
//import { boolean } from "@pact-foundation/pact-web/dsl/matchers";

let until = protractor.ExpectedConditions;
export class CoreFunctions {
    /*Note: This method is not working the way I expected it. But, if we can figure out how to make use of it, it would help us centralized 'waiting'. The following page suggests we have the "correct" implementation.
     https://stackoverflow.com/questions/30205235/protractor-waiting-for-element-to-be-in-dom */

    static waitForBrowserResponse: number = 1500;
    static waitFiveSeconds: number = 5000;
    static waitTwoSeconds: number = 2000;
    static waitThreeSeconds: number = 3000;
    static waitHalfSeconds: number = 500;
    static defaultWaitTime: number = 5000;
    static defaultFactor: number = 4;
    //Method is Describe for to check the Webelement is displayed in every half second with maximum waiting time ten second. 
    static getElementByTagName(tagName: string, time: number = 500) {
        this.waitUntilElementIsReady("tagName", tagName, time);
        return element(by.tagName(tagName));
    }

    //Method is Describe for to check the Webelement is displayed in every half second with maximum waiting time ten second. 
    static getElelemtByModelName(model: string, time: number = 500) {
        this.waitUntilElementIsReady("model", model, time);
        return element(by.model(model));
    }
    //Method is Describe for to check the Webelement is displayed in every half second with maximum waiting time ten second. 
    static getElementById(id: string, time: number = 500) { 
        this.waitUntilElementIsReady("id", id, time); 
        return element(by.id(id)).getWebElement();
     }
    //Method is Describe for to check the Webelement is displayed in every half second with maximum waiting time ten second.
    static getElementByXpath(xpath: string, time: number = 500) { 
        this.waitUntilElementIsReady("xpath", xpath, time);
         return element(by.xpath(xpath)); 
        }
    //Method is Describe for to check the Webelement is displayed in every half second with maximum waiting time ten second. 
    static getElementByCSS(css: string, time: number = 500) {
        this.waitUntilElementIsReady("css", css, time); 
        return element(by.css(css)); 
    }
    //Method is Describe for to check the Webelement is displayed in every half second with maximum waiting time ten second. 
    static getElementByClassName(className: string, time: number = 500) {
         this.waitUntilElementIsReady("className", className, time); 
         return element(by.className(className));
         }
    //Method is Describe for to check the Webelement is displayed in every half second with maximum waiting time ten second. 
    static getElementByBinding(binding: string, time: number = 500) {
         this.waitUntilElementIsReady("binding", binding, time); 
         return element(by.binding(binding)); 
        }
    //Method is Describe for to check the Webelement is displayed in every half second with maximum waiting time ten second. 
    static getAllElementsByXpath(xpath: string, time: number = 500) { 
        this.waitUntilElementIsReady("xpath", xpath, time);
         return element.all(by.xpath(xpath)); 
        }
    /* * This method waits for an element to become Visible, Enabled, and Displayed, for a defined amount of time. * NOTE: This is intended to be used only within this class. ALL instances must provide a VALID strategy, or the code will fail. * NOTE: This method should never take more than 20 seconds to return; there is a default timeout for each test, it is specified in the configuration.
     * */
    private static waitUntilElementIsReady(strategy: string, locator: string, time: number) {
        let isDisplayed; let isEnabled let isPresent;
        let tagName = "tagName";
        let xpath = "xpath";
        let model = "model";
        let id = "id";
        let css = "css";
        let binding = "binding";
        browser.wait(function () {
            return browser.wait(function () {
                switch (strategy) {
                    case tagName: {
                        isDisplayed = element(by.tagName(locator)).isDisplayed();
                        isEnabled = element(by.tagName(locator)).isEnabled();
                        isPresent = element(by.tagName(locator)).isPresent();
                        break;
                    }
                    case xpath: {
                        isDisplayed = element(by.xpath(locator)).isDisplayed();
                        isEnabled = element(by.xpath(locator)).isEnabled();
                        isPresent = element(by.xpath(locator)).isPresent();
                        break;
                    }
                    case model: {
                        isDisplayed = element(by.model(locator)).isDisplayed();
                        isEnabled = element(by.model(locator)).isEnabled();
                        isPresent = element(by.model(locator)).isPresent();
                        break;
                    }
                    case id: {
                        isDisplayed = element(by.id(locator)).isDisplayed();
                        isEnabled = element(by.id(locator)).isEnabled();
                        isPresent = element(by.id(locator)).isPresent();
                        break;
                    }
                    case css: {
                        isDisplayed = element(by.css(locator)).isDisplayed();
                        isEnabled = element(by.css(locator)).isEnabled();
                        isPresent = element(by.css(locator)).isPresent();
                        break;
                    }
                    case binding: {
                        isDisplayed = element(by.binding(locator)).isDisplayed();
                        isEnabled = element(by.binding(locator)).isEnabled();
                        isPresent = element(by.binding(locator)).isPresent();
                        break;
                    }
                } CoreMethods.waitUntilPleaseWaitDialogIsNotPresent();
                return isDisplayed && isEnabled && isPresent;
            }, time).then(function () {
                //*time* here refers to how *often* the framework checks for the presence of this element. 
                return true;
            }, function () { return false; });
        }, this.defaultFactor * this.defaultWaitTime);
        //this last parameter specifies *how long* the framework should wait for the element to become present (or not).
    } /* * This method waits until an element is NOT visible. * */
    public static waitUntilPleaseWaitDialogIsNotPresent() {
        let xpathToPleaseWaitDialog = "//*[contains(text(),'Please wait')]";
        this.waitUntilElementIsNotPresent(xpathToPleaseWaitDialog, this.waitHalfSeconds, this.defaultWaitTime);
    }
    /* * This method waits until an element is NOT visible. * */
    public static waitUntilElementIsNotPresent(xpath: string, frequency: number, timeout: number) {
        browser.wait(function () {
            return browser.wait(function () {
                let isElementDisplayed = element(by.xpath(xpath)).isDisplayed();
                let isElementEnabled = element(by.xpath(xpath)).isEnabled();
                let isElementPresent = element(by.xpath(xpath)).isPresent();
                return isElementDisplayed && isElementEnabled && isElementPresent;
            }, frequency).then(function () {
                //call it again until the element is not present.
                CoreMethods.waitUntilElementIsNotPresent(xpath, frequency, timeout);
            }, function () {
                return true;
                //Yes, the element is NOT present! 
            });
        }, timeout); //max time allocated for the wait..
    }
    /** * Checks if an element represented by an xpath, is present 
     * * @param xpath The locator identifying the element being searched for. 
     * */
    public static isElementByXpathPresent(xpath: string) {
        return element(by.xpath(xpath)).isPresent();
    }
}

