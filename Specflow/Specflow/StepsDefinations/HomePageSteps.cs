using System.Configuration;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using Specflow.Pages;
using TechTalk.SpecFlow;

namespace StepsDefinations
{
    [Binding]
    public class HomePageSteps: Steps
    {

        readonly IWebDriver _driver;

        private readonly HomePage _homePage;

        public HomePageSteps()
        {
            _driver = (IWebDriver)ScenarioContext.Current["_driver"];
            _homePage = new HomePage(_driver);
        }

        [Given(@"Open the homepage")]
        public void GivenOpenTheHomepage()
        {
            var baseurl = ConfigurationManager.AppSettings["BaseUrl"];
            _driver.Navigate().GoToUrl(baseurl);
        }
        
        [When(@"I click the ""(.*)"" link")]
        public void WhenIClickTheLink(string link)
        {
            _homePage.GoTo(link);
        }
        
        [Then(@"I can see (.*) records")]
        public void ThenICanSeeRecords(int p0)
        {
            Assert.AreEqual(_homePage.links_count(), p0);
        }
    }
}
