class HomePage < SitePrism::Page
  set_url '/'

  elements :links, '#main-menu a'
  elements :section_links, '.section-links a'

  def goto destination
    links.each do |link|
      if destination == link.text
        link.click
        break
      end
    end
  end

  def links_count
    section_links.count
  end
end
