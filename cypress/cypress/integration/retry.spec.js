describe("retry test", () => {
  it("Can retry the fist command", () => {
    cy.visit('/');
    cy.get('#random-number') // <div>🎁</div>
      .invoke('text')        // "🎁"
      .then(parseFloat)      // NaN
      .should('be.gte', 1)   // fails
      .and('be.lte', 10)     // never evaluates
  });
});
