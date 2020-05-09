describe("retry test", () => {
  it("Can retry the fist command", () => {
    cy.visit('/');
    cy.get("[href='https://www.thoughtworks.com/what-we-do']").click();
    cy.url().contains("/what-we-do");
  });
});
