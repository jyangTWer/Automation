class HomePage {
  constructor() {
    cy.visit('/');
  }

  signIn() {
    cy.get('input[name="name"]')
      .type("Molly")
      .should("have.value", "Molly");

    cy.get('input[name="email"]')
      .type("molly@dev.dev")
      .should("have.value", "molly@dev.dev");

    cy.get("textarea")
      .type("Mind you if I ask some silly question?")
      .should("have.value", "Mind you if I ask some silly question?");

    cy.server();
    cy.route("POST", "/users/**", { status: "Form saved!", code: 201 });

    cy.get("form").submit();
  }

  contains() {
    cy.contains("Form saved!");
  }
}

export default HomePage;
