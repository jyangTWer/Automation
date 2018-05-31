using System;
using System.Collections;
using System.Configuration;
using System.IO;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Remote;
using TechTalk.SpecFlow;

namespace Specflow.StepsDefinations
{
    [Binding]
    public class Event
    {
        public static IWebDriver _driver { get; set; }

        [BeforeScenario]
        public void BeforeScenario()
        {
            _driver = CreateChromDriver(ConfigurationManager.AppSettings["chromeDriverPath"]);
            _driver.Manage().Cookies.DeleteAllCookies();
            ScenarioContext.Current["_driver"] = _driver;
        }

        private static IWebDriver CreateChromDriver(string chromeDriverPath)
        {
            IWebDriver driver;
            var arrayList = new ArrayList { "--disable-glsl-translator --start-maximized --automation-reinitialize-on-channel-error --bwsi --assert-test --test-type --disable-logging --disable-plugins --disable-translate --disable-web-security" };
            var desiredCapabilities = DesiredCapabilities.Chrome();
            var chromeOptions = new ChromeOptions();
            chromeOptions.AddArguments("test-type");
            chromeOptions.AddArgument("--start-maximized");
            chromeOptions.AddArguments("disable-infobars");

            var perfLogPrefs = new ChromePerformanceLoggingPreferences();
            perfLogPrefs.AddTracingCategories(new string[] { "devtools.network" });

            chromeOptions.AddAdditionalCapability(CapabilityType.EnableProfiling, true, true);
            //chromeOptions.PerformanceLoggingPreferences = perfLogPrefs;
            chromeOptions.SetLoggingPreference("performance", LogLevel.All);
            chromeOptions.AddUserProfilePreference("intl.accept_languages", "en-AU");
            desiredCapabilities.SetCapability("download.prompt_for_download", false);
            //desiredCapabilities.SetCapability("download.default_directory", browserDownloadDir);
            desiredCapabilities.SetCapability("disable-extensions", true);
            desiredCapabilities.SetCapability("chrome.switches", arrayList);

            var baseExecutingAssemblyDir = Path.GetDirectoryName(new Uri(System.Reflection.Assembly.GetExecutingAssembly().CodeBase).LocalPath);
            var commandTimeout = new TimeSpan(0, 0, 60);
            driver = new ChromeDriver(Path.Combine(baseExecutingAssemblyDir ?? string.Empty, chromeDriverPath), chromeOptions, commandTimeout);

            return driver;
        }

        [AfterScenario]
        public void AfterScenario()
        {
            _driver.Dispose();
        }
    }
}
