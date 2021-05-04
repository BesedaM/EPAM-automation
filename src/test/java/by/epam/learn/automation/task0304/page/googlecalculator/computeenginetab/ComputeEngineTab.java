package by.epam.learn.automation.task0304.page.googlecalculator.computeenginetab;

import by.epam.learn.automation.task0304.page.AbstractPage;
import org.openqa.selenium.WebDriver;

public class ComputeEngineTab extends AbstractPage {

    public ComputeEngineTab(WebDriver driver) {
        super(driver);
    }

    public InstancesForm instancesForm() {
        return new InstancesForm(driver);
    }

    public SoleTenantNodesForm soleTenantNodesForm() {
        return new SoleTenantNodesForm(driver);
    }


}
