describe("retry test", () => {
  it("Can retry the fist command", () => {
    cy.visit('/');
    cy.get('#random-number')
      .should(($div) => {
        // all the code inside here will retry
        // until it passes or times out
        const n = parseFloat($div.text())

        expect(n).to.be.gte(1).and.be.lte(10)
      })
  });
});
