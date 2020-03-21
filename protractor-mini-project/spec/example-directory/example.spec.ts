import { browser } from "protractor";

describe('TODO', () => {
    const URL: string = "https://www.redbus.in/";

    it('should go to a valid URL', () => {
        browser.get(URL);
        expect(browser.getCurrentUrl()).toContain(URL);
    });
});
