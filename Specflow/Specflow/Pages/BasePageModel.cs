using System.Collections.ObjectModel;
using OpenQA.Selenium;

namespace Specflow.Pages
{
    public class BasePageModel
    {
        protected IWebDriver Driver { get; set; }
        protected By PageMarker { get; set; }

        protected BasePageModel(IWebDriver driver)
        {
            this.Driver = driver;
        }

        protected IWebElement GetWebElement(By selector)
        {
            return this.Driver.FindElement(selector);
        }
        
        protected ReadOnlyCollection<IWebElement> GetWebElements(By selector)
        {
            return this.Driver.FindElements(selector);
        }
    }
}