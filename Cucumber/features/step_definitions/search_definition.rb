Given("Open the homepage") do
  @homepage = HomePage.new
  @homepage.load
end

When("I click the {string} link") do |link|
  @homepage.goto link
end

Then("I can see {int} records") do |count|
  expect(@homepage.links_count).to eq count
end
