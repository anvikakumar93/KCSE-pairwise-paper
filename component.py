import xml.sax


class ComponentHandler(xml.sax.ContentHandler):
    def __init__(self):
        self.CurrentData = ""
        self.type = ""
        self.version = ""
        self.year = ""
        self.dependency = ""
        self.flags = ""
        self.description = ""

    # Call when an element starts
    def startElement(self, tag, attributes):
        self.CurrentData = tag
        if tag == "component":
            print "Component"
            title = attributes["title"]
            print "Title:", title

    # Call when an elements ends
    def endElement(self, tag):
        if self.CurrentData == "type":
            print "Type:", self.type
        elif self.CurrentData == "version":
            print "Version:", self.version
        elif self.CurrentData == "year":
            print "Year:", self.year
        elif self.CurrentData == "dependency":
            print "Dependency:", self.dependency
        elif self.CurrentData == "flags":
            print "Flags:", self.flags
        elif self.CurrentData == "description":
            print "Description:", self.description
        self.CurrentData = ""

    # Call when a character is read
    def characters(self, content):
        if self.CurrentData == "type":
            self.type = content
        elif self.CurrentData == "version":
            self.version = content
        elif self.CurrentData == "year":
            self.year = content
        elif self.CurrentData == "dependency":
            self.dependency = content
        elif self.CurrentData == "flags":
            self.flags = content
        elif self.CurrentData == "description":
            self.description = content


if (__name__ == "__main__"):
    # create an XMLReader
    parser = xml.sax.make_parser()
    # turn off namepsaces
    parser.setFeature(xml.sax.handler.feature_namespaces, 0)

    # override the default ContextHandler
    Handler = ComponentHandler()
    parser.setContentHandler(Handler)

    parser.parse("component.xml")