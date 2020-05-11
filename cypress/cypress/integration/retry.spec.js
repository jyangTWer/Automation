describe("retry test", () => {
  it("Can retry the fist command", () => {
    cy.visit(Cypress.env("test"));
    cy.get("[href='https://www.thoughtworks.com/what-we-do']").debug();
    cy.url().contains("/what-we-do");
  });
});
