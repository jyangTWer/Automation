require 'rspec'
require 'capybara'
require 'capybara/cucumber'
require 'site_prism'
require 'pry'

require 'require_all'
require_all 'lib/pages'

Capybara.register_driver :selenium do |app|
  Capybara::Selenium::Driver.new(app, { browser: :chrome })
end

Capybara.default_driver = :selenium
Capybara.app_host = 'https://www.thoughtworks.com'
