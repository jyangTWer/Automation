import HomePage from './pages/HomePage';

describe("Form test", () => {
  it("Can fill the form", () => {
    const home = new HomePage();
    home.signIn();
    home.contains("Form saved!");
  });
});
