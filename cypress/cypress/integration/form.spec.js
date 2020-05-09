describe("Form test", () => {
  it("Can fill the form", () => {
    cy.visit('/');
    cy.search("BDD");
    cy.contains("Applying BDD acceptance criteria in user stories | ThoughtWorks");
  });

  it("Search BDD", () => {
    cy.visit('/');
    cy.search("BDD");
    cy.contains("Applying BDD acceptance criteria in user stories | ThoughtWorks");
  });
});
