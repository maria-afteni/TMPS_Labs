package Domain.Production.Patterns.Behavioral.Template_Method;

import Domain.Production.Patterns.Creational.BookPrototype;
import Domain.Production.Patterns.Creational.EBookPrototype;

class EbookMenuHandler extends BookMenuHandler {

    @Override
    protected BookPrototype getBookManager() {
        return new EBookPrototype();
    }
}