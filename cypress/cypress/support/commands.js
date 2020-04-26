// ***********************************************
// This example commands.js shows you how to
// create various custom commands and overwrite
// existing commands.
//
// For more comprehensive examples of custom
// commands please read more here:
// https://on.cypress.io/custom-commands
// ***********************************************
//
//
// -- This is a parent command --
Cypress.Commands.add("login", (email, password, message) => {
  cy.get('input[name="name"]').type(email).should("have.value", email);
  cy.get('input[name="email"]').type(password).should("have.value", password);
  cy.get("textarea").type(message).should("have.value", message);

  cy.server();
  cy.route("POST", "/users/**", { status: "Form saved!", code: 201 });

  cy.get("form").submit();
})


// -- This is a child command --
// Cypress.Commands.add("drag", { prevSubject: 'element'}, (subject, options) => { ... })
//
//
// -- This is a dual command --
// Cypress.Commands.add("dismiss", { prevSubject: 'optional'}, (subject, options) => { ... })
//
//
// -- This will overwrite an existing command --
// Cypress.Commands.overwrite("visit", (originalFn, url, options) => { ... })
