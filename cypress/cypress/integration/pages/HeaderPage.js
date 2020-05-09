class HeaderPage {
  visit() {
    cy.visit('/');
  }

  Search(string content) {
    cy.get("button.search__button").click();
    cy.get(".opacity-entrance-animation.search-bar__query").type(content);
    cy.get(".opacity-entrance-animation.search-bar__button").click();
  }

  results() {
    return cy.get(`[data-testid=SignInEmailError]`);
  }
}

export default HeaderPage;
