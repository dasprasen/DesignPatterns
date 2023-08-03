package com.design.adapter;

/**
 * @author Prasenjit Kumar Das
 */
interface WebDriver {
    public void getElement();
    public void selectElement();
}

class ChromeDriver implements WebDriver {
    @Override
    public void getElement() {
        System.out.println("Get Element from ChromeDriver");
    }

    @Override
    public void selectElement() {
        System.out.println("Select Element from ChromeDriver");
    }
}

class IEDriver {
    public void findElement() {
        System.out.println("Find Element from IEDriver");
    }

    public void clickElement() {
        System.out.println("Click Element from IEDriver");
    }
}

class WebDriverAdaptor implements WebDriver {

    IEDriver ieDriver;

    public WebDriverAdaptor(IEDriver ieDriver) {
        this.ieDriver = ieDriver;
    }

    @Override
    public void getElement() {
        ieDriver.findElement();
    }

    @Override
    public void selectElement() {
        ieDriver.clickElement();
    }
}

public class AdapterDesignPatternMain {
    public static void main(String[] args) {
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.getElement();
        chromeDriver.selectElement();

        IEDriver ieDriver = new IEDriver();
        ieDriver.findElement();
        ieDriver.clickElement();

        WebDriver webDriver = new WebDriverAdaptor(ieDriver);
        webDriver.getElement();
        webDriver.selectElement();
    }
}
