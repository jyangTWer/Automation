describe("Form test", () => {
  it("Can fill the form", () => {
    cy.visit('/');
    cy.login("Molly", "molly@dev.dev", "Mind you if I ask some silly question?")
    cy.contains("Form saved!");
  });
});
