package mingshu.librarian;

import com.axelor.app.AxelorModule;
import mingshu.librarian.service.*;

public class LibrarianModule extends AxelorModule {

    @Override
    protected void configure() {
        bind(ReaderService.class).to(ReaderServiceImpl.class);
        bind(BorrowingService.class).to(BorrowingServiceImpl.class);
    }
}