package Domain.Production.Patterns.Behavioral.Template_Method;

import Domain.Production.Patterns.Creational.BookPrototype;
import Domain.Production.Patterns.Creational.PhysicalBookPrototype;

class PhysicalBookMenuHandler extends BookMenuHandler {

    @Override
    protected BookPrototype getBookManager() {
        return new PhysicalBookPrototype();
    }
}