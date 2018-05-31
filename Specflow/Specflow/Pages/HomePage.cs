using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using OpenQA.Selenium;

namespace Specflow.Pages
{
    public class HomePage: BasePageModel
    {
        public HomePage(IWebDriver driver)
            : base(driver)
        {
        }

        #region Selector
        private readonly By _links = By.CssSelector("#main-menu a");
        private readonly By _records = By.CssSelector(".section-links a");


        #endregion

        #region Actions

        public void GoTo(string expectedLink)
        {
            var links = GetWebElements(_links);
            foreach (var link in links)
            {
                if (expectedLink.Equals(link.Text))
                {
                    link.Click();
                    break;
                }
            }
        }
        
        #endregion

        public int links_count()
        {
            return GetWebElements(_records).Count;
        }
    }
}
