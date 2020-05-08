describe("Form test", () => {
  it("Can fill the form", () => {
    cy.visit('/');
    cy.get("button.search__button").click();
    cy.get(".opacity-entrance-animation.search-bar__query").type("BDD");
    cy.get(".opacity-entrance-animation.search-bar__button").click();
    cy.contains("Applying BDD acceptance criteria in user stories | ThoughtWorks");
  });
});
