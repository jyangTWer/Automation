import Header from './pages/HeaderPage';

describe("Form test", () => {
  it("Can fill the form", () => {
    const header = new Header();
    header.visit();
    header.Search("BDD");
    header.results()
      .should('exist')
      .contains("Applying BDD acceptance criteria in user stories | ThoughtWorks");
  });
});
